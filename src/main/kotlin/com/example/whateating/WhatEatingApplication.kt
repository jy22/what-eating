package com.example.whateating

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ConfigurationPropertiesScan("com.example.whateating.config.*")
@ComponentScan(basePackages = ["com.example.whateating.*"])
@SpringBootApplication(exclude = [R2dbcAutoConfiguration::class])
class WhatEatingApplication

fun main(args: Array<String>) {
    runApplication<WhatEatingApplication>(*args)
}
