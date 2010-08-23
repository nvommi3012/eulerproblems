package problem_57;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Problem57Test {
	@Test
	public void testSquareRoot()
	{
		Problem57 p = new Problem57();
		assertEquals(3, p.getSquareRoot(0)[0].intValue());
		assertEquals(2, p.getSquareRoot(0)[1].intValue());

		assertEquals(7, p.getSquareRoot(1)[0].intValue());
		assertEquals(5, p.getSquareRoot(1)[1].intValue());

		assertEquals(17, p.getSquareRoot(2)[0].intValue());
		assertEquals(12, p.getSquareRoot(2)[1].intValue());

		assertEquals(1393, p.getSquareRoot(7)[0].intValue());
		assertEquals(985, p.getSquareRoot(7)[1].intValue());
	}
	
	@Test
	public void testSolution()
	{
		Problem57 p = new Problem57();
		assertEquals(153, p.getSolution());
	}
}
