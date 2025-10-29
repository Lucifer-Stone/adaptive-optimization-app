package com.example.adaptive.service;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private final CacheManager cacheManager;

    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void setTTL(String cacheName, long ttlSeconds) {
        // Development-only: print message. In production, use Caffeine/Redis to adjust TTL dynamically
        System.out.println("Cache TTL for " + cacheName + " set to " + ttlSeconds + " seconds");
    }
}
