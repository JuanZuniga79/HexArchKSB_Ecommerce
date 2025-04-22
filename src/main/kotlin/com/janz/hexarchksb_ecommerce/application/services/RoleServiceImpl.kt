package com.janz.hexarchksb_ecommerce.application.services

import com.janz.hexarchksb_ecommerce.application.ports.driven.repositories.RoleRepository
import com.janz.hexarchksb_ecommerce.application.ports.driving.services.RoleService
import com.janz.hexarchksb_ecommerce.infrastructure.entities.RoleEntity
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl (private val repository: RoleRepository) : RoleService{
    override suspend fun getClientRole(): RoleEntity {
        val role = repository.findByName("client");
        if(role === null){
           return repository.save<RoleEntity>(RoleEntity(
               name = "client", description = "Default role for all application user created")
           );
        }
        return role;
    }
}