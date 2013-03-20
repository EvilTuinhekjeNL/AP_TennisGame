package tennisgame;

public class Side {
	private int points;
	private int matches;
	private boolean advantage;
	private int sets;
	
	public Side() {
		this.points = 0;
		this.matches = 0;
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
			points = 0;
			incrementMatches(opponent);
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
			incrementMatches(opponent);
		}
	}
	
	private void incrementMatches(Side opponent) {
		if (this.matches < 5) {
			this.matches += 1;
		} else if (this.matches > opponent.getMatches() && this.matches >= 5) {
			this.matches = 0;
			incrementSets(opponent);
		}
		// TODO: Sets
	}

	private void incrementSets(Side opponent) {
		this.sets += 1;
	}

	public int getMatches() {
		return this.matches;
	}
	
	public int getPoints() {
		return this.points;
	}

	public int getSets() {
		return this.sets;
	}
}
