package com.janz.hexarchksb_ecommerce.application.ports.driving.services

import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto

interface UserService {
    suspend fun validateEmail(email: String)
    suspend fun createUser(user: CreateUserDto)
}