package org.stitas.dovkal.exceptions

import org.springframework.http.HttpStatus

class EmailSendingException(
    override val message: String = "Email sending failed",
    override val cause: Throwable? = null,
    override val httpStatus: HttpStatus = HttpStatus.BAD_GATEWAY,
) : ApiException(message, httpStatus, cause)