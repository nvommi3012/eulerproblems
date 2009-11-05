package problem_17;

import junit.framework.TestCase;

public class Problem17Test extends TestCase {
	public void testConversion()
	{
		Problem17 p = new Problem17();
		assertEquals("three", p.getLiteral(3));
		assertEquals("ten", p.getLiteral(10));
		assertEquals("twelve", p.getLiteral(12));
		assertEquals("thirteen", p.getLiteral(13));
		assertEquals("fourteen", p.getLiteral(14));
		assertEquals("onehundredandtwenty", p.getLiteral(120));
		assertEquals("onethousand", p.getLiteral(1000));
		assertEquals("ninehundredandninetynine", p.getLiteral(999));
	}
	
	public void testCount()
	{
		Problem17 p = new Problem17();
		assertEquals(19, p.getLiteralCount(5));
		assertEquals(21124, p.getLiteralCount(1000));
	}
	
}
