package com.revature.data;


import com.revature.beans.Player;

public interface PlayerDAO extends GenericDAO<Player> {
	public Player getPlayerByUsernameAndPassword(String username, String password);
}