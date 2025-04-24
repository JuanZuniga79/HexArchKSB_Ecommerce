package com.janz.hexarchksb_ecommerce.infrastructure.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Table(name = "users")
@Entity
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    @Column(length = 128)
    var firstName: String,
    @Column(length = 128)
    var lastName: String,
    @Column(unique = true, length = 256)
    var email: String,
    @Column(unique = true, length = 32)
    var username: String,
    @Column(length = 128)
    var password: String,
    @Column(length = 16, unique = true)
    var document: String,
    var active: Boolean =  true,
    @ManyToOne(fetch = FetchType.EAGER)
    var role: RoleEntity,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne(fetch = FetchType.LAZY)
    var updatedBy: UserEntity? = null,
)
