package com.example.whateating.domain.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user")
data class User(
    var name: String,
    var email: String,
    var password: String
) {
    @Id
    val id: Long = 0
}
