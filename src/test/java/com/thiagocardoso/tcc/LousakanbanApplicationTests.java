package com.thiagocardoso.tcc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.thiagocardoso.tcc.entities.User;
import com.thiagocardoso.tcc.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LousakanbanApplication.class)
@WebAppConfiguration
public class LousakanbanApplicationTests {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void createUser() {
		final User user = User.from("teste", "Usuário teste");
		repository.save(user);		
	}

}
