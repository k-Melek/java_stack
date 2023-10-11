package com.melek.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.melek.savetravels.models.Travel;
import com.melek.savetravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {

	@Autowired
	private TravelService travelService;
	
	// View route
	@GetMapping("/travels")
	public String allBooks(Model model, @ModelAttribute("travel") Travel travel) {
		List<Travel> allTravels = travelService.findAll();
		model.addAttribute("listOfTravels", allTravels);
		
		return "travels.jsp";
	}
	
	// action route - Create A TRAVEL
	@PostMapping("/travels")
	public String createTrave(@Valid @ModelAttribute("travel") Travel travel, BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			// Bring the list so it shows after failed creation and re rendering
			
			List<Travel> allTravels = travelService.findAll();
			model.addAttribute("listOfTravels", allTravels);
			// If there is errors we going to re send the object
			
			return "travels.jsp";
		} else {
			// if no errors save book to Database
			Travel newTravel = travelService.createTravel(travel);
			return "redirect:/travels";
		}
	}
	
	// View Route for EDIT 
	
	@GetMapping("/edit/{id}")
	public String editpage(@PathVariable("id") Long id, Model model) {
		// find the book with the provided id from url
		Travel thisTravel = travelService.findTravel(id);
		model.addAttribute("travel", thisTravel);
		
		return "edit.jsp";
	}
	
	// Action route Edit Travel
	
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			// if there are no errors , Update the object 
			travelService.updateTravel(travel);
			return "redirect:/travels";
		}
	}
	
	// Action route DELETE
	
		@DeleteMapping("/travels/{id}")
		public String delete(@PathVariable("id") Long id) {
			travelService.deleteTravel(id);
			return "redirect:/travels";
		}
	
}
