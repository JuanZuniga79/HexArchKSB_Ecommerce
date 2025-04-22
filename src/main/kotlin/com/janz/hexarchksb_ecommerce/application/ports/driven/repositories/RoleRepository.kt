package com.janz.hexarchksb_ecommerce.application.ports.driven.repositories

import com.janz.hexarchksb_ecommerce.infrastructure.entities.RoleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : CrudRepository<RoleEntity, Int> {
    fun findByName(name: String): RoleEntity?
}