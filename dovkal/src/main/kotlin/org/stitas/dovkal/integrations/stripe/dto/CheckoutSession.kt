package org.stitas.dovkal.integrations.stripe.dto

data class CheckoutSession(
    val stripeCheckoutId: String,
    val stripeCheckoutUrl: String,
)
