package problem_25;

import junit.framework.TestCase;

public class Problem25Test extends TestCase {

	public void testProblem25()
	{
		Problem25 p = new Problem25();
		assertEquals(4782, p.getFibonacciDigits(1000));
	}
	
}
