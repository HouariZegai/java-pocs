package com.houarizegai.customertracker.service;

import com.houarizegai.customertracker.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
}
