package com.houarizegai.postgresqldemo.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class DBConnection {

    private static final String DB_NAME = "employees_db";
    private static final String HOST = "localhost";
    private static final int PORT = 5432;
    private static final String URL = String.format("jdbc:postgresql://%s:%d/%s", HOST, PORT, DB_NAME);
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";


    public static Optional<Connection> getConnection() {
        try {
            return Optional.ofNullable(DriverManager.getConnection(URL, USERNAME, PASSWORD));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        if(DBConnection.getConnection().isPresent())
            System.out.println("connected!");
        else
            System.out.println("connection failed!!");
    }
}
