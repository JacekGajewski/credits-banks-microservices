package com.example.credit.service;

import com.example.credit.model.Credit;
import com.example.credit.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditServiceImpl implements CreditService{

    private CreditRepository creditRepository;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository){
        this.creditRepository = creditRepository;
    }

    @Override
    public Credit findById(int id) {

        Optional<Credit> credit = creditRepository.findById(id);

        Credit theCredit = null;

        if (credit.isPresent()){
            theCredit = credit.get();
        }
        else {
            throw new RuntimeException("Did not find credit id - " + id);
        }

        return theCredit;
    }

    @Override
    public List<Credit> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public void save(Credit credit) {
        creditRepository.save(credit);
    }

    @Override
    public void update(Credit theCredit) {
        Credit credit = creditRepository.getOne(theCredit.getCreditId());

        credit.setCreditName(theCredit.getCreditName());

        creditRepository.save(credit);
    }

    @Override
    public void delete(int id) {
        creditRepository.deleteById(id);
    }
}
