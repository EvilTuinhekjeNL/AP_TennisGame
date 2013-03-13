package TennisGame;

public class TennisGame {
	private int player1, player2;
	
	public void setUp(){
		player1 = 0;
		player2 = 0;
	}
	
	public int[] score(){
		return new int[]{ player1, player2 };
	}
}
