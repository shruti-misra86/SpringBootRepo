package com.example.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.model.BankCustomer;
import com.example.model.BankCustomerVO;

public interface BankCustomerService {
	public Object saveBankCustomer(BankCustomer bankCustomer);

	public List<BankCustomerVO> fetchAllBankCustomerDetails(Pageable pageable);
}
