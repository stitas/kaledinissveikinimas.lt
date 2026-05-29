package org.stitas.dovkal.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("stripe")
data class StripeProperties(
    val secret: String,
    val webhookSecret: String,
    val greeting375PriceId: String,
    val greeting750PriceId: String,
    val greeting1125PriceId: String,
    val greeting1500PriceId: String,
    val successUrl: String,
    val cancelUrl: String,
)
