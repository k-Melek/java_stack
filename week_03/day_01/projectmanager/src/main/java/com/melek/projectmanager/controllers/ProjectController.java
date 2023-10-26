package com.melek.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.melek.projectmanager.models.Project;
import com.melek.projectmanager.models.User;
import com.melek.projectmanager.services.ProjectService;
import com.melek.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {

	// Inject both dependency User + Project
	@Autowired
	private ProjectService projectServ;
	@Autowired
	private UserService userServ;

	// View route - show all projects
	@GetMapping("/dashboard")
	public String AllProjects(Model model, HttpSession session) {

		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		// Grab user id from session
		Long userId = (Long) session.getAttribute("user_id");
		User user = userServ.findById(userId);
		
		// Send user to JSP
		model.addAttribute("user", user);
		// Grab joined Projects from DB
		model.addAttribute("joinedProjectsList", projectServ.findJoinedProjects(user));
		// Grab not Joined projects list
		model.addAttribute("notJoinedProjectsList", projectServ.findNotJoinedProjects(user));

		return "project/dashboard.jsp";
	}
	
	// View Route Show One project
	@GetMapping("/projects/{id}")
	public String showOne(@PathVariable("id") Long id, 
					HttpSession session,
					Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		Project project = projectServ.findOneProject(id);
		model.addAttribute("project", project);
		return "project/showProject.jsp";
	}
	
	
	

	// View Route - Show Create new
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("user_id");
		model.addAttribute("userId", userId);
		return "project/newProject.jsp";
	}

	// Action route for create new
	@PostMapping("/projects/new")
	public String addNewProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
			HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}

		if (result.hasErrors()) {
			return "project/newProject.jsp";
		} else {
			projectServ.createProject(project);
			Long userId = (Long) session.getAttribute("user_id");
			User loggedUser = userServ.findById(userId);
			loggedUser.getProjects().add(project);
			project.setLead(loggedUser);
			userServ.updateUser(loggedUser);

			return "redirect:/dashboard";
		}
	}

	// View route for EDIT
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		Project project = projectServ.findOneProject(id);
		model.addAttribute("project", project);
		return "project/editProject.jsp";
	}
	
	// Action route for Edit
	@PostMapping("projects/edit/{id}")
	public String update(
			@PathVariable("id") Long id, 
			@Valid @ModelAttribute("project") Project project, 
			BindingResult result, 
			HttpSession session) {
		
		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("user_id");
		User user = userServ.findById(userId);
		
		if(result.hasErrors()) {
			return "project/editProject.jsp";
		} else {
			Project oldProject = projectServ.findOneProject(id);
			project.setUsers(oldProject.getUsers());
			project.setLead(user);
			projectServ.updateProject(project);
			return "redirect:/dashboard";
		}
	}
	
	
	// Action Route JOIN PROJECT
	@GetMapping("/dashboard/join/{id}")
	public String clickJoin(@PathVariable("id") Long id,
			HttpSession session,
			Model model) {
		
		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("user_id");
		
		Project project = projectServ.findOneProject(id);
		User user = userServ.findById(userId);
		
		user.getProjects().add(project);
		userServ.updateUser(user);
		
		// Send user to JSP
		model.addAttribute("user", user);
		// Grab joined Projects from DB
		model.addAttribute("joinedProjectsList", projectServ.findJoinedProjects(user));
		// Grab not Joined projects list
		model.addAttribute("notJoinedProjectsList", projectServ.findNotJoinedProjects(user));
		
		return "redirect:/dashboard";
	}
	
	
	// Action route LEAVE PROJECT 
	@GetMapping("/dashboard/leave/{id}")
	public String clickLeave(@PathVariable("id") Long id,
			HttpSession session,
			Model model) {
		
		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("user_id");
		
		Project project = projectServ.findOneProject(id);
		User user = userServ.findById(userId);
		
		user.getProjects().remove(project);
		userServ.updateUser(user);
		
		// Send user to JSP
		model.addAttribute("user", user);
		// Grab joined Projects from DB
		model.addAttribute("joinedProjectsList", projectServ.findJoinedProjects(user));
		// Grab not Joined projects list
		model.addAttribute("notJoinedProjectsList", projectServ.findNotJoinedProjects(user));
				
		return "redirect:/dashboard";
	}
	
	
	// ACtion route DELETE PROJECT
	@DeleteMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id,
			HttpSession session) {
		
		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		
		projectServ.deleteProject(id);
		return "redirect:/dashboard";
	}
	
}
