package problem_54;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.IOException;
import org.junit.Test;
import problem_54.Problem54.Card;
import problem_54.Problem54.Hand;

public class Problem54Test {
	@Test
	public void testFile()
	{
		try {
			Problem54 p = new Problem54("pokertst.txt");
		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void testLiveFile()
	{
		try {
			Problem54 p = new Problem54("poker.txt");
		} catch (IOException e) {
			fail();
		}
	}
	
	@Test
	public void testCards()
	{
		
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Card c1 = p.new Card("8C");
			Card c2 = p.new Card("9C");
			Card c3 = p.new Card("9H");
			assertEquals(-1, c1.compareTo(c2));
			assertEquals(1, c2.compareTo(c1));
			assertTrue(c1.equals(c1));
			assertFalse(c1.equals(c2));
			assertTrue(c1.equalsColor(c2));
			assertFalse(c1.equalsColor(c3));
		} catch (IOException e) {}
	}

	@Test
	public void testRoyalFlush()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("AC JC QC KC TC", true);
			assertEquals(Consts.RoyalFlush, h1.getPlay());
			h1 = p.new Hand("AC KH QC JH TC", true);
			assertFalse(Consts.RoyalFlush == h1.getPlay());
		} catch (IOException e) {}
	}

	@Test
	public void testStraightFlush()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("KC QC JC TC 9C", true);
			assertEquals(Consts.StraightFlush, h1.getPlay());
			h1 = p.new Hand("6C 5C 4C 3C 2C", true);
			assertEquals(Consts.StraightFlush, h1.getPlay());
			h1 = p.new Hand("6C 5C 7C 3C 2C", true);
			assertFalse(Consts.StraightFlush == h1.getPlay());
		} catch (IOException e) {}
	}

	@Test
	public void testFours()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("KC KH KS KD 9D", true);
			assertEquals(Consts.Fours, h1.getPlay());
			h1 = p.new Hand("3H 3S 3C 3D 2H", true);
			assertEquals(Consts.Fours, h1.getPlay());
			h1 = p.new Hand("3H 3D 3C 2H 2C", true);
			assertFalse(Consts.Fours == h1.getPlay());
		} catch (IOException e) {}
	}

	@Test
	public void testFullHouse()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("KH KD KC TC TD", true);
			assertEquals(Consts.FullHouse, h1.getPlay());
			h1 = p.new Hand("6H 6C 6S 3S 3H", true);
			assertEquals(Consts.FullHouse, h1.getPlay());
			h1 = p.new Hand("6D 5D 4D 3C 2C", true);
			assertFalse(Consts.FullHouse == h1.getPlay());
		} catch (IOException e) {}
	}

	@Test
	public void testFlush()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("4H QH 2H TH AH", true);
			assertEquals(Consts.Flush, h1.getPlay());
			h1 = p.new Hand("6D 5D 7D 3D KD", true);
			assertEquals(Consts.Flush, h1.getPlay());
			h1 = p.new Hand("6H 5D 4D 3C 2C", true);
			assertFalse(Consts.Flush == h1.getPlay());
		} catch (IOException e) {}
	}

	@Test
	public void testStraight()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("KH QD JH TC 9C", true);
			assertEquals(Consts.Straight, h1.getPlay());
			h1 = p.new Hand("6H 5H 7S 3D 4H", true);
			assertEquals(Consts.Straight, h1.getPlay());
			h1 = p.new Hand("6H 5D 4D 3C AC", true);
			assertFalse(Consts.Straight == h1.getPlay());
		} catch (IOException e) {}
	}

	@Test
	public void testThrees()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("KH KD KS TH 9C", true);
			assertEquals(Consts.Threes, h1.getPlay());
			h1 = p.new Hand("6C 6D 7D 3D 6H", true);
			assertEquals(Consts.Threes, h1.getPlay());
			h1 = p.new Hand("6H 5D 4D 3C AC", true);
			assertFalse(Consts.Threes == h1.getPlay());
		} catch (IOException e) {}
	}

	@Test
	public void testTwoPairs()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("KH KD QS QH 9C", true);
			assertEquals(Consts.TwoPair, h1.getPlay());
			h1 = p.new Hand("6C 6D 7D 3D 7H", true);
			assertEquals(Consts.TwoPair, h1.getPlay());
			h1 = p.new Hand("6H 5D 4D 3C AC", true);
			assertFalse(Consts.TwoPair == h1.getPlay());
		} catch (IOException e) {}
	}

	@Test
	public void testPair()
	{
		Problem54 p;
		try {
			p = new Problem54("pokertst.txt");
			Hand h1 = p.new Hand("KH KD 3S 2H 9C", true);
			assertEquals(Consts.OnePair, h1.getPlay());
			h1 = p.new Hand("6C 6D 7D 3D 8H", true);
			assertEquals(Consts.OnePair, h1.getPlay());
			h1 = p.new Hand("6H 5D 4D 3C AC", true);
			assertFalse(Consts.OnePair == h1.getPlay());
		} catch (IOException e) {}
	}
	
	@Test
	public void testSolution()
	{
		Problem54 p;
		try {
			p = new Problem54("poker.txt");
			assertEquals(376, p.getSolution());
		} catch (IOException e) {}
	}
	
}
