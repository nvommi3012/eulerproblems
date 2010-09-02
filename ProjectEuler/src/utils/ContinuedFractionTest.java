package utils;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContinuedFractionTest {
	@Test
	public void testFraction()
	{
		ContinuedFraction f = new ContinuedFraction(new int[] {1, 2});
		assertEquals("41/29", f.getConvergent(4).toString());
		assertEquals("3/2", f.getConvergent(1).toString());
		assertEquals("1/1", f.getConvergent(0).toString());

		f = new ContinuedFraction(new int[] {2, 1,2,1, 1,4,1, 1,6,1, 1,8,1, 1,10,1});
		assertEquals("2/1", f.getConvergent(0).toString());
		assertEquals("3/1", f.getConvergent(1).toString());
		assertEquals("106/39", f.getConvergent(6).toString());
		assertEquals("1264/465", f.getConvergent(8).toString());
	}
}
