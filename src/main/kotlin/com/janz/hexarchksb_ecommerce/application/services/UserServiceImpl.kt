package com.janz.hexarchksb_ecommerce.application.services

import com.janz.hexarchksb_ecommerce.application.ports.driving.services.UserService
import com.janz.hexarchksb_ecommerce.application.useCases.UserUseCase
import com.janz.hexarchksb_ecommerce.application.utils.ValidationUtils
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.LoginUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.ResponseUserDto
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (private val userUseCase: UserUseCase) : UserService {

    override suspend fun validateEmail(email: String) {
        ValidationUtils.validateEmail(email);
        userUseCase.validateEmail(email);
    }

    override suspend fun createUser(user: CreateUserDto) {
        ValidationUtils.validateEmail(user.email);
        userUseCase.createUser(user);
    }

    override suspend fun createUser(user: CreateUserDto, role: Int) {
        ValidationUtils.validateEmail(user.email);
        userUseCase.createUser(user, role);
    }

    override suspend fun login(user: LoginUserDto): ResponseUserDto {
        ValidationUtils.validateEmail(user.email);
        return userUseCase.loginUser(user);
    }

}