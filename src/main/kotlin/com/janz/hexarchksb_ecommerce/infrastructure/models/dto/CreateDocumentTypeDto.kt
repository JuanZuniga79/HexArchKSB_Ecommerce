package com.janz.hexarchksb_ecommerce.infrastructure.models.dto

import java.io.Serializable

/**
 * DTO for {@link com.janz.hexarchksb_booksecommerce.infrastructure.entities.DocumentType}
 */
data class CreateDocumentTypeDto(val name: String? = null, val code: String? = null) : Serializable