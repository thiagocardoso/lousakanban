package com.thiagocardoso.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(name = "create", method = RequestMethod.POST)
	public String create(@RequestBody User user) {
		try {
			userRepository.save(user);
			return "OK";
		} catch (Exception e) {
			return "ERROR";
		}
	}
}
