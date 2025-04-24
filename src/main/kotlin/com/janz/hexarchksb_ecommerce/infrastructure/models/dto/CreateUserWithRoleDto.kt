package com.janz.hexarchksb_ecommerce.infrastructure.models.dto

import java.io.Serializable

data class CreateUserWithRoleDto(
    val user: CreateUserDto,
    val roleId: Int
) : Serializable