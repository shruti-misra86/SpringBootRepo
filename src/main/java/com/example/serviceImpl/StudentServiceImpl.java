package com.example.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Student;
import com.example.repository.StudentRepo;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	@Transactional
	public Object saveStudent(Student student) {
		Map<String, String> map = new HashMap<>();
		if (student.getName().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "please enter name");
		} else {
			map.put("status", "200");
			map.put("msg", "success");
			studentRepo.save(student);
		}
		return map;
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {

		return studentRepo.findAll();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return studentRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Object updateStudent(Student student) {
		Map<String, String> map = new HashMap<>();
		if (student.getName().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "please enter name");
		} else {
			map.put("status", "200");
			map.put("msg", "Data update success");
			studentRepo.saveAndFlush(student);
		}
		return map;
	}

	@Override
	public List<Student> getAllStudentByCollegeName(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.getStudentsByCollegeName(student.getCollegeName());
	}

	@Override
	public Object getName() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Shruti");
		return map;
	}

}
