package src.test.java;

import java.util.ArrayList;
import java.util.List;

public class Scorer {

	private List<Integer> score;
	private int rightScore;
	private int leftScore;
	private int gamesWonLeft;
	private int gamesWonRight;

	public Scorer() {
		score = new ArrayList<Integer>();
		rightScore = 0;
		leftScore = 0;
	}

	public List<Integer> getScore() {
		score.add(leftScore);
		score.add(rightScore);

		return score;
	}

	public void rightScores() {
		rightScore = calcScoreNumber(rightScore);
		if (rightScore == 0)
			gamesWonRight += 1;
	}

	private int calcScoreNumber(int score) {
			if (score == 40) {
				score = 0;
				gamesWonLeft += 1;
			}
			else if (score == 30)
				score += 10;
			else
				score += 15;
			
			return score;
	}

	public void leftScores() {
		leftScore = calcScoreNumber(leftScore);
		if (leftScore == 0)
			gamesWonRight += 1;
	}

	public int gamesWon() {
		return gamesWonLeft;
	}

	public int gamesWonRight() {
		return gamesWonRight;
	}

}
