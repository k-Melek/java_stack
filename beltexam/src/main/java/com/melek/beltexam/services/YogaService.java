package com.melek.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melek.beltexam.models.Yoga;
import com.melek.beltexam.repositories.YogaRepository;

@Service
public class YogaService {

	@Autowired
	private YogaRepository yogaRepo;

	public List<Yoga> allYogas() {
		return yogaRepo.findAll();
	}

	// CREATE
	public Yoga createYoga(Yoga newYoga) {
		return yogaRepo.save(newYoga);
	}

	// READ ONE
	public Yoga findYoga(Long id) {

		Optional<Yoga> maybeYoga = yogaRepo.findById(id);
		if (maybeYoga.isPresent()) {
			return maybeYoga.get();
		} else {
			return null;
		}
	}
	
	// UPDATE 
	public Yoga updateYoga(Yoga updatedYoga) {
		return yogaRepo.save(updatedYoga);
	}
	
	// DELETE
	public void deleteYoga(Long id) {
		yogaRepo.deleteById(id);
	}
}
