package Test;

import TennisGame.TennisGame;
import junit.framework.TestCase;

public class TennisGameTest extends TestCase{
	public void testTennisGame() throws Exception{
		TennisGame game = new TennisGame();
		game.setUp();
		assertEquals(new int[]{0,0}, game.score());
	}
}
