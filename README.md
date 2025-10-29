# Adaptive Optimization App

## 🧠 Overview

**Adaptive Optimization App** is a Spring Boot web application that demonstrates **real-time application tuning** based on runtime behavior and traffic patterns.  
It automatically adjusts:

- 🧩 **Connection Pooling:** Dynamically tunes database connection pool size.
- ⚡ **Caching:** Modifies cache TTL (Time-To-Live) values to improve hit rates.
- ♻️ **Garbage Collection:** Tunes JVM garbage collection parameters on the fly.
- 🌍 **CDN Edge Optimization:** Simulates edge server selection based on user geography.

This project is ideal for **development/testing** scenarios and can run entirely on an **AWS EC2 instance** — no admin access on your local machine required.

---

## 🚀 Features

| Feature | Description |
|----------|-------------|
| **Dynamic Connection Pooling** | Adjusts HikariCP pool sizes at runtime. |
| **Cache TTL Management** | Changes cache TTL for performance optimization. |
| **GC Parameter Tuning** | Simulates tuning of JVM garbage collection strategies. |
| **CDN Edge Selection** | Demonstrates geo-based edge server optimization. |
| **Self-contained Server** | Spring Boot’s embedded Tomcat eliminates need for external Tomcat. |
| **In-memory Database** | Uses H2 database for lightweight, no-setup testing. |

---

## 🏗️ Project Structure

/root/adaptive-optimization-app/
├── README.md
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   ├── AdaptiveOptimizationApp.java
│       │   ├── com
│       │   │   └── example
│       │   │       └── adaptive
│       │   ├── config
│       │   │   └── CacheConfig.java
│       │   ├── controller
│       │   │   └── HomeController.java
│       │   └── service
│       │       ├── CDNService.java
│       │       ├── CacheService.java
│       │       ├── ConnectionPoolService.java
│       │       └── GCService.java
│       └── resources
│           ├── application.properties
│           └── static
│               └── index.html
└── target
    ├── adaptive-optimization-app-1.0.0.jar
    ├── adaptive-optimization-app-1.0.0.jar.original
    ├── classes
    │   ├── application.properties
    │   ├── com
    │   │   └── example
    │   │       └── adaptive
    │   │           ├── AdaptiveOptimizationApp.class
    │   │           ├── config
    │   │           │   └── CacheConfig.class
    │   │           ├── controller
    │   │           │   └── HomeController.class
    │   │           └── service
    │   │               ├── CDNService.class
    │   │               ├── CacheService.class
    │   │               ├── ConnectionPoolService.class
    │   │               └── GCService.class
    │   └── static
    │       └── index.html
    ├── generated-sources
    │   └── annotations
    ├── maven-archiver
    │   └── pom.properties
    └── maven-status
        └── maven-compiler-plugin
            └── compile
                └── default-compile
                    ├── createdFiles.lst
                    └── inputFiles.lst
