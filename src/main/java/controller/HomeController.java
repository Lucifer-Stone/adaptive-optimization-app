package com.example.adaptive.controller;

import com.example.adaptive.service.CDNService;
import com.example.adaptive.service.CacheService;
import com.example.adaptive.service.ConnectionPoolService;
import com.example.adaptive.service.GCService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HomeController {

    private final ConnectionPoolService connectionPoolService;
    private final CacheService cacheService;
    private final GCService gcService;
    private final CDNService cdnService;

    public HomeController(ConnectionPoolService cps, CacheService cs, GCService gcs, CDNService cdns) {
        this.connectionPoolService = cps;
        this.cacheService = cs;
        this.gcService = gcs;
        this.cdnService = cdns;
    }

    @GetMapping("/")
    public String home() {
        return "Adaptive Optimization App is running!";
    }

    @GetMapping("/adjustPool")
    public String adjustPool(@RequestParam int size) {
        connectionPoolService.adjustPoolSize(size);
        return "Connection pool size adjusted to " + size;
    }

    @GetMapping("/setCacheTTL")
    public String setCacheTTL(@RequestParam String cacheName, @RequestParam long ttl) {
        cacheService.setTTL(cacheName, ttl);
        return "Cache TTL for " + cacheName + " set to " + ttl + " seconds";
    }

    @GetMapping("/tuneGC")
    public String tuneGC(@RequestParam String type) {
        gcService.tuneGC(type);
        return "GC tuned to " + type;
    }

    @GetMapping("/cdnEdge")
    public String cdnEdge(@RequestParam String geo) {
        return "Selected CDN edge: " + cdnService.selectEdge(geo);
    }
}
