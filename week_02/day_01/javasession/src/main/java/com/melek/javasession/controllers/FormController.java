package com.melek.javasession.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller

public class FormController {
	
	// View route
	@RequestMapping("/form")
	public String form() {
		return "demo/demo.jsp";
	}
	// action route
	@RequestMapping(value="processForm", method=RequestMethod.POST)
	public String process(@RequestParam(value="email") String email,
						@RequestParam(value="password") String pass,
						HttpSession sesh
			) {
		
		sesh.setAttribute("password", pass);
		sesh.setAttribute("email", email);
		//System.out.println(email + " : " + pass);
		return "redirect:/display";
	}
	
	// Action route
	@RequestMapping("/search")
	public String search(@RequestParam(value="query") String query,
						HttpSession session
			) {
		session.setAttribute("searchQuery", query);
		return "redirect:/display";
	}
	
	
	// View route
	@RequestMapping("/display")
	public String display() {
		return "demo/display.jsp";
	}
	
}
