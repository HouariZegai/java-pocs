package com.houarizegai.springboot.cruddemo.dao;

import com.houarizegai.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// <table entity, type of primary key>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it ... no need to write any code!
}
