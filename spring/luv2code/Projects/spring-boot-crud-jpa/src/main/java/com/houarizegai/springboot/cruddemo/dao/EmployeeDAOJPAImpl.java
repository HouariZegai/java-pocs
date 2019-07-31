package com.houarizegai.springboot.cruddemo.dao;

import com.houarizegai.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // save or update the employee
        Employee dbEmployee = entityManager.merge(employee);

        // update with id from db, so we can get generated id for save/insert
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
