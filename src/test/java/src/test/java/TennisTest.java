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
		
		assertEquals(expectedScore, scorer.getScore());
	}
	
	@Test
	public void leftPlayerScoresShouldBe15to0() {
		expectedScore.add(15);
		expectedScore.add(0);
		
		scorer.leftScores();
		
		assertEquals(expectedScore, scorer.getScore());
	}
	
}
