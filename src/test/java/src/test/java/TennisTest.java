package src.test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TennisTest {

	private static final String RIGHT = "right";
	private static final String LEFT = "left";
	private List<Integer> expectedScore;
	private Scorer scorer;

	@Before
	public void setup() {
		expectedScore = new ArrayList<Integer>();
		scorer = new Scorer();
	}
	
	@Test
	public void rightPlayerScoresShouldBe0to15() {
		expectedScore.add(0);
		expectedScore.add(15);
		
		scorer.rightScores();
		
		scoreShouldEqualExpectedScore();
	}
	
	@Test
	public void leftPlayerScoresShouldBe15to0() {
		expectedScore.add(15);
		expectedScore.add(0);
		
		scorer.leftScores();
		
		scoreShouldEqualExpectedScore();
	}

	
	@Test
	public void leftPlayerScoresThreeTimesShouldBe40to0() {
		expectedScore.add(40);
		expectedScore.add(0);
		
		scoreTimes(LEFT, 3);
		
		scoreShouldEqualExpectedScore();
	}
	
	@Test
	public void rightPlayerScoresThreeTimesShouldBe0to40() {
		expectedScore.add(0);
		expectedScore.add(40);
		
		scoreTimes(RIGHT, 3);
		
		scoreShouldEqualExpectedScore();
	}
	
	@Test
	public void rightPlayerScoresFourTimesShouldBeGame() {
		expectedScore.add(0);
		expectedScore.add(0);
		
		scoreTimes(RIGHT, 4);
		
		scoreShouldEqualExpectedScore();
		assertEquals(1,scorer.gamesWon());
	}

	@Test
	public void leftPlayerScoresFourTimesShouldBeGame() {
		expectedScore.add(0);
		expectedScore.add(0);
		
		scoreTimes(LEFT, 4);
		
		scoreShouldEqualExpectedScore();
		assertEquals(1,scorer.gamesWonRight());
	}

	@Test
	public void playersTiedAt40WillRightPlayerDoesNotWinIfScores() {
		scoreTimes(LEFT, 4);
		scoreTimes(RIGHT, 5);
		
		assertEquals(0,scorer.gamesWonRight());
	}
	
	private void scoreTimes(String scorerSide, int timesScored) {
		for (int i = 0; i < timesScored; i++) {
			if (scorerSide.equals(LEFT))
				scorer.leftScores();
			else
				scorer.rightScores();
		}
	}
	
	private void scoreShouldEqualExpectedScore() {
		assertEquals(expectedScore, scorer.getScore());
	}
}
