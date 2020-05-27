package com.revature.services;

import java.util.Set;

import com.revature.beans.Player;

public interface PlayerService {
	public Integer addPlayer(Player p);
	public Set<Player> getAllPlayers();
	public Player getPlayerById(Integer id);
	public Player getPlayerByUsernameAndPassword(String username, String password);
	public void updatePlayer(Player p);
	public void deletePlayer(Player p);
}
