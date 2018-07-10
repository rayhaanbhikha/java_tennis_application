package qa.tennis;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {
    @Test
    public void testNewTennisScorerReturns0_0(){
        TennisScorer ts = new TennisScorer();
        assertEquals("0:0", ts.currentScore());
    }
}