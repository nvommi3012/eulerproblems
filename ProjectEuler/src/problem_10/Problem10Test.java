package problem_10;

import junit.framework.TestCase;

public class Problem10Test extends TestCase {

	public void testPrimeSum()
	{
		Problem10 p = new Problem10();
		assertEquals(17, p.getPrimeSum(10));
		assertEquals(142913828922L, p.getPrimeSum(2000000));
	}
	
}
