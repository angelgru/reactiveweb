package com.microservices.reactiveweb

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import reactor.netty.http.server.HttpServerRequest
import java.lang.Exception

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(CustomerNotFoundException::class)
    fun handleCustomerNotFoundException(
            httpServletRequest: HttpServerRequest,
            exception: Exception): ResponseEntity<ExceptionDetails>
            = ResponseEntity(ExceptionDetails(exception.message, exception),HttpStatus.NOT_FOUND)

    data class ExceptionDetails(val message: String?, val exception: Exception)
}