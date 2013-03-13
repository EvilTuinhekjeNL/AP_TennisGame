package Test;

import TennisGame.TennisGame;
import junit.framework.TestCase;

public class TennisGameTest extends TestCase{
	public void testTennisGame() throws Exception{
		TennisGame game = new TennisGame();
		game.setUp();
		int[] score = game.score();
		for (int i = 0; i < score.length; i++) {
			assertEquals(score[i], 0);
		}
	}
}
