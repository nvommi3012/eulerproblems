package problem_13;

import junit.framework.TestCase;

public class Problem13Test extends TestCase {
	public void test10Digits()
	{
		Problem13 p = new Problem13();
		assertEquals(5537376230L, p.getResultNumber());
	}
}
