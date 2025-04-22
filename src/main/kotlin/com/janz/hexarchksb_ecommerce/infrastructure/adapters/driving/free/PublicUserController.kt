package com.janz.hexarchksb_ecommerce.infrastructure.adapters.driving.free

import com.janz.hexarchksb_ecommerce.application.ports.driving.services.UserService
import com.janz.hexarchksb_ecommerce.infrastructure.models.ApiResponse
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.CreateUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.LoginUserDto
import com.janz.hexarchksb_ecommerce.infrastructure.models.dto.ResponseLoginDto
import com.janz.hexarchksb_ecommerce.infrastructure.utils.ResponseUtil
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class EmailDTO(
    @field:Email(message = "Email address contains invalid characters")
    @field:NotBlank(message = "Email is mandatory")
    val email: String
)

@RestController
@RequestMapping("/api/public")
class PublicUserController(private val service: UserService) {

    @PostMapping("/validate-email")
    suspend fun validateEmail(@Valid @RequestBody email: EmailDTO): ResponseEntity<ApiResponse<Nothing>> {
        service.validateEmail(email.email)
        return ResponseUtil.success<Nothing>(message = "Email address is valid");
    }

    @PostMapping("/register")
    suspend fun createUser(@Valid @RequestBody user: CreateUserDto): ResponseEntity<ApiResponse<Nothing>> {
        service.createUser(user);
        return ResponseUtil.success<Nothing>(message = "User created successfully", status = HttpStatus.CREATED);
    }

    @PostMapping("/login")
    suspend fun login(@Valid @RequestBody user: LoginUserDto): ResponseEntity<ApiResponse<ResponseLoginDto>> {
        return  ResponseUtil.success<ResponseLoginDto>(message = "User login successfully");
    }

}