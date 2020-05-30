package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Game;
import com.revature.data.GameDAO;
import com.revature.data.PlayerDAO;

public class GameServiceImpl implements GameService{
	PlayerDAO pDao;
	GameDAO gDao;
	
	@Autowired
	public GameServiceImpl(PlayerDAO p, GameDAO g) {
		pDao = p;
		gDao = g;
	}

	@Override
	public Integer addGame(Game g) {
		return gDao.add(g);
	}

	@Override
	public Set<Game> getAllGames() {
		return gDao.getAll();
	}

	@Override
	public Game getGameById(Integer id) {
		return gDao.getById(id);
	}

	@Override
	public void updateGame(Game g) {
		gDao.update(g);
	}

	@Override
	public void deleteGame(Game g) {
		gDao.delete(g);
	}

	@Override
	public Game getGameByPlayerId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
