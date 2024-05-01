package com.netflixgpt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow access to all paths
                .allowedOrigins("*") // Allow access from all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow all HTTP methods
                .allowedHeaders("*"); // Allow all headers
    }
}
