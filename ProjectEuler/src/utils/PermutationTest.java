package utils;

import java.util.ArrayList;

import junit.framework.TestCase;

public class PermutationTest extends TestCase {

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
	
}
