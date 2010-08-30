package problem_61;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem61Test {
	@Test
	public void testSolution()
	{
		try
		{
			assertEquals(28684, new Problem61().getSolution());
		}
		catch(Exception ex)
		{
			fail();
		}
	}
}
