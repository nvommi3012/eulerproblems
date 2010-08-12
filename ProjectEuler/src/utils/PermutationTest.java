package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import utils.ArrayList;
import org.junit.Test;

public class PermutationTest{

	@Test
	public void testPermutation()
	{
		Permutation p = new Permutation();
		ArrayList<int[]> result = p.permutate(1234);
		assertEquals(24, result.size());
		result = p.permutate(123);
		assertEquals(6, result.size());
		result = p.permutate(12);
		assertEquals(2, result.size());
		assertEquals(result.get(0)[0], 2);
		assertEquals(result.get(0)[1], 1);
		assertEquals(result.get(1)[0], 1);
		assertEquals(result.get(1)[1], 2);
	}

	@Test
	public void testPermute()
	{
		assertEquals(0, Permutation.permutenth(new byte[] {1,2,3,4,5,6,7,8,9,0}, 3600000)[0]);
		assertEquals(1, Permutation.permutenth(new byte[] {1,2,3,4,5,6,7,8,9,0}, 1)[0]);
	}

	@Test
	public void testDistinct()
	{
		Permutation p = new Permutation();
		ArrayList<int[]> result = p.permutate(120000);
		try {
			result.distinct();
			assertEquals(30, result.size());
		} catch (Exception e) {
			fail();
		}
	}

}
