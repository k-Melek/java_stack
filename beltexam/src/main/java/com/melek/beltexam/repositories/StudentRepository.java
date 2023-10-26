package com.melek.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.melek.beltexam.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findAll();
}
