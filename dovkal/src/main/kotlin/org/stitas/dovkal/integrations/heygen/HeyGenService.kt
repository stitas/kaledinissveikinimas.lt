package org.stitas.dovkal.integrations.heygen

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.stitas.dovkal.enums.OrderStatus
import org.stitas.dovkal.exceptions.HeyGenIntegrationException
import org.stitas.dovkal.integrations.heygen.dto.AvatarVideoEventDataDto
import org.stitas.dovkal.integrations.heygen.dto.HeyGenWebhookEnvelopeDto
import org.stitas.dovkal.models.Order
import org.stitas.dovkal.properties.HeyGenProperties
import org.stitas.dovkal.services.OrderService
import org.stitas.dovkal.services.CustomerEmailService
import tools.jackson.databind.ObjectMapper
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.UUID
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.jvm.java

@Service
class HeyGenService(
    private val heyGenApiClient: HeyGenApiClient,
    private val heyGenProperties: HeyGenProperties,
    private val orderService: OrderService,
    private val objectMapper: ObjectMapper,
    private val emailService: CustomerEmailService,
) {
    fun sendVideoGenerationRequest(order: Order) {
        val heyGenVideoId = heyGenApiClient.sendVideoGenerationRequest(order.santaType, order.script, order.locale.code)

        order.heyGenVideoId = heyGenVideoId
        orderService.changeOrderStatus(order, OrderStatus.PROCESSING)
        orderService.save(order)
    }

    fun getVideoUrl(orderId: UUID): String {
        val order = orderService.findByOrderId(orderId) ?: throw HeyGenIntegrationException("Order not found", httpStatus = HttpStatus.NOT_FOUND)
        val videoId = order.heyGenVideoId ?: throw HeyGenIntegrationException("Video does not exist", httpStatus = HttpStatus.NOT_FOUND)
        return heyGenApiClient.getVideoUrl(videoId)
    }

    fun handleWebhook(payload: String, heyGenSignature: String) {
        log.info("HeyGen webhook received. Validating...")
        validateSignature(payload, heyGenSignature)
        log.info("HeyGen webhook signature verified successfully")

        val envelope = objectMapper.readValue(payload,HeyGenWebhookEnvelopeDto::class.java)

        when (envelope.eventType) {
            "avatar_video.success" -> {
                val order = processOrderBasedOnEvent(envelope, OrderStatus.DONE) ?: return
                log.info("HeyGen avatar video completed successfully. orderId={}", order.id)
                emailService.sendVideoReadyEmail(order.email, order.id)
            }
            "avatar_video.fail" -> {
                val order = processOrderBasedOnEvent(envelope, OrderStatus.ERROR) ?: return
                log.error("HeyGen avatar video generation failed. orderId={}, event_data={}", order.id, envelope.eventData)
            }
            else -> return
        }
    }

    private fun validateSignature(
        payload: String,
        heyGenSignature: String,
    ) {
        val expectedSignature = calculateHmacSha256Hex(heyGenProperties.webhookSecret, payload)

        val providedSignatureBytes = hexToBytes(heyGenSignature)
        val expectedSignatureBytes = hexToBytes(expectedSignature)

        if (!MessageDigest.isEqual(providedSignatureBytes, expectedSignatureBytes)) {
            log.error("HeyGen webhook rejected because signature verification failed")
            throw HeyGenIntegrationException(message = "Invalid HeyGen webhook signature", httpStatus = HttpStatus.UNAUTHORIZED)
        }
    }

    private fun calculateHmacSha256Hex(secret: String, payload: String): String {
        val secretKey = SecretKeySpec(secret.toByteArray(StandardCharsets.UTF_8),"HmacSHA256")
        val mac = Mac.getInstance("HmacSHA256")
        mac.init(secretKey)

        return mac.doFinal(payload.toByteArray(StandardCharsets.UTF_8))
            .joinToString(separator = "") { byte -> "%02x".format(byte) }
    }

    private fun hexToBytes(hex: String): ByteArray {
        if (hex.length % 2 != 0) {
            throw HeyGenIntegrationException(message = "Invalid HeyGen signature format",  httpStatus = HttpStatus.BAD_REQUEST)
        }

        return try {
            hex.chunked(2)
                .map { it.toInt(16).toByte() }
                .toByteArray()
        } catch (e: Exception) {
            throw HeyGenIntegrationException("Invalid HeyGen signature format", e, HttpStatus.BAD_REQUEST)
        }
    }

    private fun processOrderBasedOnEvent(eventEnvelope: HeyGenWebhookEnvelopeDto, orderStatus: OrderStatus): Order? {
        log.info("Processing order from webhook event={}", eventEnvelope.eventType)

        val eventData = eventEnvelope.eventData ?: run {
            log.error("HeyGen webhook responded with missing event_data")
            throw HeyGenIntegrationException(message = "Missing HeyGen event_data", httpStatus = HttpStatus.BAD_REQUEST)
        }

        val data = objectMapper.treeToValue(eventData, AvatarVideoEventDataDto::class.java)

        val order = orderService.findByHeyGenVideoId(data.videoId) ?: run {
            log.error("Video ID received from HeyGen webhook not found in DB. videoId={}", data.videoId)
            throw HeyGenIntegrationException(message = "Video ID from webhook not found", httpStatus = HttpStatus.BAD_REQUEST)
        }

        if (order.status != OrderStatus.PROCESSING) {
            log.warn("Duplicate HeyGen webhook event received for videoId={}, event_data={}", data.videoId, eventData)
            return null
        }

        orderService.changeOrderStatus(order, orderStatus)
        orderService.save(order)
        return order
    }

    companion object {
        private val log = LoggerFactory.getLogger(HeyGenService::class.java)
    }
}