package problem_63;

import static org.junit.Assert.*;
import org.junit.Test;


public class Problem63Test {
	@Test
	public void testSolution()
	{
		try
		{
			assertEquals(49, new Problem63().getSolution());
		}
		catch (Exception ex)
		{
			fail();
		}
	}
}
