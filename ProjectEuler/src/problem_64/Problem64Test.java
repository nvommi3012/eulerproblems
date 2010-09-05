package problem_64;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem64Test {
	
	@Test
	public void testSolution()
	{
		try
		{
			assertEquals(1322, new Problem64().getSolution());
		}
		catch (Exception ex)
		{
			fail(ex.toString());
		}
	}
}