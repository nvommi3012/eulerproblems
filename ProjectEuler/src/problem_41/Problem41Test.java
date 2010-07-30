package problem_41;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Problem41Test {

	@Test
	public void testPalindromic()
	{
		Problem41 p = new Problem41();
		assertFalse(p.is_n_Palindromic(1023));
		assertFalse(p.is_n_Palindromic(1623));
		assertTrue(p.is_n_Palindromic(1234));
		assertTrue(p.is_n_Palindromic(12345));
		assertTrue(p.is_n_Palindromic(1234567));
		assertTrue(p.is_n_Palindromic(12345678));
	}
	
	@Test
	public void testSolution()
	{
		Problem41 p = new Problem41();
		assertEquals(7652413L, p.getSolution());
	}
	
}
