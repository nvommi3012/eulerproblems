package problem_60;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Problem60Test {

	@Test
	public void testSum()
	{
		assertEquals(15, new Problem60(0).sumOf(new long[]{1,2,3,4,5}));
	}

	@Test
	public void testConcatable()
	{
		assertTrue(new Problem60(1000).isConcatable(new long[]{3, 7, 109, 673}));
	}

	@Test
	public void testSolution()
	{
		try
		{
			assertEquals(26033, new Problem60().getSolution());
		}
		catch(Exception ex)
		{
			fail();
		}
	}
	
}
