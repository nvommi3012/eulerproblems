package problem_16;

import junit.framework.TestCase;

public class Problem16Test extends TestCase {
	public void testSquares()
	{
		Problem16 p = new Problem16();
		assertEquals(26, p.getDigitSum2Squared(15));
		assertEquals(1366, p.getDigitSum2Squared(1000));
	}
}
