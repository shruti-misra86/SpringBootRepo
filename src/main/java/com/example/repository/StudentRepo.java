package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	// JPQL
	@Query("select u from Student u where u.collegeName=:collegeName")
	List<Student> getStudentsByCollegeName(@Param("collegeName") String collegeName);

}
