package com.example.whateating

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ConfigurationPropertiesScan("com.example.whateating.config.r2dbc.properties")
@ComponentScan(basePackages = ["com.example.whateating.*"])
@SpringBootApplication
class WhatEatingApplication

fun main(args: Array<String>) {
    runApplication<WhatEatingApplication>(*args)
}
