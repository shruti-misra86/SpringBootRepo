package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/saveStudent")
	public Object insertStudent(@RequestBody Student student) {
		return (studentService.saveStudent(student));
	}

	@GetMapping("/getStudents")
	public List<Student> getAllStudent() {
		return (studentService.getAllStudent());
	}

	@GetMapping("/getStudent/{id}")
	public Student getStudentById(@PathVariable int id) {
		return (studentService.getStudentById(id));
	}

	@PutMapping("/updateStudent")
	public Object updateStudent(@RequestBody Student student) {
		return (studentService.updateStudent(student));
	}

	@PostMapping("/getDetailsByCollegeName")
	public List<Student> getAllStudentsByCollegeName(@RequestBody Student student) {
		return (studentService.getAllStudentByCollegeName(student));
	}

	@GetMapping("/getName")
	public Object getName() {
		return (studentService.getName());
	}

}
