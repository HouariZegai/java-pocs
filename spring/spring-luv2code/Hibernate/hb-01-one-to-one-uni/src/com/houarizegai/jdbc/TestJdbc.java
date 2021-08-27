package com.houarizegai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcurl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcurl);
            Connection con = DriverManager.getConnection(jdbcurl, user, pass);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
