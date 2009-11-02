package problem_1;

import junit.framework.TestCase;


public class Problem1Test extends TestCase {

	public void testMultiplier()
	{
		Problem1 p = new Problem1();
		p.addMultiplier(3);
		assertTrue(p.countMultiplier() == 1);
		p.addMultiplier(5);
		assertTrue(p.countMultiplier() == 2);
		p.addMultiplier(5);
		assertTrue(p.countMultiplier() == 2);
	}
	
	public void testAddition()
	{
		Problem1 p = new Problem1();
		p.addMultiplier(3);
		p.addMultiplier(5);
		// 3 + 5 + 6 + 9 = 23
		assertTrue(p.sumOf(10) == 23);
		// 23 + 10 + 12 + 15 + 18 = 78
		assertTrue(p.sumOf(20) == 78);
	}
	
	public void test1000()
	{
		Problem1 p = new Problem1();
		p.addMultiplier(3);
		p.addMultiplier(5);
		int result = p.sumOf(1000);
		assertTrue(result == 233168);
	}
}
