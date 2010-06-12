package problem_34;

import junit.framework.TestCase;

public class Problem34Test extends TestCase {
	
	public void testFactorial()
	{
		Problem34 p = new Problem34();
		assertEquals(1, p.factorial(1));
		assertEquals(2, p.factorial(2));
		assertEquals(24, p.factorial(4));
		assertEquals(120, p.factorial(5));
		assertEquals(1*2*3*4*5*6, p.factorial(6));
		assertEquals(1*2*3*4*5*6*7, p.factorial(7));
		assertEquals(1*2*3*4*5*6*7*8, p.factorial(8));
		assertEquals(1*2*3*4*5*6*7*8*9, p.factorial(9));
		try {
			p.factorial(10);
			fail("Expected Exception at 10");
		}
		catch(Exception e) {}
	}
	
	public void testSolution()
	{
		Problem34 p = new Problem34();
		assertEquals(40730, p.getSolution());
	}
}
