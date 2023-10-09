package com.melek.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {

	@RequestMapping("/omikuji")
	public String Omikuji() {

		return "omikuji.jsp";
	}

	@RequestMapping(value = "/omikuji/show", method = RequestMethod.POST)
	public String show(@RequestParam(value = "luckyNumber") String luckyNumber,
			@RequestParam(value = "cityName") String cityName, @RequestParam(value = "personName") String personName,
			@RequestParam(value = "endeavor") String endeavor, @RequestParam(value = "livingThing") String livingThing,
			@RequestParam(value = "somethingNice") String somethingNice, HttpSession session) {
		
		
		session.setAttribute("luckyNumber", luckyNumber);
		session.setAttribute("cityName", cityName);
		session.setAttribute("personName", personName);
		session.setAttribute("endeavor", endeavor);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("somethingNice", somethingNice);
		System.out.println("Lucky Number: " + luckyNumber);
		return "show.jsp";
	}

	@RequestMapping("/omikuji/show")
	public String show() {
		
		return "show.jsp";
	}
}
