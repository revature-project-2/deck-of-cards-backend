package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.Player;
import com.revature.services.PlayerService;

@RestController
@RequestMapping(path="/login")
@CrossOrigin(origins="http://localhost:4200")
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
//			return loginPlayer(session, p);
            return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(p);
		}
	}
	@PostMapping
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
