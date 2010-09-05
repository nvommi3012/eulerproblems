package problem_67;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem67Test {
	@Test
	public void testSolution()
	{
		try {
			assertEquals(7273, new Problem67().getSolution("triangle.txt"));
		} catch (Exception e) {
			fail(e.toString());
		}
	}
}
