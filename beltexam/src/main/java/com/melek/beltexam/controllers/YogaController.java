package com.melek.beltexam.controllers;

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

import com.melek.beltexam.models.Student;
import com.melek.beltexam.models.User;
import com.melek.beltexam.models.Yoga;
import com.melek.beltexam.services.StudentService;
import com.melek.beltexam.services.UserService;
import com.melek.beltexam.services.YogaService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class YogaController {

	// injection
	@Autowired
	private YogaService yogaServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private StudentService studentServ;

	@GetMapping("/classes")
	public String AllClasses(Model model, HttpSession session) {

		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		// Grab user id from session
		Long userId = (Long) session.getAttribute("user_id");
		User user = userServ.findById(userId);

		// Send user to JSP
		model.addAttribute("user", user);

		// send list of teams to JSP
		List<Yoga> allTheClasses = yogaServ.allYogas();
		model.addAttribute("classesList", allTheClasses);

		return "dashboard.jsp";
	}

	// View route Create class
	@GetMapping("/classes/new")
	public String create(@ModelAttribute("yoga") Yoga yoga, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		}
		return "createClass.jsp";
	}

	@PostMapping("/classes/new")
	public String createClass(@Valid @ModelAttribute("yoga") Yoga yoga, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "createClass.jsp";
		} else {
			// 1. Grab the current user's ID from Session
			Long userID = (Long) session.getAttribute("user_id");

			// 2. Fetch the user from the DB
			User currentUser = userServ.findById(userID);

			// 3. Set PostedBy to be the current user
			yoga.setPostedBy(currentUser);


			// 5. Save the class
			yogaServ.createYoga(yoga);

			return "redirect:/classes";
		}
	}
	

	// Display Route - Edit form
	@GetMapping("/classes/edit/{id}")
	public String editClass(@PathVariable("id") Long id, Model model, HttpSession session) {

		// grab the user id from session
		Long userID = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userID == null) {
			return "redirect:/";
		}

		Yoga thisYoga = yogaServ.findYoga(id);
		model.addAttribute("yoga", thisYoga);
		return "editYoga.jsp";
	}

	// Action route for EDIT TEAM
	@PutMapping("/classes/edit/{id}")
	public String updateClass(@Valid @ModelAttribute("yoga") Yoga yoga, BindingResult result, HttpSession session,
			@PathVariable("id") Long id) {

		if (result.hasErrors()) {
			return "editTeam.jsp";
		} else {
			// Grab current User SET As leader (poster of team)
			Long userID = (Long) session.getAttribute("user_id");
			User currentUser = userServ.findById(userID);

			yoga.setPostedBy(currentUser);
			yogaServ.updateYoga(yoga);
			return "redirect:/classes";
		}
	}

	// View Route show One class
	@GetMapping("/classes/{id}")
	public String showOne(@PathVariable("id") Long id, 
			Model model, 
			HttpSession session,
			@Valid @ModelAttribute("student") Student student, 
			BindingResult result
			) {
		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		}
		User loggedUser = userServ.findById(userId);
		loggedUser.getClasses().add(null);
		
		List<Student> allTheStudents = studentServ.findAll();
		model.addAttribute("allTheStudents", allTheStudents);

		Yoga thisYoga = yogaServ.findYoga(id);
		model.addAttribute("yoga", thisYoga);
		return "showClass.jsp";
	}

	// Action route // DELETE
	@DeleteMapping("/classes/{id}")
	public String delete(@PathVariable("id") Long id) {
		yogaServ.deleteYoga(id);
		return "redirect:/classes";
	}

}
