package com.janz.hexarchksb_ecommerce.application.ports.driving.services

import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.LoginUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.ResponseUserDto

interface UserService {
    suspend fun validateEmail(email: String)
    suspend fun createUser(user: CreateUserDto)
    suspend fun login(user: LoginUserDto) : ResponseUserDto
}