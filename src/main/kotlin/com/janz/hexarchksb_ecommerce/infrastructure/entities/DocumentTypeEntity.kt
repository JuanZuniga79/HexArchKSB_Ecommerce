package com.janz.hexarchksb_ecommerce.infrastructure.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "document_types")
@Entity
data class DocumentTypeEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(length = 64, unique = true, nullable = false)
    var name: String,
    @Column(length = 4, unique = true, nullable = false)
    var code: String,
)
