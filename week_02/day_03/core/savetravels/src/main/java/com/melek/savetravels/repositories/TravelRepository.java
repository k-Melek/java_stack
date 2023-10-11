package com.melek.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melek.savetravels.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {

	// read all
	List<Travel> findAll();
}
