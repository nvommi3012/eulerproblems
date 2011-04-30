package utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PrimesAtkinsTest {
	
	@Test
	public void testPrime()
	{
		try
		{
			PrimesAtkins p = new PrimesAtkins(100);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testIsPrime()
	{
		try {
		PrimesAtkins p = new PrimesAtkins(10000000);
		assertFalse(p.isPrime(15));
		assertFalse(p.isPrime(121));
		assertTrue(p.isPrime(2));
		assertTrue(p.isPrime(3));
		assertFalse(p.isPrime(4));
		assertTrue(p.isPrime(5));
		assertTrue(p.isPrime(13));
		assertTrue(p.isPrime(113));
		assertTrue(p.isPrime(179));
		assertFalse(p.isPrime(81));
		assertFalse(p.isPrime(371197));
		assertTrue(p.isPrime(193939));
		assertTrue(p.isPrime(4193939));
		}
		catch (Exception e)
		{
			fail();
		}
	}
}
