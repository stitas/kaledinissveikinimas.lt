package org.stitas.dovkal.integrations.stripe

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.stitas.dovkal.exceptions.StripeIntegrationException
import org.stitas.dovkal.integrations.stripe.dto.CheckoutSession
import org.stitas.dovkal.properties.StripeProperties

@Service
class StripeService(
    private val stripeApiClient: StripeApiClient,
    private val stripeProperties: StripeProperties,
) {
    fun createCheckoutSession(email: String, messageSize: Int): CheckoutSession {
        val priceId = when {
            messageSize < 1 -> throw StripeIntegrationException(message = "Message too short", httpStatus = HttpStatus.BAD_REQUEST)
            messageSize < 375 -> stripeProperties.greeting375PriceId
            messageSize < 750 -> stripeProperties.greeting750PriceId
            messageSize < 1125 -> stripeProperties.greeting1125PriceId
            messageSize < 1500 -> stripeProperties.greeting1500PriceId
            else -> throw StripeIntegrationException(message = "Message too long", httpStatus = HttpStatus.BAD_REQUEST)
        }

        return stripeApiClient.createCheckoutSession(priceId, email, stripeProperties.successUrl, stripeProperties.cancelUrl)
    }
}