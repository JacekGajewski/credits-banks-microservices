package com.example.customer.service;

import com.example.customer.model.Contract;
import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    Contract findById(int id);

    List<Contract> findAll();

    void save(Customer customer);

    void update(Customer theCustomer);

    void delete(int id);

}
