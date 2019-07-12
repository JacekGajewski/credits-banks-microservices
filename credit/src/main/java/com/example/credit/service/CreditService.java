package com.example.credit.service;

import com.example.credit.model.Credit;

import java.util.List;

public interface CreditService {

    List<Credit> findAll();

    Credit findById(int id);

    void save(Credit credit);

    void update(Credit theCredit);

    void delete(int id);

}
