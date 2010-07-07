package problem_36;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem36Test {

	@Test
	public void testBinary()
	{
		Problem36 p = new Problem36();
		assertEquals("1001", p.toBinary(9));
		assertEquals("1111111", p.toBinary(127));
		assertEquals("11111101", p.toBinary(253));
		assertEquals("11111110", p.toBinary(254));
		assertEquals("11111111", p.toBinary(255));
		assertEquals("1111111111111111", p.toBinary(65535));
		assertEquals("1000", p.toBinary(8));
	}
	
	@Test
	public void testBase10()
	{
		Problem36 p = new Problem36();
		assertEquals("1001", p.toBase10(1001));
		assertEquals("1111111", p.toBase10(1111111));
	}
	
	@Test
	public void testPalindromic()
	{
		Problem36 p = new Problem36();
		assertTrue(p.isPalindromic("110011"));
		assertTrue(p.isPalindromic("1101011"));
		assertFalse(p.isPalindromic("11010110"));
	}

	@Test
	public void testResult()
	{
		Problem36 p = new Problem36();
		assertEquals(872187, p.getSolution());
	}
	
}
