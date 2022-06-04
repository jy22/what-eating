package com.example.whateating.model.request.auth

data class SignUpRequest(
    val email: String,
    val name: String,
    val password: String
)
