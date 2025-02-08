package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/test";

        Properties props = new Properties();
        props.setProperty("user", "test_user");
        props.setProperty("password", "password123");

        props.setProperty("socketFactory", "com.example.CustomSocketFactory");

        props.setProperty("keepAlive", "true");
        props.setProperty("keepAliveIdle", "80");
        props.setProperty("keepAliveInterval", "20");
        props.setProperty("keepAliveCount", "10000000");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
