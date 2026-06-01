package org.stitas.dovkal.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("email")
data class EmailProperties(
    val from: String,
    val fromName: String,
    val frontendDownloadUrl: String,
)
