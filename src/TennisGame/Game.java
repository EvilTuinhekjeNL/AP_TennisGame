package tennisgame;

public class Game {
	private Side sideA, sideB;
	private int maxSets;
	
	public void setUp(int sets){
		sideA = new Side();
		sideB = new Side();
		
		this.maxSets = sets;
	}
	
	public int[] getPoints(){
		return new int[]{ sideA.getPoints(), sideB.getPoints() };
	}
	
	public int[] getMatches() {
		return new int[]{ sideA.getMatches(), sideB.getMatches() };
	}
	
	public int[] getSets() {
		return new int[]{sideA.getSets(), sideB.getSets()};
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
