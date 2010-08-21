package problem_55;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;

public class Problem55Test {
	@Test
	public void testPalimdrome()
	{
		Problem55 p = new Problem55();
		assertTrue(p.isPalindrome(BigInteger.valueOf(123454321)));
		assertFalse(p.isPalindrome(BigInteger.valueOf(1234564321)));
	}

	@Test
	public void testReversal()
	{
		Problem55 p = new Problem55();
		assertEquals(BigInteger.valueOf(1234567), p.reverseNumber(BigInteger.valueOf(7654321)));
		assertEquals(BigInteger.valueOf(999888777L), p.reverseNumber(BigInteger.valueOf(777888999L)));
	}

	@Test
	public void testSolution()
	{
		Problem55 p = new Problem55();
		assertEquals(249, p.getSolution());
	}
}
