package com.houarizegai.springboot.cruddemo.dao;

import com.houarizegai.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
