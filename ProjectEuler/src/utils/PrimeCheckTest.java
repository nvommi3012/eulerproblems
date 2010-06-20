package utils;

import junit.framework.TestCase;

public class PrimeCheckTest extends TestCase {
	public void testPrime()
	{
		PrimeCheck p = new PrimeCheck();
		assertFalse(p.isPrime(15));
		assertFalse(p.isPrime(121));
		assertTrue(p.isPrime(2));
		assertTrue(p.isPrime(3));
		assertFalse(p.isPrime(4));
		assertTrue(p.isPrime(5));
		assertTrue(p.isPrime(13));
		assertTrue(p.isPrime(113));
		assertTrue(p.isPrime(971));
		assertFalse(p.isPrime(81));
	}
}
