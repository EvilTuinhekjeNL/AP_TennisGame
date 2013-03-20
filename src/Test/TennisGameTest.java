package test;

import static org.junit.Assert.*;

import org.junit.*;

import tennisgame.Game;


public class TennisGameTest {
	Game game;
	
	@Before
	public void setup() throws Exception{
		game = new Game();
		game.setUp(3);
	}
	
	@Test
	public void testInitialSituation() throws Exception{
		assertTrue(evaluateScore(game.getPoints(), 0, 0));
	}
	
	@Test
	public void testPoints() throws Exception{
		game.score("sideA");
		game.score("sideA");
		game.score("sideB");
		assertTrue(evaluateScore(game.getPoints(), 30, 15));
	}
	
	@Test
	public void testGame() throws Exception {
		for (int i = 0; i < 4; i++) { // 0, 15 [0], 30 [1], 40 [2], 0 (match point) [3]
			game.score("sideA");
		}
		
		assertTrue(evaluateScore(game.getGames(), 1, 0));
	}
	
	@Test
	public void testAdvantage() throws Exception {
		for (int i = 0; i < 4; i++) {
			game.score("sideb");
			game.score("sidea");
		}
		
		// Player a should have the advantage
		assertTrue(evaluateScore(game.getGames(), 0, 0));
		
		game.score("sidea");
		// Player a should now have a match point
		assertTrue(evaluateScore(game.getGames(), 1, 0));
	}
	
	@Test
	public void testSet() throws Exception {
		for (int i = 0; i < 6; i++) {
			//game.score("sidea");
			incrementToGame("sidea");
		}
		
		assertTrue(evaluateScore(game.getSets(), 1, 0));
	}
	
	@Test
	public void testTieBreak() throws Exception {
		for (int i = 0; i < 6; i++) {
			incrementToGame("sidea");
			incrementToGame("sideb");
		}
		
		// At this point we have a tie break.
		assertTrue(evaluateScore(game.getSets(), 0, 0));
		
		incrementToGame("sidea");
		// This should win the set
		assertTrue(evaluateScore(game.getSets(), 1, 0));
	}
	
	@Test
	public void testWinA() throws Exception {
		for (int i = 0; i < (6*3); i++) {
			incrementToGame("sidea");
		}
		
		assertTrue(game.isWin());
		assertTrue(game.getWinner().toLowerCase().contains("a"));
	}
	
	@Test
	public void testWinB() throws Exception {
		for (int i = 0; i < (6*3); i++) {
			incrementToGame("sideb");
		}
		
		assertTrue(game.isWin());
		assertTrue(game.getWinner().toLowerCase().contains("b"));
	}
	
	@Test
	public void testWinNone() throws Exception {
		assertFalse(game.isWin());
		assertTrue(game.getWinner().toLowerCase().equals("none"));
	}
	
	@Test
	public void testScoreWrong() throws Exception {
		String exceptionMsg = "";
		try {
			game.score("sideC");
		} catch (Exception e) {
			exceptionMsg = e.getMessage().toLowerCase();
		}
		
		assertTrue(exceptionMsg.contains("side does not exist"));
	}
	
	public void incrementToGame(String side) throws Exception {
		for (int i = 0; i < 4; i++) {
			game.score(side);
		}
	}
	
	public boolean evaluateScore(int[] scores, int expectedSideA, int expectedSideB) throws Exception{
		return scores[0] == expectedSideA && scores[1] == expectedSideB;
	}
}
