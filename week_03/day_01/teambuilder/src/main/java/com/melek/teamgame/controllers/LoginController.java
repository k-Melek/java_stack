package com.melek.teamgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.melek.teamgame.models.LoginUser;
import com.melek.teamgame.models.User;
import com.melek.teamgame.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {

	// Dependency injection ?
		@Autowired
		private UserService userServ;
		
		// View Route for forms (Register + Login)
		@GetMapping("/")
		public String index(Model model) {
			// Send both User and Login empty objects for the forms
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		// Action route for Register Form
			@PostMapping("/register")
			public String register(@Valid @ModelAttribute("newUser") User newUser,
									BindingResult result,
									Model model,
									HttpSession session) {
				// Call in the register method
				userServ.register(newUser, result);
				// Validation if there are errors RE SEND login model
				if(result.hasErrors()) {
					// Error exist Re send login model + re render
					model.addAttribute("newLogin", new LoginUser());
					return "index.jsp";
				} else {
					// No errors >>> Pass id to session and redirect
					session.setAttribute("user_id", newUser.getId());
					return "redirect:/teams";
				}
			}
			
			// Action Route for Login Form
			@PostMapping("/login")
			public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
					BindingResult result,
					Model model,
					HttpSession session) {
				// Call the login method
				User user = userServ.login(newLogin, result);
				// validate check for errors
				if(result.hasErrors()) {
					// If there are errors re render and re Send the user for register
					model.addAttribute("newUser", new User());
					return "index.jsp";
				}else {
					// No errors >>> Send id to session and Log them in
					session.setAttribute("user_id", user.getId());
					return "redirect:/teams";
				}
			}
			
			
			// Action route for Logout
			@GetMapping("/logout")
			public String logout(HttpSession session) {
				session.invalidate();
				return "redirect:/";
			}
			
}
