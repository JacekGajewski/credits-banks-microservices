package com.example.client.service;


import com.example.client.entity.Contract;

import java.util.List;

public interface ContractService {

	List<Contract> findAll();
	
	Contract findById(int theId);
	
	void save(Contract theEmployee);
	
	void deleteById(int theId);
}
