package org.stitas.dovkal.integrations.stripe

import com.stripe.exception.SignatureVerificationException
import com.stripe.model.Event
import com.stripe.model.checkout.Session
import com.stripe.net.Webhook
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.stitas.dovkal.controllers.payment.dto.CheckoutRequestDto
import org.stitas.dovkal.enums.OrderStatus
import org.stitas.dovkal.exceptions.StripeIntegrationException
import org.stitas.dovkal.models.Order
import org.stitas.dovkal.properties.StripeProperties
import org.stitas.dovkal.services.OrderService

@Service
class StripeService(
    private val stripeApiClient: StripeApiClient,
    private val stripeProperties: StripeProperties,
    private val orderService: OrderService,
) {
    fun createCheckoutSession(checkoutRequestDto: CheckoutRequestDto): String {
        log.info("Checkout session request by user={}", checkoutRequestDto.email)

        val scriptSize = checkoutRequestDto.script.length
        val priceId = when {
            scriptSize < 1 -> throw StripeIntegrationException(message = "Message too short", httpStatus = HttpStatus.BAD_REQUEST)
            scriptSize < 375 -> stripeProperties.greeting375PriceId
            scriptSize < 750 -> stripeProperties.greeting750PriceId
            scriptSize < 1125 -> stripeProperties.greeting1125PriceId
            scriptSize < 1500 -> stripeProperties.greeting1500PriceId
            else -> throw StripeIntegrationException(message = "Message too long", httpStatus = HttpStatus.BAD_REQUEST)
        }

        val checkoutSession = stripeApiClient.createCheckoutSession(priceId, checkoutRequestDto.email, stripeProperties.successUrl, stripeProperties.cancelUrl)

        val order = Order(
            stripeCheckoutId = checkoutSession.stripeCheckoutId,
            email = checkoutRequestDto.email,
            santaType = checkoutRequestDto.santaType,
            status = OrderStatus.WAITING_PAYMENT,
            script = checkoutRequestDto.script,
            scriptSize = scriptSize,
            locale = checkoutRequestDto.locale,
        )
        orderService.save(order)

        log.info("Checkout session stripeCheckoutId={} created for user={}", checkoutSession.stripeCheckoutId, checkoutRequestDto.email)

        return checkoutSession.stripeCheckoutUrl
    }

    fun handleWebhook(payload: String, stripeSignature: String) {
        val event = constructEvent(payload, stripeSignature)

        when (event.type) {
            "checkout.session.completed" -> {
                val session = extractSessionFromEvent(event)
                handleCheckoutSessionCompleted(session)
            }
            "checkout.session.expired" -> {
                val session = extractSessionFromEvent(event)
                handleCheckoutSessionExpired(session)
            }
            else -> return // Do nothing for unhandled webhooks
        }
    }

    private fun constructEvent(payload: String, stripeSignature: String): Event {
        return try {
            Webhook.constructEvent(payload, stripeSignature, stripeProperties.webhookSecret)
        } catch (e: SignatureVerificationException) {
            log.error("Stripe signature verification failed", e)
            throw StripeIntegrationException("Stripe signature verification failed", e, HttpStatus.BAD_REQUEST)
        } catch (e: Exception) {
            log.error("Failure while getting event from Stripe webhook", e)
            throw StripeIntegrationException("Failure while getting event from Stripe webhook", e, HttpStatus.BAD_REQUEST)
        }
    }

    private fun extractSessionFromEvent(event: Event): Session {
        val stripeObject = event.dataObjectDeserializer.`object`.orElseThrow {
            log.error("Could not deserialize Stripe event object. Check Stripe API version")
            StripeIntegrationException(message = "Could not deserialize Stripe event object", httpStatus = HttpStatus.BAD_REQUEST)
        }

        return stripeObject as? Session ?: run {
            log.error("Could not cast deserialized stripe object to Session")
            throw StripeIntegrationException(message = "Could not cast deserialized stripe object to Session", httpStatus = HttpStatus.BAD_REQUEST)
        }
    }

    fun handleCheckoutSessionCompleted(session: Session) {
        val order = orderService.findByStripeCheckoutId(session.id) ?: run {
            log.error("Failed to handle checkout session completed. Order with stripeCheckoutId={} not found", session.id)
            throw StripeIntegrationException(message = "Order not found by Stripe checkout id", httpStatus = HttpStatus.BAD_REQUEST)
        }

        orderService.changeOrderStatus(order, OrderStatus.PAID)
        orderService.save(order)

        // TODO create video creation job and pass in order id
    }

    fun handleCheckoutSessionExpired(session: Session) {
        val order = orderService.findByStripeCheckoutId(session.id) ?: run {
            log.warn("Failed to handle checkout session expired. Order not with stripeCheckoutId={} not found", session.id)
            throw StripeIntegrationException(message = "Order not found by Stripe checkout id", httpStatus = HttpStatus.BAD_REQUEST)
        }

        orderService.changeOrderStatus(order, OrderStatus.EXPIRED)
        orderService.save(order)
    }

    companion object {
        private val log = LoggerFactory.getLogger(StripeService::class.java)
    }
}