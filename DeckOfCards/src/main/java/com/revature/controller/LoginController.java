package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Player;
import com.revature.services.PlayerService;
import com.revature.services.PlayerServiceImpl;

@RestController
@RequestMapping(path="/login")
public class LoginController {
	private PlayerService pServ;
	
	@Autowired
	public LoginController(PlayerService p) {
		pServ = p;
	}
	
	@GetMapping
	public ResponseEntity<Player> getLoggedPlayer(HttpSession session) {
		Player p = (Player) session.getAttribute("player");
		if(p == null)
		{
			return loginPlayer(session, p);
		}
		else
		{
			return ResponseEntity.ok(p);
		}
	}
	
	@PutMapping
	@RequestMapping(path="/register")
	public ResponseEntity<Player> registerPlayer(@RequestBody Player player) {
		player.setId(pServ.addPlayer(player));
		
		return ResponseEntity.ok(player);
	}
	
	@PostMapping
	public ResponseEntity<Player> loginPlayer(HttpSession session, @RequestBody Player player){
		Player tempP = pServ.getPlayerByUsernameAndPassword(player.getUsername(), player.getPassword());
		if(tempP == null) {
			//return ResponseEntity.status(404).build();
			return ResponseEntity.notFound().build();
		}
		session.setAttribute("player", tempP);
		return ResponseEntity.ok(tempP);
	}
	
	@DeleteMapping // Delete of CRUD
	public ResponseEntity<Void> logoutPlayer(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok().build();
	}
}
