package com.thiagocardoso.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiagocardoso.tcc.entities.Team;
import com.thiagocardoso.tcc.repository.TeamRepository;

@RestController
@RequestMapping("/ws/teams")
public class TeamController {

	@Autowired
	TeamRepository teamRepository;

	@RequestMapping("list")
	public List<Team> list() {
		return teamRepository.findAll();
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("name") String name) {
		try {
			teamRepository.save(Team.withName(name));
			return "OK";
		} catch (Exception e) {
			return "ERROR";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void delete(@RequestBody Team team) {
		teamRepository.delete(team);
	}
	
}
