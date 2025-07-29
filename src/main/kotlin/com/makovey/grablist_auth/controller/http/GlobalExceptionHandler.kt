package com.makovey.grablist_auth.controller.http

import com.makovey.grablist_auth.exception.RoleNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    companion object {
        private const val BASE_INTERNAL_SERVER_ERROR = "Internal Server Error"
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, String?> {
        val errors = mutableMapOf<String, String?>()
        ex.bindingResult.allErrors.forEach { error ->
            val fieldName = (error as? FieldError)?.field
            errors[fieldName ?: error.objectName] = error.defaultMessage
        }
        return errors
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RoleNotFoundException::class)
    fun roleNotFoundException(ex: RoleNotFoundException): ResponseEntity<Map<String, String>> {
        val message = ex.message ?: BASE_INTERNAL_SERVER_ERROR

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(mapOf("error" to message))
    }
}