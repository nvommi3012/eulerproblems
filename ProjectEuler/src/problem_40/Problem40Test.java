package problem_40;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class Problem40Test {
	@Test
	public void testDigits()
	{
		//  x          x         x          x
		//0.123456789101112131415161718192021...
		Problem40 p = new Problem40();
		assertEquals(1, p.getDigit(1));
		assertEquals(1, p.getDigit(12));
		assertEquals(1, p.getDigit(22));
		assertEquals(1, p.getDigit(33));
	}
	
	@Test
	public void testSolution()
	{
		Problem40 p = new Problem40();
		assertEquals(210, p.getSolution());
	}
	
}
