package tennisgame;

public class Game {
	private Side sideA, sideB;
	
	public void setUp(){
		sideA = new Side();
		sideB = new Side();
	}
	
	public int[] getPoints(){
		return new int[]{ sideA.getPoints(), sideB.getPoints() };
	}
	
	public int[] getMatchPoints() {
		return new int[]{ sideA.getMatchPoints(), sideB.getMatchPoints() };
	}

	public void score(String side) throws Exception {
		if(side.toLowerCase().equals("sidea")){
			sideA.incrementScore(sideB);
		} else if (side.toLowerCase().equals("sideb")) {
			sideB.incrementScore(sideA);
		} else {
			throw new Exception("Fuck yo couch!");
		}
	}
}
