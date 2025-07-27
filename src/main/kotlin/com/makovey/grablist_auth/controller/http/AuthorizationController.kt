package com.makovey.grablist_auth.controller.http

import com.makovey.grablist_auth.dto.SignUpUserRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class AuthorizationController {

    @PostMapping("/sign-up")
    fun signUpUser(
        @RequestBody @Valid request: SignUpUserRequest
    ): ResponseEntity<Void> {
        return ResponseEntity
            .ok()
            .build()
    }
}