package com.janz.hexarchksb_ecommerce.application.mappers

import com.janz.hexarchksb_ecommerce.infrastructure.entities.RoleEntity
import com.janz.hexarchksb_ecommerce.infrastructure.entities.UserEntity
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto

object UserMapper {
    suspend fun CreateUserDto.toUserEntity(user: CreateUserDto, password: String, username: String, role: RoleEntity): UserEntity
        = UserEntity(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            password = password,
            username = username,
            document = user.document,
            role = role
        );
}