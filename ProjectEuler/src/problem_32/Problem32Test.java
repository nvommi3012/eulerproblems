package problem_32;

import junit.framework.TestCase;

public class Problem32Test extends TestCase {

	public void testPanDigital()
	{
		Problem32 p = new Problem32();
		assertTrue(p.isPanDigital(4, 1738));
	}
	
	public void testProblem32()
	{
		Problem32 p = new Problem32();
		assertEquals(45228, p.getSum());
		
	}
}
