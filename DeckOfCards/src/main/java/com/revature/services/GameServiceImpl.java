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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Game> getAllGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game getGameById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGame(Game g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGame(Game g) {
		// TODO Auto-generated method stub
		
	}

}
