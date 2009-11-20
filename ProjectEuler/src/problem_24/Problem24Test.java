package problem_24;

import junit.framework.TestCase;

public class Problem24Test extends TestCase {

	public void testPermutation()
	{
		Problem24 p = new Problem24();
		assertEquals(123456789L, p.getPermutation(1));
		assertEquals(123456798L, p.getPermutation(2));
		assertEquals(123456879L, p.getPermutation(3));
		assertEquals(123456897L, p.getPermutation(4));
	}
	public void testMillionth()
	{
		Problem24 p = new Problem24();
		assertEquals(2783915460L, p.getPermutation(1000000));
	}
}
