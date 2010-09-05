package problem_68;

import static org.junit.Assert.*;
import org.junit.Test;
import utils.SolutionNotFoundException;

public class Problem68Test {
	@Test
	public void testSolution()
	{
		try
		{
			assertEquals(6531031914842725L, new Problem68().getSolution());
		}
		catch (SolutionNotFoundException ex)
		{
			fail(ex.toString());
		}
	}
}
