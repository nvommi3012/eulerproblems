package problem_70;

import org.junit.Test;
import static org.junit.Assert.*;

public class Problem70Test {

	@Test
	public void testSolution()
	{
		Problem70 p;
		try {
			p = new Problem70();
			assertEquals(8319823, p.getSolution());
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	@Test
	public void testPermutationCheck()
	{
		Problem70 p;
		try {
			p = new Problem70();
			assertTrue(p.isPermutation(12345, 54321));
			assertTrue(p.isPermutation(11242, 21412));
			assertFalse(p.isPermutation(11111, 11111));
			assertFalse(p.isPermutation(11122, 11222));
			assertFalse(p.isPermutation(11128, 11222));
		} catch (Exception e) {
			fail(e.toString());
		}
	}
}
