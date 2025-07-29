package com.makovey.grablist_auth.service

import com.makovey.grablist_auth.dto.SignUpUserRequest
import com.makovey.grablist_auth.entity.User
import com.makovey.grablist_auth.exception.RoleNotFoundException
import com.makovey.grablist_auth.repository.RoleRepo
import com.makovey.grablist_auth.repository.UserRepo
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    private val userRepo: UserRepo,
    private val roleRepo: RoleRepo,
    private val passwordEncoder: PasswordEncoder
) {
    fun signUp(request: SignUpUserRequest): Long {
        val role = roleRepo.findByName("ROLE_USER")
            ?: throw RoleNotFoundException("Sign Up Failed, try again later.")

        val user = User(
            email = request.email,
            firstName = request.firstname,
            lastName = request.lastname,
            phone = request.phone,
            passwordHash = passwordEncoder.encode(request.password),
            role = role,
            isActive = true,
        )

        userRepo.save(user)

        return user.id
    }
}