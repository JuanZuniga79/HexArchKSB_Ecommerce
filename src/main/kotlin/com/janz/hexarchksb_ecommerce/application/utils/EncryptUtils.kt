package com.janz.hexarchksb_ecommerce.application.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object EncryptUtils {

    private val encoder = BCryptPasswordEncoder();

    suspend fun encryptPassword(password: String): String {
        return encoder.encode(password);
    }

    suspend fun validatePassword(encryptedPassword: String, password: String): Boolean {
        return encoder.matches(password, encryptedPassword);
    }

}