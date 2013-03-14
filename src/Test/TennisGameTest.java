package Test;

import junit.framework.TestCase;
import TennisGame.*;

public class TennisGameTest extends TestCase{
	public void testTennisGame() throws Exception{
		TennisGame game = setup();
		assert(evaluateScore(game, 0, 0));
	}
	
	public void testTennisScore() throws Exception{
		TennisGame game = setup();
		game.score("sideA");
		game.score("sideA");
		game.score("sideB");
		evaluateScore(game, 30, 15);
	}
	
	public TennisGame setup() throws Exception{
		TennisGame game = new TennisGame();
		game.setUp();
		return game;
	}
	
	public boolean evaluateScore(TennisGame game, int expectedSideA, int expectedSideB) throws Exception{
		int[] score = game.getScore();
		return score[0] == expectedSideA && score[1] == expectedSideB;
	}
}
