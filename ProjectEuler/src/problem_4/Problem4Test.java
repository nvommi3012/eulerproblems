package problem_4;

import junit.framework.TestCase;


public class Problem4Test extends TestCase {

	public void testPalindrom()
	{
		assertTrue(Problem4.isPalindrom(1111));
		assertTrue(Problem4.isPalindrom(12321));
		assertFalse(Problem4.isPalindrom(11112));
		assertTrue(Problem4.isPalindrom(989));
		assertTrue(Problem4.isPalindrom(9009));
		assertFalse(Problem4.isPalindrom(112311));
	}
	
	public void testLargestPalindrom()
	{
		int result = Problem4.getLargestPalindrom(1);
		assertTrue(result == 9);
		result = Problem4.getLargestPalindrom(2);
		assertTrue(result == 9009);
		result = Problem4.getLargestPalindrom(3);
		assertTrue(result == 906609);
	}
	
}
