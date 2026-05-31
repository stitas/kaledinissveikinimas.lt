package org.stitas.dovkal.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("heygen")
data class HeyGenProperties(
    val baseUrl: String,
    val apiKey: String,
    val webhookSecret: String,
)
