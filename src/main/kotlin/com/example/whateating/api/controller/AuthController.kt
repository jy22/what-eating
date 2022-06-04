package com.example.whateating.api.controller

import com.example.whateating.model.request.auth.SignInRequest
import com.example.whateating.model.request.auth.SignUpRequest
import com.example.whateating.model.response.auth.AuthResponse
import com.example.whateating.model.response.common.SingleResponse
import com.example.whateating.service.auth.AuthService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${whateating.api.version}")
class AuthController(
    private val authService: AuthService,
) {
    @PostMapping("/auth/sign-in")
    @ResponseStatus(HttpStatus.OK)
    suspend fun signIn(@RequestBody request: SignInRequest): SingleResponse<AuthResponse>? =
        SingleResponse(data = authService.signIn(request))

    @PostMapping("/auth/sign-up")
    @ResponseStatus(HttpStatus.OK)
    suspend fun signUp(@RequestBody request: SignUpRequest): SingleResponse<String>? =
        SingleResponse(data = authService.signUp(request))
}
