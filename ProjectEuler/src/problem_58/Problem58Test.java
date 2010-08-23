package problem_58;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Problem58Test {
	@Test
	public void testDiagonal()
	{
		Problem58 p = new Problem58();
		assertEquals(3, p.getPrimes(2)[1]);
		assertEquals(5, p.getPrimes(3)[1]);
		assertEquals(8, p.getPrimes(4)[1]);
	}

	@Test
	public void testSolution()
	{
		try{
		Problem58 p = new Problem58();
		assertEquals(26241, p.getSolution());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			fail();
		}
	}
}
