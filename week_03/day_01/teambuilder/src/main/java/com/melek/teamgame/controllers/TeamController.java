package com.melek.teamgame.controllers;

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

import com.melek.teamgame.models.Team;
import com.melek.teamgame.models.User;
import com.melek.teamgame.services.TeamService;
import com.melek.teamgame.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamServ;
	@Autowired
	private UserService userServ;

	@GetMapping("/teams")
	public String AllProjects(Model model, HttpSession session) {

		if (session.getAttribute("user_id") == null) {
			return "redirect:/logout";
		}
		// Grab user id from session
		Long userId = (Long) session.getAttribute("user_id");
		User user = userServ.findById(userId);

		// Send user to JSP
		model.addAttribute("user", user);

		// send list of teams to JSP
		List<Team> allTheTeams = teamServ.allTeams();
		model.addAttribute("teamsList", allTheTeams);

		return "dashboard.jsp";
	}

	// DISPLAY ROUTE - CREATE FORM
	@GetMapping("/teams/new")
	public String create(@ModelAttribute("team") Team team, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		}
		return "createTeam.jsp";
	}

	// ACTION ROUTE - CREATE Form
	@PostMapping("/teams/new")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			return "createTeam.jsp";
		} else {
			// save the team
			// 1. grab the current user's ID from Session
			Long userID = (Long) session.getAttribute("user_id");
			// 2. fetch the user from the DB
			User currentUser = userServ.findById(userID);
			// 3. setPostedby to be the the current user
			team.setLeader(currentUser);
			teamServ.createTeam(team);

			return "redirect:/teams";
		}
	}

	// Display Route - Edit form
	@GetMapping("/teams/edit/{id}")
	public String editPage(@PathVariable("id") Long id, Model model, HttpSession session) {

		// grab the user id from session
		Long userID = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userID == null) {
			return "redirect:/";
		}

		Team thisTeam = teamServ.findTeam(id);
		model.addAttribute("team", thisTeam);
		return "editTeam.jsp";
	}

	// Action route for EDIT TEAM
	@PutMapping("/teams/edit/{id}")
	public String updateTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session,
			@PathVariable("id") Long teamID) {

		if (result.hasErrors()) {
			return "editTeam.jsp";
		} else {
			// Grab current User SET As leader (poster of team)
			Long userID = (Long) session.getAttribute("user_id");
			User currentUser = userServ.findById(userID);

			team.setLeader(currentUser);
			teamServ.updateTeam(team);
			return "redirect:/teams";
		}
	}

	// show oneTeam details
	@GetMapping("/teams/{id}")
	public String showOne(@PathVariable("id") Long id, 
			Model model, 
			HttpSession session) {
		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		}
		
		Team thisTeam = teamServ.findTeam(id);
		model.addAttribute("team", thisTeam);
		return "showTeam.jsp";
	}

	// Action route // DELETE
	@DeleteMapping("/teams/{id}")
	public String delete(@PathVariable("id") Long id) {
		teamServ.deleteTeam(id);
		return "redirect:/teams";
	}

}
