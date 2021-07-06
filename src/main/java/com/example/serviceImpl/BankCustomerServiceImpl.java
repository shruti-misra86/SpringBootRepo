package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.BankCustomer;
import com.example.model.BankCustomerVO;
import com.example.repository.BankCustomerRepo;
import com.example.service.BankCustomerService;

@Service
public class BankCustomerServiceImpl implements BankCustomerService {

	@Autowired
	private BankCustomerRepo bankCustomerRepo;

	@Override
	@Transactional
	public Object saveBankCustomer(BankCustomer bankCustomer) {
		Map<String, String> map = new HashMap<>();
		if (bankCustomer.getFirstName().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "please enter name");
		} else {
			map.put("status", "200");
			map.put("msg", "success");
			bankCustomerRepo.save(bankCustomer);
		}
		return map;
	}

	@Override
	@Transactional
	public List<BankCustomerVO> fetchAllBankCustomerDetails(Pageable pageable) {

		Page<BankCustomer> resultPage = bankCustomerRepo.fetchAllBankCustomerDetails(pageable);
		List<BankCustomer> resultList = resultPage.toList();
		List<BankCustomerVO> responseList = new ArrayList<BankCustomerVO>();

		if (!resultList.isEmpty()) {
			for (BankCustomer c : resultList) {
				BankCustomerVO bankCustomerVO = new BankCustomerVO();
				bankCustomerVO.setCustId(c.getCustId());
				bankCustomerVO.setName(c.getFirstName().concat(" ").concat(c.getLastName()));
				bankCustomerVO.setEmail(c.getEmail());
				bankCustomerVO.setContact(c.getContact());
				bankCustomerVO.setAadharNo(c.getAadharNo());
				bankCustomerVO.setPanNo(c.getPanNo());
				bankCustomerVO.setAddress1(c.getAddress1());
				bankCustomerVO.setAddress2(c.getAddress2());
				bankCustomerVO.setCity(c.getCity());
				bankCustomerVO.setState(c.getState());
				bankCustomerVO.setGender(c.getGender());
				bankCustomerVO.setDob(c.getDob());
				responseList.add(bankCustomerVO);

			}
		}
		return responseList;
	}
}