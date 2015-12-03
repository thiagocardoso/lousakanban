package com.thiagocardoso.tcc.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.thiagocardoso.tcc.LousakanbanApplication;
import com.thiagocardoso.tcc.annotations.IntegrationTest;
import com.thiagocardoso.tcc.entities.Team;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LousakanbanApplication.class)
@WebAppConfiguration
public class TeamRepositoryIT {

	@Autowired
	private TeamRepository repository;
	
	@Test
	public void createUser() {
		final Team team = Team.withName("teste");
		repository.save(team);		
	}
}
