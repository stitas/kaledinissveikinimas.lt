package org.stitas.dovkal.integrations.stripe

import com.stripe.StripeClient
import com.stripe.exception.StripeException
import com.stripe.param.checkout.SessionCreateParams
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.stitas.dovkal.exceptions.StripeIntegrationException
import org.stitas.dovkal.integrations.stripe.dto.CheckoutSession

@Service
class StripeApiClient(
    private val stripeClient: StripeClient,
) {

    fun createCheckoutSession(priceId: String, email: String, successUrl: String, cancelUrl: String): CheckoutSession {
        val params = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setCustomerEmail(email)
            .setSuccessUrl(successUrl)
            .setCancelUrl(cancelUrl)
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setPrice(priceId)
                    .setQuantity(1L)
                    .build()
            )
            .build()

        val session = try {
            stripeClient.v1().checkout().sessions().create(params)
        } catch (e: StripeException) {
            log.error("Failed to create stripe checkout session for email={}", email, e)
            throw StripeIntegrationException("Failed to create stripe checkout session", e)
        }

        return CheckoutSession(session.id, session.url)
    }

    companion object {
        private val log = LoggerFactory.getLogger(StripeApiClient::class.java)
    }
}