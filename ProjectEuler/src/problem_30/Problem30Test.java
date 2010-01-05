package problem_30;

import junit.framework.TestCase;

public class Problem30Test extends TestCase {

	public void testChecker()
	{
		Problem30 p = new Problem30();
		assertTrue(p.isSumOfPower(1634, 4));
		assertFalse(p.isSumOfPower(1364, 4));
	}

	public void testProblem30()
	{
		Problem30 p = new Problem30();
		// 354294 is the upper limit of what the sum can possibly be (see function notes)
		assertEquals(443839, p.getAllSumOfPower(2, 354294, 5));
	}
	
	
	
}
