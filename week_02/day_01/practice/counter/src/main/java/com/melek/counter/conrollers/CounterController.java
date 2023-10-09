package com.melek.counter.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller

public class CounterController {
	
	
	@RequestMapping("/")
	public String index(HttpSession session) {

		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count+1);
		}
			return "index.jsp";

	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
			
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
    public String resetCount(HttpSession session) {
        session.setAttribute("count", 0);
        return "redirect:/counter";
    }
}
