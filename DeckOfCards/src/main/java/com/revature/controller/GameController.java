package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Game;
import com.revature.services.GameService;

@RestController
@RequestMapping(path="/game")
public class GameController {
	private GameService gServ;
	
	@Autowired
	public GameController(GameService gServ) {
		this.gServ = gServ;
	}
	
	@GetMapping
	public ResponseEntity<Set<Game>> getAllGames() {
		Set<Game> games = gServ.getAllGames();
		return ResponseEntity.ok(games);
	}
	
	@PostMapping
	public ResponseEntity<Game> addGame(@RequestBody Game game) {
		game.setId(gServ.addGame(game));
		return ResponseEntity.ok(game);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Game> getGame(@PathVariable("id") Integer id) {
		Game g = gServ.getGameById(id);
		if (g == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(g);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Game> updateGame(@PathVariable("id") Integer id, @RequestBody Game game) {
		gServ.updateGame(game);
		return ResponseEntity.ok(gServ.getGameById(id));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteGame(@PathVariable("id") Integer id) {
		Game game = gServ.getGameById(id);
		gServ.deleteGame(game);
		return ResponseEntity.noContent().build();
	}
}
