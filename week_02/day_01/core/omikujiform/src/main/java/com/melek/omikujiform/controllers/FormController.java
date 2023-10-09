package com.melek.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	
	
	
	@RequestMapping("omikuji")
	public String Omikuji() {
		return "omikuji.jsp";
	}
}	
