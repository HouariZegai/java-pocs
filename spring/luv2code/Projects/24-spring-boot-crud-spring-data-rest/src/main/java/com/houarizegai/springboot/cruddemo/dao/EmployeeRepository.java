package com.houarizegai.springboot.cruddemo.dao;

import com.houarizegai.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") // change the default path (this example:  employees) to "members"
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // <table entity, type of primary key>
    // that's it ... no need to write any code!
}
