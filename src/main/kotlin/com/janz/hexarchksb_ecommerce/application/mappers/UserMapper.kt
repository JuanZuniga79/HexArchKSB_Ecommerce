package com.janz.hexarchksb_ecommerce.application.mappers

import com.janz.hexarchksb_ecommerce.infrastructure.entities.RoleEntity
import com.janz.hexarchksb_ecommerce.infrastructure.entities.UserEntity
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.ResponseRoleDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.ResponseUserDto

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

    suspend fun UserEntity.toResponseUserDto(user: UserEntity): ResponseUserDto
        = ResponseUserDto(
            id = user.id,
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            username = user.username,
            document = user.document,
            active = user.active,
            role = ResponseRoleDto(name = user.role.name, description = user.role.description)
        )

}