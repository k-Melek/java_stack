package com.melek.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melek.savetravels.models.Travel;
import com.melek.savetravels.repositories.TravelRepository;

@Service
public class TravelService {

	// Dependency injection
	@Autowired
	private TravelRepository travelRepo;
	
	// CRUD !!!
	
	// Read all
	public List<Travel> findAll(){
		return travelRepo.findAll();
	}
	
	// Create 
	public Travel createTravel(Travel trip) {
		return travelRepo.save(trip);
	}
	
	// Read one
	public Travel findTravel(Long id) {
		Optional<Travel> maybeTravel = travelRepo.findById(id);
		if(maybeTravel.isPresent()) {
			return maybeTravel.get();
		} else {
			return null;
		}
	}
	
	// update <<<
	public Travel updateTravel(Travel trip) {
		return travelRepo.save(trip);
	}
	
	// Delete
	public void deleteTravel(Long id) {
		travelRepo.deleteById(id);
	}
	
	
	
}
