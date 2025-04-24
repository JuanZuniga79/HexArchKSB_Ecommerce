package com.janz.hexarchksb_ecommerce.infrastructure.adapters.driving.controllers.user

import com.janz.hexarchksb_ecommerce.application.ports.driving.services.UserService
import com.janz.hexarchksb_ecommerce.infrastructure.models.ApiResponse
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserWithRoleDto
import com.janz.hexarchksb_ecommerce.infrastructure.utils.ResponseUtil
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController (private val userService: UserService){

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create-user")
    suspend fun createUser(@Valid @RequestBody user: CreateUserWithRoleDto) : ResponseEntity<ApiResponse<Nothing>>{
        userService.createUser(user.user, user.roleId);
        return ResponseUtil.success(message = "User created successfully", status = HttpStatus.CREATED);
    }

}