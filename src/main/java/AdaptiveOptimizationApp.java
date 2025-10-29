package com.example.adaptive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;  // 👈 THIS IMPORT IS IMPORTANT

@SpringBootApplication
@EnableCaching  // 👈 Enables Spring Boot caching
public class AdaptiveOptimizationApp {

    public static void main(String[] args) {
        SpringApplication.run(AdaptiveOptimizationApp.class, args);
    }
}
