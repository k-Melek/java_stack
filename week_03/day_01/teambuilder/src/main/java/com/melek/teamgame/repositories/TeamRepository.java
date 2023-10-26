package com.melek.teamgame.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.melek.teamgame.models.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

	// Read All
	List<Team> findAll();
}
