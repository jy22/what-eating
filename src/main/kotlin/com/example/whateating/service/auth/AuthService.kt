package com.example.whateating.service.auth

import com.example.whateating.domain.auth.entity.User
import com.example.whateating.domain.auth.repository.read.AuthRepository
import com.example.whateating.model.request.auth.SignInRequest
import com.example.whateating.model.request.auth.SignUpRequest
import com.example.whateating.model.response.auth.AuthResponse
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val authRepository: AuthRepository
) {
    suspend fun signIn(request: SignInRequest): String {
        return ""
    }

    suspend fun signUp(request: SignUpRequest): AuthResponse {
        // jwt 토큰 생성

        val authUser = User(
            name = request.name,
            email = request.email,
            password = request.password
        )
        val saveAuth = authRepository.save(authUser)

        return AuthResponse(
            id = saveAuth.id,
            email = saveAuth.email
        )
    }
}
