package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void testDistinct()
	{
		ArrayList<int[]> p = new ArrayList<int[]>();
		try
		{
		p.distinct();
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,6});
		p.add(new int[]{1,2,3,4,3});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,6});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,6});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,6});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,6});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,5});
		p.add(new int[]{1,2,3,4,3});
		p.add(new int[]{1,2,3,4,4});
		p.distinct();
		assertEquals(4, p.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
}
