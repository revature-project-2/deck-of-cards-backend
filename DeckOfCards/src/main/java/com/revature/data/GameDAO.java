package com.revature.data;

import java.util.Set;

import com.revature.beans.Game;

public interface GameDAO extends GenericDAO<Game>{
	public Set<Game> getGamesByPlayer(Integer playerId);
}
