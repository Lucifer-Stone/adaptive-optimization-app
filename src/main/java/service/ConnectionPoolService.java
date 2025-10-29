package com.example.adaptive.service;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ConnectionPoolService {

    private HikariDataSource dataSource;

    public ConnectionPoolService(DataSource ds) {
        if (ds instanceof HikariDataSource) {
            this.dataSource = (HikariDataSource) ds;
        }
    }

    public void adjustPoolSize(int newSize) {
        if (dataSource != null) {
            dataSource.setMaximumPoolSize(newSize);
            System.out.println("Connection pool size updated to: " + newSize);
        } else {
            System.out.println("DataSource not HikariCP, cannot adjust pool size.");
        }
    }
}
