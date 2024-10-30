package com.kotlin.matech.chatapp

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

//This class will extend WebMvcConfigurer
@Configuration
@EnableWebMvc
class WebConfig: WebMvcConfigurer {
    /** Cors will serve us to route the app front end
    to go to a different port than the one explicit on the app.properties.
    three different front end framework will be used: vue.js, react, angular */
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000", "http://localhost:8080", "http://localhost:4200")
    }

}