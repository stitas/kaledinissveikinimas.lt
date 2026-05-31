package org.stitas.dovkal.integrations.heygen.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.stitas.dovkal.enums.SantaType

data class VideoGenerationRequestDto(
    val type: String = "avatar",
    @JsonProperty("avatar_id")
    val avatarId: String,
    @JsonProperty("voice_id")
    val voiceId: String = SantaType.VOICE_ID,
    val script: String,
    val title: String = "Kalėdų senelio video sveikinimas",
    val resolution: String = "1080p",
    @JsonProperty("aspect_ratio")
    val aspectRatio: String = "16:9",
    @JsonProperty("voice_settings")
    val voiceGenerationSettingsDto: VoiceGenerationSettingsDto
)

data class VoiceGenerationSettingsDto(
    val speed: Int = 1,
    val pitch: Int = 0,
    val volume: Int = 1,
    val locale: String,
)

data class VideoGenerationResponseDto(
    val data: VideoGenerationDataDto
)

data class VideoGenerationDataDto(
    @JsonProperty("video_id")
    val videoId: String
)