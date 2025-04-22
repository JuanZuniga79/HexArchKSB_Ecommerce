package com.janz.hexarchksb_ecommerce.application.ports.driving.services

import com.janz.hexarchksb_ecommerce.infrastructure.entities.RoleEntity

interface RoleService {
    suspend fun getClientRole() : RoleEntity
}