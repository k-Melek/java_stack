package com.melek.javasession.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
	
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		String name = "Amy";
		model.addAttribute("userName", name);
		session.setAttribute("sessionName", name);
		return "index.jsp";
	}
	
	
	@RequestMapping("/cool")
	public String cool(HttpSession session) {
		String someName = (String) session.getAttribute("sessionName");
		System.out.println("-----" + someName);
		return "cool.jsp";
	}
}
