package problem_26;

import junit.framework.TestCase;

public class Problem26Test extends TestCase {

	public void testLargestPattern()
	{
		Problem26 p = new Problem26();
		assertEquals(983, p.getLargestPattern(1000));
	}
	
}
