package com.example.adaptive.service;

import org.springframework.stereotype.Service;

@Service
public class GCService {

    public void tuneGC(String gcType) {
        // Development-only: log tuning
        System.out.println("GC tuned to: " + gcType);
    }
}
