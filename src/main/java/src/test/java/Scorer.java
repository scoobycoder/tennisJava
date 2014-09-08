package src.test.java;

import java.util.ArrayList;
import java.util.List;

public class Scorer {

	private List<Integer> score;
	private int rightScore;
	private int leftScore;

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
		rightScore += 15;
	}

	public void leftScores() {
		leftScore += 15;
	}

}
