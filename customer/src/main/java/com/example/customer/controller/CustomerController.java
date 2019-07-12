package com.example.customer.controller;


import com.example.customer.model.Customer;
import com.example.customer.model.Contract;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    DiscoveryClient discoveryClient;

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers/{id}")
    @ResponseBody
    public Contract getCustomer(@PathVariable int id){
        return customerService.findById(id);
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<Contract> getCustomers(){
        return customerService.findAll();
    }

    @PostMapping("/customers")
    public void createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
    }

    @PutMapping("/customers")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.update(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.delete(id);
    }

}
