package com.example.client.dao;

import com.example.client.entity.Contract;
import com.example.client.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("CUSTOMER")
public interface ContractClient {

    @GetMapping("customers/{id}")
    Contract getContract(@PathVariable int id);

    @GetMapping("/customers")
    List<Contract> getContracts();

    @PostMapping("/customers")
    void createCustomer(@RequestBody Customer customer);

    @PutMapping("/customers")
    void updateCustomer(@RequestBody Customer customer);

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable int id);
}
