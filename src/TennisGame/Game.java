package tennisgame;

public class Game {
	private Side sideA, sideB;
	private int maxSets;
	
	public void setUp(int sets){
		sideA = new Side();
		sideB = new Side();
		
		this.maxSets = sets;
	}
	
	public boolean isWin() {
		return (this.sideA.getSets() >= this.maxSets) || (this.sideB.getSets() >= this.maxSets);
	}
	
	public String getWinner() {
		if (this.sideA.getSets() >= this.maxSets) {
			return "Side A";
		} else if (this.sideB.getSets() >= this.maxSets) {
			return "Side B";
		} else {
			return "None";
		}
	}
	
	public int[] getPoints(){
		return new int[]{ sideA.getPoints(), sideB.getPoints() };
	}
	
	public int[] getGames() {
		return new int[]{ sideA.getGames(), sideB.getGames() };
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
