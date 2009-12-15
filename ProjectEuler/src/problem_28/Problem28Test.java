package problem_28;

import junit.framework.TestCase;

public class Problem28Test extends TestCase {

	public void testDiagonaleSum()
	{
		Problem28 p = new Problem28();
		assertEquals(1, p.getDiagonaleSum(1));
		assertEquals(25, p.getDiagonaleSum(3));
		assertEquals(101, p.getDiagonaleSum(5));
		
	}
	
	public void testProblem28()
	{
		Problem28 p = new Problem28();
		assertEquals(669171001, p.getDiagonaleSum(1001));
	}
	
}
