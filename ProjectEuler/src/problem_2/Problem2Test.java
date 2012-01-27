package problem_2;

import junit.framework.TestCase;


public class Problem2Test extends TestCase {

	public void testFibonacci()
	{
		Problem2 p = new Problem2();
		// 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 + 144 ...
		assertTrue(p.fibonacci(1) == 1);
		assertTrue(p.fibonacci(2) == 2);
		assertTrue(p.fibonacci(11) == 144); 
	}
	
	public void testFibonacciSums()
	{
		Problem2 p = new Problem2();
		int result = p.calculate(4000000);
		assertEquals(4613732, result);
	}
	
}
