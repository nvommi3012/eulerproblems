package problem_43;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Problem43Test {
	
	@Test
	public void testSubnumbers()
	{
		Problem43 p = new Problem43();
		assertEquals(234, p.getSubnumbernth(new byte[] {1,2,3,4,5,6,7,8,9,0}, 0));
		assertEquals(890, p.getSubnumbernth(new byte[] {1,2,3,4,5,6,7,8,9,0}, 6));
	}

	@Test
	public void testMakenumbers()
	{
		Problem43 p = new Problem43();
		assertEquals(123, p.makenumber(new byte[] {1,2,3,4,5,6,7,8,9,0}, 0, 3));
		assertEquals(1234567890L, p.makenumber(new byte[] {1,2,3,4,5,6,7,8,9,0}, 0, 10));
	}

	@Test
	public void testPermutation()
	{
		Problem43 p = new Problem43();
		assertEquals(0, p.permutenth(new byte[] {1,2,3,4,5,6,7,8,9,0}, 3600000)[0]);
		assertEquals(1, p.permutenth(new byte[] {1,2,3,4,5,6,7,8,9,0}, 1)[0]);
	}
	
	@Test
	public void testSolution()
	{
		Problem43 p = new Problem43();
		assertEquals(16695334890L, p.getSolution());
	}
}
