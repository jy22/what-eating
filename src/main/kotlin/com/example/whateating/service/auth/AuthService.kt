package com.example.whateating.service.auth

import com.example.whateating.model.request.auth.SignInRequest
import com.example.whateating.model.request.auth.SignUpRequest
import com.example.whateating.model.response.auth.AuthResponse
import org.springframework.stereotype.Service

@Service
class AuthService {

    suspend fun signIn(request: SignInRequest): AuthResponse =
        AuthResponse(
            email = request.email
        )

    suspend fun signUp(request: SignUpRequest): String {
        return ""
    }
}
