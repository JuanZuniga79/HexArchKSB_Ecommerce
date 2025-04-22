package com.janz.hexarchksb_ecommerce.infrastructure.models.dto

import java.io.Serializable

/**
 * DTO for {@link com.janz.hexarchksb_ecommerce.infrastructure.entities.RoleEntity}
 */
data class ResponseRoleDto(val name: String? = null, val description: String? = "no description") : Serializable