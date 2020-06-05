package com.revature.controller;

import java.util.Set;

import com.revature.data.PlayerHibernate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.Game;
import com.revature.services.GameService;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@RequestMapping(path="/game")
@CrossOrigin(origins="https://cardgamesprod.s3-us-west-2.amazonaws.com/deck-of-cards-front/")
public class GameController {
	private GameService gServ;
	private Logger log = Logger.getLogger(PlayerHibernate.class);
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
