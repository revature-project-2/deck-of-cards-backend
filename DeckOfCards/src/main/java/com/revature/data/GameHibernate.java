package com.revature.data;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Game;
import com.revature.beans.Player;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;


@Repository
public class GameHibernate implements GameDAO{
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	private Logger log = Logger.getLogger(GameHibernate.class);

	@Override
	public Integer add(Game g) {
		log.trace("Adding new game to the database");
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(g);
			tx.commit();
			log.trace("Added new game successfully. Game id: "+g.getId());
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			log.error(e);
		} finally {
			s.close();
		}
		return g.getId();
	}

	@Override
	public Game getById(Integer id) {
		log.trace("Getting a game with id: "+id);
		Session s = hu.getSession();
		Game g = s.get(Game.class, id);
		s.close();
		if(g == null) {
			log.trace("No game with that id");
		}
		log.trace("Successfully got the game.");
		return g;
	}

	@Override
	public Set<Game> getAll() {
		log.trace("Getting all the games from the database");
		Session s = hu.getSession();
		String query = "FROM game";
		Query<Game> q = s.createQuery(query, Game.class);
		List<Game> gameList = q.getResultList();
		Set<Game> gameSet = new TreeSet<Game>();
		gameSet.addAll(gameList);
		s.close();
		log.trace("Got all games");
		return gameSet;
	}

	@Override
	public void update(Game g) {
		log.trace("Update Game with game id "+ g.getId());
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(g);
			tx.commit();
			log.trace("Updated Game successfully");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, GameHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void delete(Game g) {
		log.trace("Deleting Game with id "+g.getId());
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(g);
			tx.commit();
			log.trace("Deleted Game successfully.");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, GameHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	@Deprecated //method no longer needed, we can get the games from our person object easily now
	public Set<Game> getGamesByPlayer(Integer playerId) {
		log.warn("DEPRECATED METHOD CALL: getCatsByOwner, USE Person.getCats INSTEAD");
		Session s = hu.getSession();
		Player p = s.get(Player.class, playerId);
//		return p.getGames();
		return null;
	}
}
