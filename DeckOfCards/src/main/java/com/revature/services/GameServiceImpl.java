package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Game;
import com.revature.data.GameDAO;

@Service
public class GameServiceImpl implements GameService{
	GameDAO gDao;
	
	
	public GameServiceImpl(GameDAO gDao) {
		this.gDao = gDao;
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
	public Set<Game> getGamesByPlayerId(Integer id) {
		return gDao.getGamesByPlayer(id);
	}

}
