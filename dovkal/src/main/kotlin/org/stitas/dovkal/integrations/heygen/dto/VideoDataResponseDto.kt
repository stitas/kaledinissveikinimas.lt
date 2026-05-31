package org.stitas.dovkal.integrations.heygen.dto


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class VideoDataResponseDto(
    val data: VideoDataDto
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class VideoDataDto(
    @JsonProperty("video_url")
    val videoUrl: String,
)