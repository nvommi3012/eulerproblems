package problem_65;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem65Test {
	
	@Test
	public void testSolution()
	{
		try
		{
			assertEquals(272, new Problem65().getSolution());
		}
		catch (Exception ex)
		{
			fail(ex.toString());
		}
	}
}
