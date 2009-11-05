package problem_15;

import junit.framework.TestCase;

public class Problem15Test extends TestCase {
	public void testGridRoutes()
	{
		Problem15 p = new Problem15();
		assertEquals(6L, p.getRoutes(2));
		assertEquals(137846528820L, p.getRoutes(20));
	}
}
