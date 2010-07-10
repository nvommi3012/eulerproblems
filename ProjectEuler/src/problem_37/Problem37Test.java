package problem_37;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem37Test {

	@Test
	public void testPrimeness()
	{
		Problem37 p = new Problem37();
		assertTrue(p.hasPrimeness(23));
		assertFalse(p.hasPrimeness(29));
		assertTrue(p.hasPrimeness(3797));
	}
	
	@Test
	public void testSolution()
	{
		Problem37 p = new Problem37();
		assertEquals(748317, p.getSolution());
	}
}
