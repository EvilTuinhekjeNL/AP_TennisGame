package tennisgame;

public class Game {
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
}
