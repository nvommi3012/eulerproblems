package problem_38;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem38Test {

	@Test
	public void testPalindromic()
	{
		Problem38 p = new Problem38();
		assertTrue(p.isPalindromic("123456789"));
		assertTrue(p.isPalindromic("342765981"));
		assertFalse(p.isPalindromic("342765921"));
	}
	
	@Test
	public void testSolution()
	{
		Problem38 p = new Problem38();
		assertEquals(932718654L, p.getSolution());
	}
}
