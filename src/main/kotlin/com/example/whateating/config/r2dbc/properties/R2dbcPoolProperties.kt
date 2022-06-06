package com.example.whateating.config.r2dbc.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding // 생성자 바인딩
@ConfigurationProperties(value = "r2dbc.pool") // yml setting
data class R2dbcPoolProperties(
    val initialSize: Int,
    val maxSize: Int,
    val maxLife: Long,
    val maxCreateConnectionTime: Long,
    val maxIdleTime: Long,
    val tlsVersion: String
)
