package problem_22;

import junit.framework.TestCase;

public class Problem22Test extends TestCase {
	
	public Problem22 p;
	
	public void setUp()
	{
		// just make one object to save a little time
		p = new Problem22("names.txt");
	}
	
	public void tearDown()
	{
		// --
	}
	
	public void testNameArray()
	{
		assertEquals(938, p.getNameIndex("COLIN"));
	}
	
	public void testNameScore()
	{
		assertEquals(53, p.getNameScore("COLIN"));
	}

	public void testNamesScore()
	{
		assertEquals(871198282, p.getNamesScore());
	}
	
}
