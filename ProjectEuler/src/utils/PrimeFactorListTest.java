package utils;

import junit.framework.TestCase;


public class PrimeFactorListTest extends TestCase {

	public void testFactorization()
	{
		// 20 = 2^2, 5^1
		PrimeFactorList l = new PrimeFactorList(20);
		assertEquals(2, l.size());
		assertEquals(2, l.getPower(2));
		assertEquals(1, l.getPower(5));
		assertEquals(0, l.getPower(3));
		// 30 = 2^1, 3^1 ,5^1
		PrimeFactorList n = new PrimeFactorList(30);
		assertEquals(3, n.size());
		assertEquals(1, n.getPower(2));
		assertEquals(1, n.getPower(5));
		assertEquals(1, n.getPower(3));
	}
	
	public void testListResults()
	{
		// 20 = 2^2, 5^1
		PrimeFactorList n1 = new PrimeFactorList(20);
		// 20 = 2, 3, 5
		PrimeFactorList n2 = new PrimeFactorList(30);

		PrimeFactorList result = PrimeFactorList.aggregateFactorLists(new PrimeFactorList[] {n1, n2});
		assertEquals(3, result.size());
		assertEquals(2, result.getPower(2));
		assertEquals(1, result.getPower(3));
		assertEquals(1, result.getPower(5));
		assertEquals(0, result.getPower(4));
	}
	
	public void testListCalc()
	{
		// 20 = 2^2, 5^1
		PrimeFactorList n1 = new PrimeFactorList(20);
		// 20 = 2, 3, 5
		PrimeFactorList n2 = new PrimeFactorList(30);

		PrimeFactorList result = PrimeFactorList.aggregateFactorLists(new PrimeFactorList[] {n1, n2});
		long kgv = result.calculateValue();
		assertEquals(60, kgv);
		
	}
	
}
