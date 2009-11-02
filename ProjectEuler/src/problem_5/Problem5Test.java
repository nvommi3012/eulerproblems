package problem_5;

import junit.framework.TestCase;

public class Problem5Test extends TestCase {

	public void testDivider()
	{
		assertTrue(Problem5.getSmallestDivider(10) == 2520);
		assertTrue(Problem5.getSmallestDivider(20) == 232792560);
	}
}
