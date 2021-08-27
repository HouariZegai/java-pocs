package com.houarizegai.exceldemo.service;

import com.houarizegai.exceldemo.dao.EmployeeDao;
import com.houarizegai.exceldemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public boolean save(List<Employee> employee) {
        return employeeDao.save(employee);
    }


}
