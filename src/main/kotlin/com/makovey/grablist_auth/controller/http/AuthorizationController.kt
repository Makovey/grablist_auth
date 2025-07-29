package com.makovey.grablist_auth.controller.http

import com.makovey.grablist_auth.dto.SignUpUserRequest
import com.makovey.grablist_auth.dto.SignUpUserResponse
import com.makovey.grablist_auth.service.AuthorizationService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class AuthorizationController(
    private val service: AuthorizationService,
) {

    @PostMapping("/sign-up")
    fun signUpUser(
        @RequestBody @Valid request: SignUpUserRequest
    ): ResponseEntity<SignUpUserResponse> {
        val id = service.signUp(request)

        return ResponseEntity
            .ok()
            .body(SignUpUserResponse(userId = id))
    }
}