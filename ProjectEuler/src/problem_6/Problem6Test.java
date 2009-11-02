package problem_6;

import junit.framework.TestCase;

public class Problem6Test extends TestCase {

	public void testDifference()
	{
		Problem6 p = new Problem6();
		assertEquals(2640, p.getSquaresDifference(10));
		assertEquals(25164150, p.getSquaresDifference(100));
	}
}
