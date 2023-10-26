package com.melek.teamgame.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melek.teamgame.models.Team;
import com.melek.teamgame.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepo;

	public List<Team> allTeams() {
		return teamRepo.findAll();
	}

	// CREATE
	public Team createTeam(Team newTeam) {
		return teamRepo.save(newTeam);
	}

	// READ ONE
	public Team findTeam(Long id) {

		Optional<Team> maybeTeam = teamRepo.findById(id);
		if (maybeTeam.isPresent()) {
			return maybeTeam.get();
		} else {
			return null;
		}
	}
	
	// UPDATE 
	public Team updateTeam(Team updatedTeam) {
		return teamRepo.save(updatedTeam);
	}
	
	// DELETE
	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}
}
