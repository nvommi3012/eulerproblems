package problem_62;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem62Test {
	@Test
	public void testSolution()
	{
		try
		{
			assertEquals(127035954683L, new Problem62().getSolution());
		}
		catch (Exception ex)
		{
			fail();
		}
	}
	@Test
	public void testHash()
	{
		try
		{
			assertEquals(195L, new Problem62().getPrimeHash(125));
			assertEquals(195L, new Problem62().getPrimeHash(512));
		}
		catch (Exception ex)
		{
			fail();
		}
	}
}
