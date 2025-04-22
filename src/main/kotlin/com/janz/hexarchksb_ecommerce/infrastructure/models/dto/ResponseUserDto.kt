package com.janz.hexarchksb_ecommerce.infrastructure.models.dto

import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.ResponseRoleDto
import java.io.Serializable
import java.util.*

/**
 * DTO for {@link com.janz.hexarchksb_ecommerce.infrastructure.entities.UserEntity}
 */
data class ResponseUserDto(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val username: String,
    val password: String,
    val document: String,
    val active: Boolean = true,
    val role: ResponseRoleDto
) : Serializable