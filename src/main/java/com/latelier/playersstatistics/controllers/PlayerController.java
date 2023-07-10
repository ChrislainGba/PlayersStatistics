package com.latelier.playersstatistics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latelier.playersstatistics.entities.Player;
import com.latelier.playersstatistics.exception.ResourceNotFoundException;
import com.latelier.playersstatistics.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
	@Autowired
	PlayerService playerService;
		
	@GetMapping("/list")
	public ResponseEntity<List<Player>> getPlayers() throws ResourceNotFoundException{
        List<Player> players = playerService.findAll();
        return ResponseEntity.ok(players);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Player> getPlayer(@PathVariable Long id) throws ResourceNotFoundException{
        Player player = playerService.findById(id);
        return ResponseEntity.ok(player);

	}

}
