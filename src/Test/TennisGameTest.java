package Test;

import org.junit.*;

import TennisGame.TennisGame;

public class TennisGameTest {
	TennisGame game;
	
	@Before
	public void setup() throws Exception{
		game = new TennisGame();
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
		
	}
	
	public boolean evaluateScore(TennisGame game, int expectedSideA, int expectedSideB) throws Exception{
		int[] score = game.getScore();
		return score[0] == expectedSideA && score[1] == expectedSideB;
	}
}
