package problem_29;

import junit.framework.TestCase;

public class Problem29Test extends TestCase {

	public void testGeneration()
	{
		Problem29 p = new Problem29();
		assertEquals(15, p.getDistinctCount(5));
	}
	
	public void testProblem29()
	{
		Problem29 p = new Problem29();
		assertEquals(9183, p.getDistinctCount(100));
	}
}
