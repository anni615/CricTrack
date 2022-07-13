package com.animesh.crictrack.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.animesh.crictrack.model.Match;
import com.animesh.crictrack.model.Team;
import com.animesh.crictrack.repository.MatchRepository;
import com.animesh.crictrack.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
    
    
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;
    
    public TeamController(TeamRepository teamRepository,MatchRepository matchRepository) {
       
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team")
    public Iterable<Team> getAllTeam(){
        return this.teamRepository.findAll();
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){

        Team team=this.teamRepository.findByTeamName(teamName);
        
        team.setMatches(matchRepository.findLatestMatchesByTeam(teamName,4));
        return team;
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year)
    {
        LocalDate startDate= LocalDate.of(year,1,1);
        LocalDate endDate=LocalDate.of(year+1,1,1);
       return  this.matchRepository.getMatchesByTeamBetweenDates(
            teamName,
            startDate,
            endDate
            // teamName,
            // startDate,
            // endDate
        );
    }
   

}
