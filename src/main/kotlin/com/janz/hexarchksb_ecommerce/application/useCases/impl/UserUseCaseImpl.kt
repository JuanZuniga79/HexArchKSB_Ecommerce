package com.janz.hexarchksb_ecommerce.application.useCases.impl

import com.janz.hexarchksb_ecommerce.application.mappers.UserMapper.toResponseUserDto
import com.janz.hexarchksb_ecommerce.application.mappers.UserMapper.toUserEntity
import com.janz.hexarchksb_ecommerce.application.ports.driven.repositories.UserRepository
import com.janz.hexarchksb_ecommerce.application.ports.driving.services.RoleService
import com.janz.hexarchksb_ecommerce.application.useCases.UserUseCase
import com.janz.hexarchksb_ecommerce.application.utils.EncryptUtils
import com.janz.hexarchksb_ecommerce.application.utils.GeneratorUtil
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.LoginUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.ResponseUserDto
import org.springframework.stereotype.Service

@Service
class UserUseCaseImpl (private val repository: UserRepository, private val roleService: RoleService) : UserUseCase {

    override suspend fun createUser(user: CreateUserDto, role: Int?): ResponseUserDto {
        val validatedUser = repository.findByEmail(user.email);
        if(validatedUser !== null) throw IllegalArgumentException("User with email ${user.email} already exists");
        val password = EncryptUtils.encryptPassword(user.password);
        val username: String = GeneratorUtil.generateUsername(user);
        val roleEntity = role?.let { roleService.getRoleById(it) } ?: roleService.getClientRole()
        val newUser = user.toUserEntity(user, password, username, roleEntity);
        val response = repository.save(newUser);
        return response.toResponseUserDto(response);
    }

    override suspend fun validateEmail(email: String) {
        repository.findByEmail(email) ?: throw IllegalArgumentException("User with email $email not found");
    }

    override suspend fun loginUser(user: LoginUserDto): ResponseUserDto {
        val validatedUser = repository.findByEmail(user.email)
            ?: throw IllegalArgumentException("User with email ${user.email} not found");
        val passwordIsValid = EncryptUtils.validatePassword(
            validatedUser.password, user.password
        );
        if(!passwordIsValid){
            throw IllegalArgumentException("Wrong password");
        }
        return validatedUser.toResponseUserDto(validatedUser);
    }

}