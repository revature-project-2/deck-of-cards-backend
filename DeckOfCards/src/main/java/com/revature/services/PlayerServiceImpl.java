package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Game;
import com.revature.beans.Player;
import com.revature.data.GameDAO;
import com.revature.data.PlayerDAO;

@Service
public class PlayerServiceImpl implements PlayerService {
	PlayerDAO pDao;
	GameDAO gDao;
	
	@Autowired
	public PlayerServiceImpl(PlayerDAO p, GameDAO g) {
		pDao = p;
		gDao = g;
	}

	@Override
	public Integer addPlayer(Player p) {
		return pDao.add(p);
	}

	@Override
	public Set<Player> getAllPlayers() {
		Set<Player> people = pDao.getAll();
		for (Player p : people) {
			if (p.getGames() == null)
				p.setGames(gDao.getGamesByPlayer(p.getId()));
		}
		return people;
	}

	@Override
	public Player getPlayerById(Integer id) {
		Player p = pDao.getById(id);
		if (p.getGames() == null)
			p.setGames(gDao.getGamesByPlayer(p.getId()));
		return p;
	}

	@Override
	public Player getPlayerByUsernameAndPassword(String username, String password) {
		Player p = pDao.getPlayerByUsernameAndPassword(username, password);
		if (p != null && p.getGames() == null) {
			p.setGames(gDao.getGamesByPlayer(p.getId()));
		}
		return p;
	}

	@Override
	public void updatePlayer(Player p) {
		pDao.update(p);
	}

	@Override
	public void deletePlayer(Player p) {
		for (Game g : p.getGames()) {
			gDao.delete(g);
		}
		pDao.delete(p);
	}

}
