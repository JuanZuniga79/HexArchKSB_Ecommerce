package com.janz.hexarchksb_ecommerce.application.utils

import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto

object GeneratorUtil {
    suspend fun generateUsername(user: CreateUserDto): String{
        val sanitizedName = user.firstName
            .lowercase()
            .replace("\\s+".toRegex(), "")
        val randomNumber = (1000..9999).random()
        return "${sanitizedName}${randomNumber}"
    }
}