package org.stitas.dovkal.integrations.heygen.dto


import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class VideoDataResponseDto(
    val data: VideoDataDto
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class VideoDataDto(
    @JsonAlias("video_url")
    val videoUrl: String,

    @JsonAlias("thumbnail_url")
    val thumbnailUrl: String,
)