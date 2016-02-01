package com.thiagocardoso.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiagocardoso.tcc.entities.Task;
import com.thiagocardoso.tcc.repository.TaskRepository;

@RestController
@RequestMapping("/ws/tasks")
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@RequestMapping("list")
	public List<Task> list() {
		return taskRepository.findAll();
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("title") String title) {
		try {
//			User user = userRepository.findByLogin(login);
//			if(user!=null) {
//				user.setName(name);
//				user.setEmail(email);
//				user.setPassword(password);
//			}else{
//				user = User.from(login, name, email, password);
//			}
			
			Task task = Task.Builder.of(title).build();
			
			taskRepository.save(task);
			return "OK";
		} catch (Exception e) {
			return "ERROR";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void delete(@RequestBody Task task) {
		taskRepository.delete(task);
	}
	
}
