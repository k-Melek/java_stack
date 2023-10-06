package com.melek.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@RequestMapping("/")
	public String hello(@RequestParam(name = "name", defaultValue = "john") String name,
						@RequestParam(name="last_name", defaultValue = "doe") String last_name,
						@RequestParam(name="times", defaultValue = "1") int times
			) {
		
		String result = "";
		 for(var i = 0; i < times ; i++) {
			 result += "Hello, " + name +" " + last_name + "!<br>";
		}
		 return result;
	}
}
