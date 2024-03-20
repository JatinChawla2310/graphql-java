package com.example.graphql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.model.Player;
import com.example.graphql.model.Team;
import com.example.graphql.service.PlayerService;

@Controller
public class PlayerController {

//	https://www.youtube.com/watch?v=eD-1KTK7fGc
	private final PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
		this.playerService=playerService;
	}
	
	@QueryMapping
	public List<Player> findAll(){
		return playerService.findAll();
	}
	
	@QueryMapping
	public Optional<Player> findOne(@Argument Integer id){
		return playerService.findOne(id);
	}
	
	@MutationMapping
	public Player create(@Argument String name, @Argument Team team) {
		return playerService.create(name, team);
	}
	
	@MutationMapping
	public Player update(@Argument Integer id, @Argument String name, @Argument Team team) {
		return playerService.update(id, name, team);
	}
	
	@MutationMapping
	public Player delete(@Argument Integer id) {
		return playerService.delete(id);
	}
}
