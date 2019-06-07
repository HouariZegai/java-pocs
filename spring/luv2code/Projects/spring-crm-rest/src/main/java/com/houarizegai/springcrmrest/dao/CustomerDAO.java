package com.houarizegai.springcrmrest.dao;

import com.houarizegai.springcrmrest.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
    Customer getCustomer(int customerId);
    void saveCustomer(Customer customer);
    void deleteCustomer(int customerId);
}
