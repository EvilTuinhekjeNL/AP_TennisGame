package tennisgame;

public class Side {
	private int points;
	private int games;
	private boolean advantage;
	private int sets;
	
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
			points = 0;
			incrementGames(opponent);
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
			incrementGames(opponent);
		}
	}
	
	private void incrementGames(Side opponent) {
		if (this.games < 5) {
			this.games += 1;
		} else if (this.games > opponent.getGames() && this.games >= 5) {
			this.games = 0;
			opponent.games = 0;
			incrementSets(opponent);
			// This is Tie-break logic. There are variants, but this is the way it usually works
		} else if (this.games > 5 && opponent.getGames() > 5) {
			this.games = 0;
			opponent.games = 0;
			incrementSets(opponent);
		} else if (this.games >= 5 && opponent.games >= 5) {
			this.games += 1;
		}
	}

	private void incrementSets(Side opponent) {
		this.sets += 1;
	}

	public int getGames() {
		return this.games;
	}
	
	public int getPoints() {
		return this.points;
	}

	public int getSets() {
		return this.sets;
	}
}
