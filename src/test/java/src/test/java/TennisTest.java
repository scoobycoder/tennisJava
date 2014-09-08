package src.test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TennisTest {

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
		
		scoreTimes("left", 3);
		
		scoreShouldEqualExpectedScore();
	}
	
	@Test
	public void rightPlayerScoresThreeTimesShouldBe0to40() {
		expectedScore.add(0);
		expectedScore.add(40);
		
		scoreTimes("right", 3);
		
		scoreShouldEqualExpectedScore();
	}

	private void scoreTimes(String scorerSide, int timesScored) {
		for (int i = 0; i < timesScored; i++) {
			if (scorerSide.equals("left"))
				scorer.leftScores();
			else
				scorer.rightScores();
		}
	}
	
	private void scoreShouldEqualExpectedScore() {
		assertEquals(expectedScore, scorer.getScore());
	}
}
