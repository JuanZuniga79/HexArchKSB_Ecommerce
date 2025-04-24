package com.janz.hexarchksb_ecommerce.application.ports.driven.repositories

import com.janz.hexarchksb_ecommerce.infrastructure.entities.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : CrudRepository<UserEntity, UUID> {
    fun findByUsername(username: String): UserEntity?
    fun findByEmail(email: String): UserEntity?
}