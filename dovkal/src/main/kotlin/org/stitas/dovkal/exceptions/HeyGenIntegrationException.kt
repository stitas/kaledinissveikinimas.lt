package org.stitas.dovkal.exceptions

import org.springframework.http.HttpStatus

class HeyGenIntegrationException(
    override val message: String = "HeyGen integration failed",
    override val cause: Throwable? = null,
    override val httpStatus: HttpStatus = HttpStatus.BAD_GATEWAY,
) : ApiException(message, httpStatus, cause)