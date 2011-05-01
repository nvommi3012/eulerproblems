package problem_72;

import static org.junit.Assert.*;
import org.junit.Test;

public class Problem72Test {
	@Test
	public void testSolution()
	{
		try {
			Problem72 p = new Problem72();
			assertEquals(303963552391L, p.getSolution());
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
}
