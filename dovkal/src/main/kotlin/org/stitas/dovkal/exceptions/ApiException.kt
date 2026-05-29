package org.stitas.dovkal.exceptions

import org.springframework.http.HttpStatus

open class ApiException(
    override val message: String,
    open val httpStatus: HttpStatus,
    override val cause: Throwable? = null
) : RuntimeException(message, cause) {
}