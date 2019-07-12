package com.example.credit.controller;

import com.example.credit.model.*;
import com.example.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditController<K> {

    @Autowired
    DiscoveryClient discoveryClient;

    private CreditService creditService;

    public CreditController(CreditService creditService){
        this.creditService = creditService;
    }

    @GetMapping("/credits/{id}")
    @ResponseBody
    public String getCredit(@PathVariable int id) {
        return creditService.findById(id).getCreditName();
    }

    @GetMapping("/credits")
    @ResponseBody
    public List<Credit> getCredit() {
        return creditService.findAll();
    }

    @PostMapping("credits")
    public void createCredit(@RequestBody Credit credit){
        creditService.save(credit);
    }

    @PutMapping("/credits")
    public void updateCredit(@RequestBody Credit credit){
        creditService.update(credit);
    }

    @DeleteMapping("/creditts/{id}")
    public void deleteCredit(@PathVariable int id){
        creditService.delete(id);
    }

}
