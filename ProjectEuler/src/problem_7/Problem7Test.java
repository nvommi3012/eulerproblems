package problem_7;

import junit.framework.TestCase;

public class Problem7Test extends TestCase {

	public void testPrimes()
	{
		Problem7 p = new Problem7();
		assertEquals(13, p.getPrime(6));
		assertEquals(104743, p.getPrime(10001));
	}
}
