package com.thiagocardoso.tcc.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TeamTest {
	
	private static final String EQUIPE_1 = "Equipe #1";

	@Test
	public void newTeam(){
		assertNotNull(Team.withName(EQUIPE_1));
	}

	@Test
	public void createNewTeamAndAddUser() {
		final Team team = Team.withName(EQUIPE_1);
		team.addUser(User.from("teste", "Usuário Teste"));
		assertFalse(team.getUsers().isEmpty());
		assertEquals(1, team.userCount());
	}
	
	@Test
	public void createNewTeamAddUserAndRemoveIt() {
		final Team team = Team.withName(EQUIPE_1);
		final User user = User.from("teste", "Usuário Teste");
		team.addUser(user);
		assertFalse(team.getUsers().isEmpty());
		assertEquals(1, team.userCount());
		team.removeUser(user);
		assertTrue(team.getUsers().isEmpty());
	}
	
}
