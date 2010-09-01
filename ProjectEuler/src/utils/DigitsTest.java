package utils;

import junit.framework.TestCase;

public class DigitsTest extends TestCase {
	public void testDigits()
	{
		int[] result;
		
		result = Digits.Number(1000L);
		assertTrue(result.length == 4);
		assertEquals(1, result[0]);

		result = Digits.Number(888L);
		assertTrue(result.length == 3);
		assertEquals(8, result[2]);
	}
	
	public void testArrays()
	{
		assertEquals(1234L, Digits.Array(new int[] {1,2,3,4}));
		assertEquals(1000L, Digits.Array(new int[] {1,0,0,0}));
	}
}
