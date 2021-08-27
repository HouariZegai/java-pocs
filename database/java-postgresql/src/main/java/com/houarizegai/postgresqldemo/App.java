package com.houarizegai.postgresqldemo;

import com.houarizegai.postgresqldemo.dao.EmployeeDao;
import com.houarizegai.postgresqldemo.dao.EmployeeDaoImpl;
import com.houarizegai.postgresqldemo.domain.Employee;

public class App {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        // Insert employee
        employeeDao.save(new Employee(0, "Houari", 12000.5d));

        // Update employee
        employeeDao.save(new Employee(1, "Mohamed", 300d));

        // Get record by id
        System.out.println(employeeDao.findById(1));

        // Delete record by id
        employeeDao.deleteById(1);

        // Get all records
        employeeDao.findAll().forEach(System.out::println);
    }
}
