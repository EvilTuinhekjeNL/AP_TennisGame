package TennisGame;

public class TennisGame {
	private int sideA, sideB;
	
	public void setUp(){
		sideA = 0;
		sideB = 0;
	}
	
	public int[] getScore(){
		return new int[]{ sideA, sideB };
	}

	public void score(String side) throws Exception {
		if(side.toLowerCase().equals("sidea")){
			sideA = incrementScore(sideA);
		} else if (side.toLowerCase().equals("sideb")) {
			sideB = incrementScore(sideB);
		} else {
			throw new Exception("Fuck yo couch!");
		}
	}
	
	private int incrementScore(int original) {
		int score = original;
		if (score < 30)
			score += 15;
		else if (score < 40)
			score += 10;
		else {
			setUp();
			score = 0;
			// TODO: Implement match points
			// TODO: Implement Deuce
			// TODO: Implement Match/Game
			// TODO: Score
		}
		
		return score;
	}
	
	
	
}
