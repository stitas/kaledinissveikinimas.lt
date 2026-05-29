package org.stitas.dovkal.exceptions

import org.springframework.http.HttpStatus

class StripeIntegrationException(
    override val message: String = "Stripe integration failed",
    override val cause: Throwable? = null,
    override val httpStatus: HttpStatus = HttpStatus.BAD_GATEWAY,
) : ApiException(message, httpStatus, cause) {
}