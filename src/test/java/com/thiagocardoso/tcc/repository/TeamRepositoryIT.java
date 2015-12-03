package com.thiagocardoso.tcc.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
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
	
	@Before
	public void setUp() {
		newTeamTest();		
	}
	
	@Test
	public void findByName() {
		Team team = repository.findByName("test");
		assertNotNull(team);
		assertEquals("test", team.getName());
	}
	
	private void newTeamTest() {
		final Team team = Team.withName("test");
		repository.save(team);
	}
}
