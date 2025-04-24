package com.janz.hexarchksb_ecommerce.application.useCases

import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.LoginUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.ResponseUserDto

interface UserUseCase {
    suspend fun createUser(user: CreateUserDto, role: Int? = null): ResponseUserDto
    suspend fun validateEmail(email: String)
    suspend fun loginUser(user: LoginUserDto): ResponseUserDto
}