package com.thiagocardoso.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.thiagocardoso.tcc.entities.Status;
import com.thiagocardoso.tcc.entities.Task;
import com.thiagocardoso.tcc.entities.User;
import com.thiagocardoso.tcc.repository.UserRepository;

@RestController
@RequestMapping("/ws/tasks")
public class TaskController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("list")
	public List<Task> list() {
		List<User> users = userRepository.findAll();
		List<Task> tasks = Lists.newArrayList();
		users.stream().forEach(u -> tasks.addAll(u.getTasks()));
		return tasks;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("userLogin") String userLogin, @RequestParam("title") String title, @RequestParam("description") String description) {
		try {
			User user = userRepository.findByLogin(userLogin);
			Task.from(user, title, description);
			userRepository.save(user);
			return "OK";
		} catch (Exception e) {
			return "ERROR";
		}
	}
	
	@RequestMapping(value = "step", method = RequestMethod.POST)
	public String step(@RequestParam("userLogin") String userLogin, @RequestParam("title") String title, @RequestParam("status") String status) {
		try {
			User user = userRepository.findByLogin(userLogin);
			
			Task task = user.taskByTitle(title);
			task.setStatus(Status.fromDescription(status));

			userRepository.save(user);
			return "OK";
		} catch (Exception e) {
			return "ERROR";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void delete(@RequestBody Task task) {
//		taskRepository.delete(task);
	}
	
}
