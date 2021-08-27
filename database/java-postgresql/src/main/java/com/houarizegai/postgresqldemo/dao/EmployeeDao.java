package com.houarizegai.postgresqldemo.dao;

import com.houarizegai.postgresqldemo.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
