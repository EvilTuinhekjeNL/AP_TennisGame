package test;

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
		assert(evaluateScore(game, 0, 0));
	}
	
	@Test
	public void testTennisScore() throws Exception{
		//TennisGame game = setup();
		game.score("sideA");
		game.score("sideA");
		game.score("sideB");
		evaluateScore(game, 30, 15);
	}
	
	public void testMatchPoint() throws Exception {
		for (int i = 0; i < 4; i++) { // 0, 15 [0], 30 [1], 40 [2], 0 (match point) [3]
			game.score("sideA");
		}
		
		int[] matchPoints = game.getMatchPoints();
		//assertEquals(points[0], 1);
	}
	
	public boolean evaluateScore(Game game, int expectedSideA, int expectedSideB) throws Exception{
		int[] score = game.getScore();
		return score[0] == expectedSideA && score[1] == expectedSideB;
	}
}
