package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BankCustomer;
import com.example.model.BankCustomerVO;
import com.example.service.BankCustomerService;

@RestController
public class BankCustomerController {

	@Autowired
	private BankCustomerService bankCustomerService;

	@PostMapping("/saveBankCustomer")
	public Object insertBankCustomer(@RequestBody BankCustomer bankCustomer) {
		return (bankCustomerService.saveBankCustomer(bankCustomer));
	}

	@GetMapping("/getBankCustomers/{pageNo}/{pageSize}")
	public List<BankCustomerVO> fetchAllBankCustomerDetails(@PathVariable int pageNo, @PathVariable int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("email").ascending());
		return (bankCustomerService.fetchAllBankCustomerDetails(pageable));
	}
}
