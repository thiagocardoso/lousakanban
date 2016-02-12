package com.thiagocardoso.tcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "board/index";
	}
	
	@RequestMapping("/users")
	public String users() {
		return "users/index";
	}
	
	@RequestMapping("/teams")
	public String teams() {
		return "teams/index";
	}
	
	@RequestMapping("/tasks")
	public String tasks() {
		return "tasks/index";
	}
}
