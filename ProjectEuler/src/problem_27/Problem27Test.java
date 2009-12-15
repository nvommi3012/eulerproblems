package problem_27;

import junit.framework.TestCase;

public class Problem27Test extends TestCase {

	public void testFormula()
	{
		Problem27 p = new Problem27();
		assertEquals(40, p.getPrimesCountForAB(1, 41));
		assertEquals(80, p.getPrimesCountForAB(-79, 1601));
	}
	
	public void testProblem27()
	{
		Problem27 p = new Problem27();
		assertEquals(-59231, p.getMaxProduct());
	}
	
}
