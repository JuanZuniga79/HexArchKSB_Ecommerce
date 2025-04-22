package com.janz.hexarchksb_ecommerce.application.utils

object ValidationUtils {
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@(hotmail|outlook|gmail)\\.[a-z]{2,}$")
    suspend fun validateEmail(email: String?): Boolean {
        if(email.isNullOrBlank()) throw IllegalArgumentException("Empty email");
        val emailToValid = email.lowercase();
        if (!emailToValid.matches(emailRegex))
            throw IllegalArgumentException("Email address contains invalid characters");
        return true
    }
}