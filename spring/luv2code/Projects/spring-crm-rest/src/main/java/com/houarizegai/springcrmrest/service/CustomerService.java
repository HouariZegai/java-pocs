package com.houarizegai.springcrmrest.service;

import com.houarizegai.springcrmrest.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomer(int customerId);

    void saveCustomer(Customer customer);

    void deleteCustomer(int customerId);
}
