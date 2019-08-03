package com.houarizegai.springboot.cruddemo.rest;

import com.houarizegai.springboot.cruddemo.entity.Employee;
import com.houarizegai.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") int id) {
        Employee employee = employeeService.findById(id);

        if(employee == null)
            throw new RuntimeException("Employee id not found - " + id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmploye(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable(name = "employeeId") int id) {
        Employee employee = employeeService.findById(id);
        if(employee == null) { // throw exception if employee not exist
            throw new RuntimeException("Employee is not found - " + id);
        }

        employeeService.deleteById(id);

        return "Deleted employee id - " + id;
    }
}
