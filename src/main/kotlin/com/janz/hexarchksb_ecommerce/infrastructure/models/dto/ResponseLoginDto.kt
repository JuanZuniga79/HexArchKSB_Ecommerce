package com.janz.hexarchksb_ecommerce.infrastructure.models.dto

import java.io.Serializable

data class ResponseLoginDto(
    val user: ResponseUserDto,
    val token: String
) : Serializable
