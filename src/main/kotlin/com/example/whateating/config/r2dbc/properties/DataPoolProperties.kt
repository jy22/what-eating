package com.example.whateating.config.r2dbc.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding // 생성자 바인딩
@ConfigurationProperties(value = "r2dbc.datasource") // yml setting
data class DataPoolProperties(
    val host: String,
    val port: Int,
    val db: String,
    val username: String,
    val password: String,
)
