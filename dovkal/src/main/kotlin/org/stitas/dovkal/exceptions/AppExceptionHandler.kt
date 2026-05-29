package org.stitas.dovkal.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(exception: MethodArgumentNotValidException): ResponseEntity<ApiErrorResponse> {
        val firstFieldError = exception.bindingResult.fieldErrors.firstOrNull()
        val errorMessage = firstFieldError?.defaultMessage

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiErrorResponse(errorMessage))
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleInvalidJsonException(exception: HttpMessageNotReadableException): ResponseEntity<ApiErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiErrorResponse(null))
    }

    @ExceptionHandler(ApiException::class)
    fun handleApiException(exception: ApiException): ResponseEntity<ApiErrorResponse> {
        return ResponseEntity
            .status(exception.httpStatus)
            .body(ApiErrorResponse(exception.message))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ApiErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiErrorResponse(exception.message))
    }
}