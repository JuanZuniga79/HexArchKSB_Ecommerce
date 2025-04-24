package com.janz.hexarchksb_ecommerce.infrastructure.models.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.io.Serializable

data class CreateSpecialUserDto(
    @field:NotBlank(message = "First name is required")
    val firstName: String,
    @field:NotBlank(message = "Last name is required")
    val lastName: String,
    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Email address contains invalid characters")
    val email: String,
    @field:NotBlank(message = "Document is required")
    @field:Pattern(
        regexp = "^[0-9]{8,16}$",
        message = "Document must be 8-16 number long"
    )
    val document: String,
    @field:NotBlank(message = "Password is required")
    @field:Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,16}$",
        message = "Password must be 8-16 characters, include a letter, a number, and a special character"
    )
    val password: String,
    @field:NotBlank(message = "Role is required")
    @field:Min(value = 1, message = "Role id must be greater than 1")
    val roleId: Int,
) : Serializable
