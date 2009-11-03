package problem_12;

import junit.framework.TestCase;

public class Problem12Test extends TestCase {

	public void testTriangleNumber()
	{
		Problem12 p = new Problem12();
		assertEquals(1, p.getTriangleNumber(1));
		assertEquals(15, p.getTriangleNumber(5));
		assertEquals(28, p.getTriangleNumber(7));
		assertEquals(50005000, p.getTriangleNumber(10000));
	}
	
	public void testDivisors()
	{
		Problem12 p = new Problem12();
		assertEquals(0, p.getDivisors(0));
		assertEquals(1, p.getDivisors(1));
		assertEquals(2, p.getDivisors(3));
		assertEquals(4, p.getDivisors(21));
		assertEquals(6, p.getDivisors(28));
		assertEquals(48, p.getDivisors(2520));
		assertEquals(72, p.getDivisors(10080));
	}
	
	public void testDivisorCount()
	{
		Problem12 p = new Problem12();
		assertEquals(76576500, p.getTriangleNumberByDivisor(500));
	}
	
}
