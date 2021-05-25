package com.houarizegai.handleexceptions.controller;

import com.houarizegai.handleexceptions.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HouariZegai, created on 25/05/2021
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    List<Employee> employees = Arrays.asList(new Employee(1, "Mohamed", 12000d),
            new Employee(2, "Khaled", 900d));

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getAllEmployees(@PathVariable long id) {
        return ResponseEntity.ok(employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("Employee with id %d not found!", id))));
    }

    @PostMapping("/employees")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        employees = employees.stream().filter(employee -> employee.getId() != id).collect(Collectors.toList());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
