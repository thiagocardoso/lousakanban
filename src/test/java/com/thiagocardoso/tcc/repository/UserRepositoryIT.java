package com.thiagocardoso.tcc.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.thiagocardoso.tcc.LousakanbanApplication;
import com.thiagocardoso.tcc.annotations.IntegrationTest;
import com.thiagocardoso.tcc.entities.User;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LousakanbanApplication.class)
@WebAppConfiguration
public class UserRepositoryIT {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void createUser() {
		final User user = User.from("teste", "Usuário teste");
		repository.save(user);		
	}
}
