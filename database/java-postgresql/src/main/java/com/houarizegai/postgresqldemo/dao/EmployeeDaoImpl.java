package com.houarizegai.postgresqldemo.dao;

import com.houarizegai.postgresqldemo.domain.Employee;
import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_en;

import java.sql.*;
import java.util.*;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> findAll() {
        Optional<Connection> connectionOptional = DBConnection.getConnection();
        if(connectionOptional.isPresent()) {
            Connection connection = connectionOptional.get();

            String sql = "SELECT * FROM employee;";
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                List<Employee> employees = new ArrayList<>();
                while(result.next()) {
                    employees.add(new Employee(
                            result.getInt("id"),
                            result.getString("name"),
                            result.getDouble("salary")
                    ));
                }
                return employees;

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Employee> findById(int id) {
        Optional<Connection> connectionOptional = DBConnection.getConnection();
        if(connectionOptional.isPresent()) {
            Connection connection = connectionOptional.get();

            String sql = "SELECT * FROM employee WHERE id=?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet result = preparedStatement.executeQuery();
                if(result.next()) {
                    return Optional.of(new Employee(
                            result.getInt("id"),
                            result.getString("name"),
                            result.getDouble("salary")
                    ));
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {
        Optional<Connection> connectionOptional = DBConnection.getConnection();
        if(connectionOptional.isPresent()) {
            Connection connection = connectionOptional.get();

            try {
                PreparedStatement preparedStatement = null;
                if(employee.getId() > 0) { // Update
                    String sql = "UPDATE employee SET name=?, salary=? WHERE id=?";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, employee.getName());
                    preparedStatement.setDouble(2, employee.getSalary());
                    preparedStatement.setInt(3, employee.getId());

                } else { // Insert
                    String sql = "INSERT INTO employee (name, salary) VALUES (?, ?)";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, employee.getName());
                    preparedStatement.setDouble(2, employee.getSalary());
                }

                preparedStatement.executeUpdate();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(int id) {
        Optional<Connection> connectionOptional = DBConnection.getConnection();
        if(connectionOptional.isPresent()) {
            Connection connection = connectionOptional.get();

            String sql = "DELETE FROM employee WHERE id=?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
