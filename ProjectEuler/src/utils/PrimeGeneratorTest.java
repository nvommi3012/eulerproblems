package utils;

import junit.framework.TestCase;

public class PrimeGeneratorTest extends TestCase {
	
	public void testGenerator()
	{
		PrimeGenerator p = new PrimeGenerator();
		assertEquals(7L, p.getPrime(4));
		assertEquals(13L, p.getPrime(6));
	}
}
