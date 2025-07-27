package com.makovey.grablist_auth.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SignUpUserRequest(
    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Email should be valid")
    val email: String,

    @field:NotBlank(message = "First name is required")
    @field:Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    val firstname: String,

    @field:NotBlank(message = "Last name is required")
    @field:Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    val lastname: String,

    @field:NotBlank(message = "Phone is required")
    @field:Pattern(regexp = "^\\+?[0-9\\-\\s]+\$", message = "Phone number is invalid")
    val phone: String,

    @field:NotBlank(message = "Password is required")
    @field:Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    @field:Pattern(
        regexp = "^(?=.*[A-Z]).+\$",
        message = "Password must contain at least one uppercase letter"
    )
    val password: String
)