package problem_35;

import java.util.ArrayList;
import junit.framework.TestCase;

public class Problem35Test extends TestCase {

	public void testRotation()
	{
		Problem35 p = new Problem35();
		ArrayList<int[]> result = p.rotate(new int[] {1,2,3,4,5});
		assertEquals(5, result.size());
		result = p.rotate(new int[] {2,3,4,5});
		assertEquals(4, result.size());
		result = p.rotate(new int[] {1,1,1,2,3,4,5});
		assertEquals(7, result.size());
	}
	
	public void testCircularity()
	{
		Problem35 p = new Problem35();
		assertTrue(p.isCircular(2));
		assertTrue(p.isCircular(3));
		assertTrue(p.isCircular(17));
		assertFalse(p.isCircular(917));
		assertFalse(p.isCircular(1777));
		assertFalse(p.isCircular(18));
		assertTrue(p.isCircular(193939));
		assertTrue(p.isCircular(199933));
		assertFalse(p.isCircular(197371));
	}
	
	public void testSolution()
	{
		Problem35 p = new Problem35();
		assertEquals(55, p.getSolution());
	}
	
}
