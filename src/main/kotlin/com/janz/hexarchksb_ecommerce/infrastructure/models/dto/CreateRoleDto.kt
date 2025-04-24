package com.janz.hexarchksb_ecommerce.infrastructure.models.dto

import java.io.Serializable

data class CreateRoleDto(val name: String? = null, val description: String? = "no description") : Serializable