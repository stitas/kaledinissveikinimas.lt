package org.stitas.dovkal.controllers.video

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.stitas.dovkal.controllers.video.dto.VideoUrlResponseDto
import org.stitas.dovkal.integrations.heygen.HeyGenService
import java.util.UUID

@RestController
@RequestMapping("/api/v1/video")
class VideoController(
    private val heyGenService: HeyGenService
) {

    @PostMapping("/hook")
    fun heyGenWebhook(
        @RequestBody payload: String,
        @RequestHeader("Heygen-Signature") heyGenSignature: String,
    ): ResponseEntity<Void> {
        heyGenService.handleWebhook(payload, heyGenSignature)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{orderId}")
    fun getVideoUrl(@PathVariable orderId: UUID): VideoUrlResponseDto {
        val videoUrl = heyGenService.getVideoUrl(orderId)
        return VideoUrlResponseDto(videoUrl)
    }

}