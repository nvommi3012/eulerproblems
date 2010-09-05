package utils;

import static org.junit.Assert.*;
import org.junit.Test;

public class SolutionNotFoundExceptionTest {
	@Test
	public void testException()
	{
		try
		{
			throw new SolutionNotFoundException(SolutionNotFoundExceptionTest.class);
		}
		catch(SolutionNotFoundException ex)
		{
			assertTrue(ex.toString().equals("SolutionNotFoundExceptionTest: No solution could be found"));
		}
		catch(Exception ex)
		{
			fail(ex.toString());
		}
	}
}
