package problem_59;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Problem59Test {

	@Test
	public void testFile()
	{
		Problem59 p = new Problem59("cipher.txt");
		assertEquals(79, p.get(0));
		assertEquals(59, p.get(1));
	}

	@Test
	public void testSolution()
	{
		try
		{
			Problem59 p = new Problem59("cipher.txt");
			assertEquals(107359, p.getSolution());
		}
		catch(Exception ex)
		{
			fail();
		}
	}
	
}
