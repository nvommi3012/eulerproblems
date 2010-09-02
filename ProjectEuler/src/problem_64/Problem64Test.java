package problem_64;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem64Test {
	
	@Test
	public void testPeriods()
	{
		try
		{
			assertEquals("[3, 1, 1, 1, 1, 6]", new Problem64().getPeriod(13).toString());
			assertEquals("[2, 1, 1, 1, 4]", new Problem64().getPeriod(7).toString());
			assertEquals("[8, 1, 1, 5, 5, 1, 1, 16]", new Problem64().getPeriod(73).toString());
		}
		catch (Exception ex)
		{
			fail(ex.toString());
		}
	}
	
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