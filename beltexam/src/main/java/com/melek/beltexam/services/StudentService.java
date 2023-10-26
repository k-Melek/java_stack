package com.melek.beltexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melek.beltexam.models.Student;
import com.melek.beltexam.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studenRepository;
	
	public List<Student> findAll(){
		return studenRepository.findAll();
	}
	
	// Create student
	public Student createStudent(Student newStudent) {
		return studenRepository.save(newStudent);
	}
}
