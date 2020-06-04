package com.revature.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.beans.Game;
import com.revature.beans.Player;
import com.revature.data.GameHibernate;
import com.revature.data.PlayerHibernate;
import com.revature.services.GameServiceImpl;
import com.revature.services.PlayerServiceImpl;

public class JUnitTests {
	static GameHibernate realGameHib;
	static PlayerHibernate realPlayerHib;

	@Mock 
	static GameHibernate gameHib;
	
	@Mock
	static PlayerHibernate playerHib;
	
	static Game gameMock = new Game();
	static Player playerMock = new Player();
	
	static Set<Game> gamesMock = new HashSet<Game>();
	static Set<Player> playersMock = new HashSet<Player>();
	
	@InjectMocks
	static GameServiceImpl gameImpl;
	
	static GameServiceImpl realGameImpl;
	
	@InjectMocks
	static PlayerServiceImpl playerImpl;
	
	static PlayerServiceImpl realPlayerImpl;
	
	@Rule
	public MockitoRule createMockCard = MockitoJUnit.rule();
	
	@BeforeClass
	public static void setUp() 
	{
		Game g = new Game();
		gamesMock.add(g);
		Player p = new Player();
		playersMock.add(p);
	}
	
	@Test
	public void testAddAGame()
	{
		Game g = new Game();
		g.setId(1);
		g.setDeckId("1");
		g.setAmount_won((float) 500);
		g.setScore(0);
		g.setType(null);
		
		gameHib.add(g);
		verify(gameHib).add(g);
	}
	
	@Test
	public void testAddAPlayer()
	{
		Player p = new Player();
		p.setId(1);
		p.setFirstname("Test");
		p.setLastname("Testerson");
		p.setBalance((double) 10);
		p.setGames(null);
		p.setUsername("ttesterson");
		p.setPassword("pass");
		
		playerHib.add(p);
		verify(playerHib).add(p);
	}
	
	@Test
	public void testGetAllGames()
	{
		when(gameHib.getAll()).thenReturn(gamesMock);
		gameHib.getAll();
		verify(gameHib).getAll();
		assertFalse(gameHib.getAll().isEmpty());
		assertFalse(gameImpl.getAllGames().isEmpty());
	}
	
	@Test
	public void testGetAllPlayers()
	{
		when(playerHib.getAll()).thenReturn(playersMock);
		playerHib.getAll();
		verify(playerHib).getAll();
		assertFalse(playerHib.getAll().isEmpty());
		assertFalse(playerImpl.getAllPlayers().isEmpty());
	}
	
	@Test
	public void testGetGameById()
	{
		int id = 1;
		when(gameHib.getById(id)).thenReturn(gameMock);
		gameHib.getById(id);
		verify(gameHib).getById(id);
		assertFalse(gameMock == null);
		assertFalse(gameImpl.getGameById(id) == null);
	}
	
	@Test
	public void testGetPlayerById()
	{
		int id = 1;
		when(playerHib.getById(id)).thenReturn(playerMock);
		playerHib.getById(id);
		verify(playerHib).getById(id);
		assertFalse(playerMock == null);
		assertFalse(playerImpl.getPlayerById(id) == null);
	}
	
	@Test
	public void testUpdateAGame()
	{
		Game g = new Game();
		gameHib.add(g);
		g.setId(12);
		gameHib.update(g);
		verify(gameHib).update(g);
		assertTrue(g.getId() == 12);
		g.setId(13);
		gameImpl.updateGame(g);
		assertTrue(g.getId() == 13);
	}
	
	@Test
	public void testEditAPlayer()
	{
		Player p = new Player();
		playerHib.add(p);
		p.setId(12);
		playerHib.update(p);
		verify(playerHib).update(p);
		assertTrue(p.getId() == 12);
		p.setId(13);
		playerHib.update(p);
		assertTrue(p.getId() == 13);
	}
	
	@Test
	public void testDeleteAGame()
	{	
		gameHib.delete(gameMock);
		verify(gameHib).delete(gameMock);
	}
	
	@Test
	public void testDeleteAPlayer()
	{
		playerHib.delete(playerMock);
		verify(playerHib).delete(playerMock);
	}
	
	@Test
	public void testGetPlayerByUsernameAndPassword()
	{
		String username = "ttesterson";
		String password = "pass";
		when(playerHib.getPlayerByUsernameAndPassword(username, password)).thenReturn(playerMock);
		playerHib.getPlayerByUsernameAndPassword(username, password);
		verify(playerHib).getPlayerByUsernameAndPassword(username, password);
		assertFalse(playerMock == null);
		assertFalse(playerImpl.getPlayerByUsernameAndPassword(username, password) == null);
	}
}
