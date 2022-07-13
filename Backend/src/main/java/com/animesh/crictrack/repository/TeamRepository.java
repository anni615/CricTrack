package com.animesh.crictrack.repository;

import org.springframework.data.repository.CrudRepository;

import com.animesh.crictrack.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long>  {
    
    Team findByTeamName(String teamName);

}
