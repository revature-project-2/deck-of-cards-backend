package com.revature.data;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Player;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Repository
public class PlayerHibernate implements PlayerDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	private Logger log = Logger.getLogger(PlayerHibernate.class);
	
	@Override
	public Integer add(Player p) {
		log.trace("Adding a new player to the database");
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(p);
			tx.commit();
			log.trace("Added new player successfully. Player id: " + p.getId());
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			log.error(e);
		} finally {
			s.close();
		}
		return p.getId();
	}
	
	@Override
	public Player getById(Integer id) {
		log.trace("Getting player with id " + id);
		Session s = hu.getSession();
		Player p = s.get(Player.class, id);
		s.close();
		if(p == null)
		{
			log.trace("No player with that id.");
		}
		log.trace("Successfully got the player.");
		return p;
	}
	
	@Override
	public Set<Player> getAll() {
		log.trace("Getting all the players from database");
		Session s = hu.getSession();
		String query = "FROM Player";
		Query<Player> q = s.createQuery(query, Player.class);
		List<Player> playerList = q.getResultList();
		Set<Player> playerSet = new TreeSet<Player>();
		playerSet.addAll(playerList);
		s.close();
		log.trace("Got all players.");
		return playerSet;
	}
	
	@Override
	public void update(Player t) {
		log.trace("Updating Player with id " + t.getId());
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			// the update method will make the given transient object persistent
			// the merge method will update any info on a current persistent object
			s.update(t);
			tx.commit();
			log.trace("Updated Player successfully.");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, PlayerHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void delete(Player t) {
		log.trace("Deleting Player with id " + t.getId());
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, PlayerHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public Player getPlayerByUsernameAndPassword(String username, String password) {
		log.trace("Getting player by username and password from database");
		Session s = hu.getSession();
		CriteriaBuilder cb = s.getCriteriaBuilder(); // this allows us to build our query
		CriteriaQuery<Player> criteria = cb.createQuery(Player.class); // this is our query object
		Root<Player> root = criteria.from(Player.class); // this is the root of our query, i.e. "from Player"
		
		// these allow us to set conditions for our "where" clause
		Predicate predicateForUsername = cb.equal(root.get("username"), username);
		Predicate predicateForPassword = cb.equal(root.get("password"), password);
		Predicate predicateForUsernamePassword = cb.and(predicateForUsername, predicateForPassword);
		
		// select from Player where username = username, password = password
		criteria.select(root).where(predicateForUsernamePassword);
		
		Player p = s.createQuery(criteria).getSingleResult();
		if (p == null)
		{
			log.trace("No player found with that username and password.");
		}
		else
		{
			log.trace("Got player.");
		}
		return p;
	}
	
}