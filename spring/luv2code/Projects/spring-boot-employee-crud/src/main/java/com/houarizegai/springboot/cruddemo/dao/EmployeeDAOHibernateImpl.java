package com.houarizegai.springboot.cruddemo.dao;

import com.houarizegai.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = currentSession.createQuery("from employee", Employee.class);

        // execute the query and get the result
        List<Employee> employees = query.getResultList();

        return employees;
    }
}
