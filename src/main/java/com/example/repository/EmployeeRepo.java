package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByBirthDate(Date birthDate);

	public List<Employee> findAllByHireDateBetween(Date currentDate, Date hireDate);

	@Query("select a from Employee a where a.hireDate <= :hireDate")
	List<Employee> findAllWithHireDateBefore(@Param("hireDate") Date hireDate);

}
