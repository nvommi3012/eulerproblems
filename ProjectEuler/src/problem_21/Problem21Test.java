package problem_21;

import junit.framework.TestCase;

public class Problem21Test extends TestCase{

	public void testDivisors()
	{
		Problem21 p = new Problem21();
		assertEquals(284, p.getDivisorSum(220));
		assertEquals(220, p.getDivisorSum(284));
	}
	
	public void testAmicableSum()
	{
		Problem21 p = new Problem21();
		assertEquals(31626, p.getAmicableNumberSum(10000));
	}
	
}
