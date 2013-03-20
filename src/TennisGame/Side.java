package tennisgame;

public class Side {
	private int points;
	private int games;
	private boolean advantage;
	// TODO: Needs sets
	
	public Side() {
		this.points = 0;
		this.games = 0;
		this.advantage = false;
	}
	
	public void incrementScore(Side opponent) {
		// Points 1 and 2
		if (points < 30)
			points += 15;
		// point 3
		else if (points < 40)
			points += 10;
		// else check if the 4th point puts us two ahead. If yes, score game
		else if (points-15 >= opponent.getPoints()) {
			games += 1;
			points = 0;
			// TODO: Implement match points
			// TODO: Implement Deuce
			// TODO: Implement Match/Game
			// TODO: Score
		// if no, we must be at a min 3, 4th point situation. The person in question gets the advantage,
			// take it from the other person if needs be.
		} else if (!this.advantage) {
			this.advantage = true;
			opponent.advantage = false;
		// Once that is resolved, the next point gives a game
		} else if (this.advantage) {
			this.advantage = false;
			opponent.advantage = false;
			points = 0;
			games += 1;
		}
	}

	public int getMatchPoints() {
		return this.games;
	}
	
	public int getPoints() {
		return this.points;
	}
}
