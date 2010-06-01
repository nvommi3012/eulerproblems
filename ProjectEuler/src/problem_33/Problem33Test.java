package problem_33;

import junit.framework.TestCase;

public class Problem33Test extends TestCase {

	public void test1()
	{
		Problem33 p = new Problem33();
		assertTrue(p.check(49,98));
		assertFalse(p.check(30,50));
	}
	
	public void test2()
	{
		Problem33 p = new Problem33();
		assertEquals(100, p.getSolution());
	}
	
}
