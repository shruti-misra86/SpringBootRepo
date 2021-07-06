package com.example.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Employee;
import com.example.repository.EmployeeRepo;
import com.example.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	@Transactional
	public Object saveEmployee(Employee employee) {
		Map<String, String> map = new HashMap<>();
		if (employee.getFirstName().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "please enter first name");
		} else {
			map.put("status", "200");
			map.put("msg", "Employee saved successfully");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String formattedBirthDate = format1.format(employee.getBirthDate());
			String formattedHireDate = format1.format(employee.getHireDate());
			try {
				employee.setBirthDate(format1.parse(formattedBirthDate));
				employee.setHireDate(format1.parse(formattedHireDate));
			} catch (ParseException e) {

				e.printStackTrace();
			}

			employeeRepo.save(employee);
		}
		return map;

	}

	@Transactional
	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepo.findAll();
	}

	@Transactional
	@Override
	public Employee getEmployeeById(int id) {

		return employeeRepo.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Object updateEmployee(Employee employee) {
		Map<String, String> map = new HashMap<>();
		if (employee.getFirstName().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "please enter first name");
		} else {
			map.put("status", "200");
			map.put("msg", "employee successfully updated");

			String formattedBirthDate = formatter.format(employee.getBirthDate());
			String formattedHireDate = formatter.format(employee.getHireDate());
			try {
				employee.setBirthDate(formatter.parse(formattedBirthDate));
				employee.setHireDate(formatter.parse(formattedHireDate));
			} catch (ParseException e) {

				e.printStackTrace();
			}
			employeeRepo.saveAndFlush(employee);
		}
		return map;
	}

	@Transactional
	@Override
	public List<Employee> findAllByBirthDate(Employee employee) {

		String formattedBirthDate = formatter.format(employee.getBirthDate());

		try {
			return employeeRepo.findAllByBirthDate(formatter.parse(formattedBirthDate));
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<Employee> findAllByHireDateBetween(Employee employee) {
		Date currentDate = new Date();
		String formattedHireDate = formatter.format(employee.getHireDate());
		try {
			return employeeRepo.findAllByHireDateBetween(currentDate, formatter.parse(formattedHireDate));
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<Employee> findAllWithHireDateBefore(Employee employee) {

		String formattedHireDate = formatter.format(employee.getHireDate());

		try {
			return employeeRepo.findAllWithHireDateBefore(formatter.parse(formattedHireDate));
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}
	}

}
