package com.houarizegai.exceldemo.service;

import com.houarizegai.exceldemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    boolean save(List<Employee> employee);
}
