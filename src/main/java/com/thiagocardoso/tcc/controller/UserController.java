package com.thiagocardoso.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiagocardoso.tcc.entities.User;
import com.thiagocardoso.tcc.repository.UserRepository;

@RestController
@RequestMapping("/ws/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("list")
	public List<User> list() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("login") String login, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("password") String password) {
		try {
			userRepository.save(User.from(login, name, email, password));
			return "OK";
		} catch (Exception e) {
			return "ERROR";
		}
	}
}
