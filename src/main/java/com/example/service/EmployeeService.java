package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeService {
	public Object saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public Object updateEmployee(Employee employee);

	public List<Employee> findAllByBirthDate(Employee employee);

	public List<Employee> findAllByHireDateBetween(Employee employee);

	public List<Employee> findAllWithHireDateBefore(Employee employee);

}
