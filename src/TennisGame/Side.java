package tennisgame;

public class Side {
	private int points;
	private int games;
	// TODO: Needs sets
	
	public Side() {
		this.points = 0;
		this.games = 0;
	}
	
	public void incrementScore(Side opponent) {
		if (points < 30)
			points += 15;
		else if (points < 40)
			points += 10;
		else {
			points = 0;
			games += 1;
			// TODO: Implement match points
			// TODO: Implement Deuce
			// TODO: Implement Match/Game
			// TODO: Score
		}
	}

	public int getMatchPoints() {
		return this.games;
	}
	
	public int getPoints() {
		return this.points;
	}
}
