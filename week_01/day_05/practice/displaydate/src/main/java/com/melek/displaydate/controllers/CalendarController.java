package com.melek.displaydate.controllers;


import org.springframework.ui.Model;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CalendarController {
	
	@RequestMapping("/")
	public String home() {
		return "dashboard.jsp";
	}
	
	@RequestMapping("/date")
		public String date(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy");
		String formatedDate = dateFormat.format(currentDate);
		model.addAttribute("formatedDate", formatedDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date currentTime = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		String formatedTime = timeFormat.format(currentTime);
		model.addAttribute("formatedTime", formatedTime);
		return "time.jsp";
	}

}
