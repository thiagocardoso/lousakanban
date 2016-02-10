package com.thiagocardoso.tcc.repository;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.thiagocardoso.tcc.LousakanbanApplication;
import com.thiagocardoso.tcc.annotations.IntegrationTest;
import com.thiagocardoso.tcc.entities.Task;
import com.thiagocardoso.tcc.entities.User;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LousakanbanApplication.class)
@WebAppConfiguration
public class UserRepositoryIT {

	@Autowired
	private UserRepository repository;
	
	@Before
	public void setUp() {
		repository.deleteAll();
	}
	
	@Test
	public void createUser() {
		final User user = User.from("teste", "Usuário teste", "teste@teste.com", "teste");
		repository.save(user);		
	}
	
	@Test
	public void findByName() {
		newUser("teste", "User Test", "teste@teste.com", "teste");
		
		User user = repository.findByName("User Test");
		
		Assert.assertNotNull(user);
		Assert.assertEquals("User Test", user.getName());
	}
	
	@Test
	public void findByLogin() {
		newUser("test", "User Test", "teste@teste.com", "teste");
		
		User user = repository.findByLogin("test");
		
		Assert.assertNotNull(user);
		Assert.assertEquals("test", user.getLogin());		
	}
	
	@Test
	public void userWithTask() {
		User user = User.from("teste", "Usuario teste", "teste@teste.com", "teste");
		Task.from(user, "Teste!", "");
		repository.save(user);
		
		User userSaved = repository.findByLogin("teste");		
		assertFalse(userSaved.getTasks().isEmpty());
	}
	
	private void newUser(String login, String name, String email, String password) {
		repository.save(User.from(login, name, email, password));		
	}
}
