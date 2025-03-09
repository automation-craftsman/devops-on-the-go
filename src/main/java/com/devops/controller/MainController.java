package com.devops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}

	@PostMapping("/get-started")
	public String getStarted(@RequestParam("getStartedInput") String input) {
		// Handle the form submission, e.g., print the input value
		System.out.println("Get Started input: " + input);
		return "index.html"; // Return the same page for now
	}
}