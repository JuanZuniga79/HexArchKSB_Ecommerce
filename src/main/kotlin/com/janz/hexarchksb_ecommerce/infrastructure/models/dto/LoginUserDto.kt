package com.janz.hexarchksb_ecommerce.infrastructure.models.dto

import jakarta.validation.constraints.Email
import java.io.Serializable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class LoginUserDto(
    @field:NotBlank(message = "Email must not be blank")
    @field:Email(message = "Email address contains invalid characters")
    val email: String,
    @field:NotBlank(message = "Password is required")
    @field:Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,16}$",
        message = "Password must be 8-16 characters, include a letter, a number, and a special character"
    )
    val password: String
) : Serializable
