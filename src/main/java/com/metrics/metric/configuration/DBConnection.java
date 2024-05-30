package com.metrics.metric.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
@Configuration
public class DBConnection {

    @Value("${spring.datasource.url}")
    private final String url;
    @Value("${spring.datasource.username}")
    private final String username;
    @Value("${spring.datasource.password}")
    private final String password;

    public DBConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
