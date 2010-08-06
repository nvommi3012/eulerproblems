package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class PrimesTest {
	@Test
	public void testPrime()
	{
		Primes p = new Primes();
		try
		{
		assertEquals(2L, p.generatePrime(0L));
		assertEquals(2L, p.generatePrime(1L));
		assertEquals(3L, p.generatePrime(2L));
		assertEquals(13L, p.generatePrime(11L));
		assertEquals(193939L, p.generatePrime(193938L));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testOptimize()
	{
		Primes p = new Primes(4000000L);
		try
		{
			assertEquals(997L, p.generatePrime(996L));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
}
