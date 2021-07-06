package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.BankCustomer;

public interface BankCustomerRepo extends JpaRepository<BankCustomer, Integer> {

	// JPQL
	@Query("select a from BankCustomer a")
	Page<BankCustomer> fetchAllBankCustomerDetails(Pageable pageable);

}
