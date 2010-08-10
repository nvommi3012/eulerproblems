package problem_47;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class Problem47Test {
	@Test
	public void testSolution()
	{
		try
		{
			Problem47 p = new Problem47();
			assertEquals(134043, p.getSolution());
		}
		catch (Exception e)
		{
			fail();
		}
	}
}
