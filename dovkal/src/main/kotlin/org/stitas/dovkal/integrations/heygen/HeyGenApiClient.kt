package org.stitas.dovkal.integrations.heygen

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatusCode
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Service
import org.springframework.util.StreamUtils
import org.springframework.web.client.RestClient
import org.stitas.dovkal.enums.SantaType
import org.stitas.dovkal.exceptions.HeyGenIntegrationException
import org.stitas.dovkal.integrations.heygen.dto.VideoDataResponseDto
import org.stitas.dovkal.integrations.heygen.dto.VideoGenerationRequestDto
import org.stitas.dovkal.integrations.heygen.dto.VideoGenerationResponseDto
import org.stitas.dovkal.integrations.heygen.dto.VoiceGenerationSettingsDto
import java.nio.charset.StandardCharsets

@Service
class HeyGenApiClient(
    private val heyGenRestClient: RestClient
) {

    fun sendVideoGenerationRequest(santaType: SantaType, script: String, locale: String): String {
        log.info("Sending video generation request to HeyGen for santaType={}", santaType.name)
        val requestBody = VideoGenerationRequestDto(
            avatarId = santaType.avatarId,
            script = script,
            voiceGenerationSettingsDto = VoiceGenerationSettingsDto(locale = locale)
        )

        val response = heyGenRestClient.post()
            .uri("/v3/videos")
            .body(requestBody)
            .retrieve()
            .onStatus(HttpStatusCode::isError) { request, response ->
                val responseBody = getResponseBody(response)

                log.error(
                    "HeyGen video generation request failed. method={}, uri={}, status={}, responseBody={}",
                    request.method,
                    request.uri,
                    response.statusCode,
                    responseBody
                )

                throw HeyGenIntegrationException("HeyGen video generation request failed and responded with status ${response.statusCode}")
            }
            .body(VideoGenerationResponseDto::class.java) ?: run {
                log.error("HeyGen video generation response returned empty body")
                throw HeyGenIntegrationException("HeyGen video generation response returned empty body")
            }

        log.info("Video generation request to HeyGen sent successfully videoId={}", response.data.videoId)
        return response.data.videoId
    }

    fun getVideoUrl(videoId: String): String {
        val response = heyGenRestClient.get()
            .uri("/v3/videos/${videoId}")
            .retrieve()
            .onStatus(HttpStatusCode::isError) { request, response ->
                val responseBody = getResponseBody(response)

                log.error(
                    "HeyGen get video data request failed. method={}, uri={}, status={}, responseBody={}",
                    request.method,
                    request.uri,
                    response.statusCode,
                    responseBody
                )

                throw HeyGenIntegrationException("HeyGen get video data request failed and responded with status ${response.statusCode}")
            }
            .body(VideoDataResponseDto::class.java) ?: run {
                log.error("HeyGen get video data response returned empty body")
                throw HeyGenIntegrationException("HeyGen get video data response returned empty body")
            }

        return response.data.videoUrl
    }

    private fun getResponseBody(response: ClientHttpResponse): String {
        return runCatching {
            StreamUtils.copyToString(response.body, StandardCharsets.UTF_8)
        }.getOrDefault("<could not read response body>")
    }

    companion object {
        private val log = LoggerFactory.getLogger(HeyGenApiClient::class.java)
    }
}