package org.stitas.dovkal.integrations.heygen.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import tools.jackson.databind.JsonNode

@JsonIgnoreProperties(ignoreUnknown = true)
data class HeyGenWebhookEnvelopeDto(

    @JsonProperty("event_type")
    val eventType: String,

    @JsonProperty("event_data")
    val eventData: JsonNode? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class AvatarVideoEventDataDto(
    @JsonProperty("video_id")
    val videoId: String
)