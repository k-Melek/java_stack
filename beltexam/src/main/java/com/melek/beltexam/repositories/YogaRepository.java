package com.melek.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melek.beltexam.models.Yoga;

@Repository
public interface YogaRepository extends CrudRepository<Yoga, Long> {

	// Read All
	List<Yoga> findAll();
}
