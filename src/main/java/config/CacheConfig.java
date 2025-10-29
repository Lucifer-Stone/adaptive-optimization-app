package com.example.adaptive.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        // Simple in-memory cache manager (no Redis, no fancy setup)
        return new ConcurrentMapCacheManager("defaultCache");
    }
}
