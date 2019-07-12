package com.example.client.controller;

import com.example.client.entity.Contract;
import com.example.client.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {

	private ContractService contractService;
	
	public ContractController(ContractService contractService) {
		this.contractService = contractService;
	}


	@GetMapping("/list")
	public String listContracts(Model model) {

		List<Contract> contractList = contractService.findAll();

		model.addAttribute("contracts", contractList);
		
		return "contracts/list-contracts";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Contract contract = new Contract();

		model.addAttribute("contract", contract);

		return "contracts/contract-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("contractId") int id,
									Model model) {

		Contract contract = contractService.findById(id);

		model.addAttribute("contract", contract);

		return "contracts/contract-form";
	}


	@PostMapping("/save")
	public String saveContract(@ModelAttribute("contract") Contract contract) {

		contractService.save(contract);

		return "redirect:/contracts/list";
	}


	@GetMapping("/delete")
	public String delete(@RequestParam("contractId") int id) {

		contractService.deleteById(id);

		return "redirect:/contracts/list";

	}
}


















