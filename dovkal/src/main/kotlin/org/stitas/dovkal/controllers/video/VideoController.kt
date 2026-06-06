package org.stitas.dovkal.controllers.video

import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.stitas.dovkal.integrations.heygen.HeyGenService
import org.stitas.dovkal.integrations.heygen.dto.VideoDataDto
import java.util.UUID

@RestController
@RequestMapping("/api/v1/video")
class VideoController(
    private val heyGenService: HeyGenService,
) {

    @PostMapping("/hook")
    fun heyGenWebhook(
        @RequestBody payload: String,
        @RequestHeader headers: HttpHeaders,
    ): ResponseEntity<Void> {
        log.info("HeyGen webhook received. headerNames={}", headers.headerNames())

        val heyGenSignature =
            headers.getFirst("Heygen-Signature")
                ?: headers.getFirst("X-Heygen-Signature")
                ?: headers.getFirst("signature")

        val heyGenTimestamp = headers.getFirst("Heygen-Timestamp")
        val heyGenEventId = headers.getFirst("Heygen-Event-Id")

        heyGenService.handleWebhook(
            payload = payload,
            heyGenSignature = heyGenSignature,
            heyGenTimestamp = heyGenTimestamp,
            heyGenEventId = heyGenEventId,
        )

        return ResponseEntity.ok().build()
    }

    @GetMapping("/{orderId}")
    fun getVideoUrl(@PathVariable orderId: UUID): VideoDataDto {
        return heyGenService.getVideoUrl(orderId)
    }

    companion object {
        private val log = LoggerFactory.getLogger(VideoController::class.java)
    }
}