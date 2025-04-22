package com.janz.hexarchksb_ecommerce.application.services

import com.janz.hexarchksb_ecommerce.application.mappers.UserMapper.toUserEntity
import com.janz.hexarchksb_ecommerce.application.ports.driven.repositories.UserRepository
import com.janz.hexarchksb_ecommerce.application.ports.driving.services.RoleService
import com.janz.hexarchksb_ecommerce.application.ports.driving.services.UserService
import com.janz.hexarchksb_ecommerce.application.utils.EncryptUtils
import com.janz.hexarchksb_ecommerce.application.utils.GeneratorUtil
import com.janz.hexarchksb_ecommerce.application.utils.ValidationUtils
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (private val repository: UserRepository, private val roleService: RoleService) : UserService {

    override suspend fun validateEmail(email: String) {
        ValidationUtils.validateEmail(email);
        val user = repository.findByEmail(email) ?: throw IllegalArgumentException("User with email $email not found");
    }

    override suspend fun createUser(user: CreateUserDto) {
        ValidationUtils.validateEmail(user.email);
        val validatedUser = repository.findByEmail(user.email);
        if(validatedUser !== null) throw IllegalArgumentException("User with email ${user.email} already exists");
        val password = EncryptUtils.encryptPassword(user.password);
        val username: String = GeneratorUtil.generateUsername(user);
        val role = roleService.getClientRole();
        val newUser = user.toUserEntity(user, password, username, role);
        repository.save(newUser);
    }
}