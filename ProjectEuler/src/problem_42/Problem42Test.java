package problem_42;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Problem42Test {
	@Test
	public void testFileRead()
	{
		try{
		Problem42 p = new Problem42("words.txt");
		assertEquals(1786, p.getWordCount());
		}
		catch (Exception e)
		{
			fail("Construction failed");
		}
	}
	
	@Test
	public void testTriangle()
	{
		Problem42 p = null;
		try {
			p = new Problem42("words.txt");
		} catch (Exception e) {
			fail();
		}
		assertEquals(55, p.getTriangleNumber(10));
		assertEquals(55, p.getTriangleNumber("sky"));
	}
	
	public void testSolution()
	{
		Problem42 p = null;
		try {
			p = new Problem42("words.txt");
		} catch (Exception e) {
			fail();
		}
		assertEquals(162, p.getSolution());
		
	}
	
}
