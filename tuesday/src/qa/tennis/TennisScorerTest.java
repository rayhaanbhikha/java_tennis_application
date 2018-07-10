package qa.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisScorerTest {
    private TennisScorer ts;

    @Before
    public void setUp() {
        ts = new TennisScorer();
    }

    @Test
    public void testValidatorIsTrue()   {
        assertTrue(ts.validateInput("A"));
    }

    @Test
    public void testValidatorIsFalse()   {
        assertFalse(ts.validateInput("Q"));
    }

//    @Test
//    public void testScoreCalculator() {
//        char[] points = {'A', 'B', 'A', 'B', 'B', 'B'};
//
//        ts.calculateScore(points);
//
//        String playerA = ts.getScore().getPlayerAgameScore();
//
//        String playerB = ts.getScore().getPlayerBgameScore();
//
//        assertEquals("30:W", playerA + ":" + playerB);
//    }
    @Test
    public void testPlayerScoresUpTo15()    {
        ts.winningPoint('A');
        assertEquals("15:0", ts.currentScore());
    }

    @Test
    public void testPlayerScoresUpTo30()    {
        ts.winningPoint('A');
        ts.winningPoint('A');
        assertEquals("30:0", ts.currentScore());
    }

    @Test
    public void testPlayerScoresWhenDeuce()    {
        ts.winningPoint('A');
        ts.winningPoint('A');
        ts.winningPoint('A');
        ts.winningPoint('B');
        ts.winningPoint('B');
        ts.winningPoint('B');
        assertEquals("D:D", ts.currentScore());
    }

    @Test
    public void testPlayerScoresWhenDeuceGoesToAdvantage()    {
        ts.winningPoint('A');
        ts.winningPoint('A');
        ts.winningPoint('A');
        ts.winningPoint('B');
        ts.winningPoint('B');
        ts.winningPoint('B');
        ts.winningPoint('B');
        assertEquals("D:A", ts.currentScore());
    }

}