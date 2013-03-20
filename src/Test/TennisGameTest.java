package test;

import static org.junit.Assert.*;

import org.junit.*;

import tennisgame.Game;


public class TennisGameTest {
	Game game;
	
	@Before
	public void setup() throws Exception{
		game = new Game();
		game.setUp();
	}
	
	@Test
	public void testTennisGame() throws Exception{
		//TennisGame game = setup();
		assertTrue(evaluateScore(game.getPoints(), 0, 0));
	}
	
	@Test
	public void testTennisScore() throws Exception{
		//TennisGame game = setup();
		game.score("sideA");
		game.score("sideA");
		game.score("sideB");
		assertTrue(evaluateScore(game.getPoints(), 30, 15));
	}
	
	@Test
	public void testMatchPoint() throws Exception {
		for (int i = 0; i < 4; i++) { // 0, 15 [0], 30 [1], 40 [2], 0 (match point) [3]
			game.score("sideA");
		}
		
		assertTrue(evaluateScore(game.getMatchPoints(), 1, 0));
	}
	
	@Test
	public void testAdvantage() throws Exception {
		for (int i = 0; i < 4; i++) {
			game.score("sideb");
			game.score("sidea");
		}
		
		// Player a should have the advantage
		assertTrue(evaluateScore(game.getMatchPoints(), 0, 0));
		
		game.score("sidea");
		// Player a should now have a match point
		assertTrue(evaluateScore(game.getMatchPoints(), 1, 0));
	}
	
	public boolean evaluateScore(int[] scores, int expectedSideA, int expectedSideB) throws Exception{
		return scores[0] == expectedSideA && scores[1] == expectedSideB;
	}
}
