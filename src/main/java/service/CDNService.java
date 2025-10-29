package com.example.adaptive.service;

import org.springframework.stereotype.Service;

@Service
public class CDNService {

    public String selectEdge(String userGeo) {
        switch (userGeo.toLowerCase()) {
            case "us": return "us-east-1 edge";
            case "eu": return "eu-central-1 edge";
            default: return "default global edge";
        }
    }
}
