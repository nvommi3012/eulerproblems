package problem_18;

import junit.framework.TestCase;

public class Problem18Test extends TestCase {

	public void testTriangle()
	{
		Problem18 p;
		try {
			p = new Problem18("problem.dat");
		} catch (Exception e) {
			fail();
			return;
		}
		assertEquals(23, p.getCell(14,14));
	}
	
	public void testRoute()
	{
		Problem18 p;
		try {
			p = new Problem18("problem.dat");
		} catch (Exception e) {
			fail();
			return;
		}
		assertEquals(1074, p.getMaximumRoute());
	}
}
