package com.melek.springintro.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@RequestMapping("/index")
	public String index() {
		return "This is a test";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "<h1>THis is the home page</h1><hr><p>test test</p>";
	}
	
	// ===Query PARAMETERS===
	// http://localhost:8080/search?q=java+doc
	
	@RequestMapping("/search")
	public String search(@RequestParam(value="q") String query) {
		return "You searcher for " + query;
	}
	
	// ===Path Variables===
	// http://localhost:8080/hello/{name}  <<< our variable is bob
	@RequestMapping("/hello/{name}/{age}")
	public String Hello(@PathVariable("name") String nameFromUrl,
						@PathVariable("age") String age
			) {
		return "This is the username from url " + nameFromUrl + " he's " + age;
	}
	
}
