package problem_14;

import junit.framework.TestCase;

public class Problem14Test extends TestCase {

	public void testChain()
	{
		Problem14 p = new Problem14();
		assertEquals(10, p.generateCollatzChain(13));
		assertEquals(14, p.generateCollatzChain(192));
	}
	
	public void testLongestChain()
	{
		Problem14 p  = new Problem14();
		assertEquals(837799, p.generateLongestChain());
	}
	
}
