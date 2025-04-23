package com.janz.hexarchksb_ecommerce.infrastructure.adapters.driving.controllers.user

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/validate")
    suspend fun validate() : String {
        return "only admin can see this"
    }

    @PostMapping("/create-user")
    suspend fun createUser(){

    }

}