package com.houarizegai.postgresqldemo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class EmployeeMetaDataDao {
    public static void createTable() {
        Optional<Connection> conOptional = DBConnection.getConnection();
        if(conOptional.isPresent()) {
            Connection con = conOptional.get();
            String sql = "CREATE TABLE employee (id SERIAL PRIMARY KEY, name VARCHAR(50), salary REAL)";
            try {
                Statement statement = con.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        EmployeeMetaDataDao.createTable();
    }
}
