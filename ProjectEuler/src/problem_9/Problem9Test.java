package problem_9;

import junit.framework.TestCase;

public class Problem9Test extends TestCase {

	public void testPythagoras()
	{
		Problem9 p = new Problem9();
		long result = p.findProduct(1000);
		assertEquals(31875000L, result);
	}
	
}
