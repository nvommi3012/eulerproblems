package problem_52;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Problem52Test {

	@Test
	public void testSameDigits()
	{
		Problem52 p = new Problem52();
		assertTrue(p.sameDigits(12345, 54321));
	}
	
	@Test
	public void testSolution()
	{
		try {
			Problem52 p = new Problem52();
			assertEquals(142857, p.getSolution());
		} catch (Exception e) {
			fail();
		}
	}
}
