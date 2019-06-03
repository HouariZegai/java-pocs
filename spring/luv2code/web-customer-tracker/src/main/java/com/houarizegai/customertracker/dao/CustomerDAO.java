package com.houarizegai.customertracker.dao;

import com.houarizegai.customertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
}
