package utils;

import junit.framework.TestCase;

public class FactorListTest extends TestCase {

	public void testFactorList1()
	{
		// 1 2 3 4 6
		FactorList list = new FactorList(12);
		assertEquals(5, list.size());
		assertEquals(6L, (long)list.get(4));
	}

	public void testFactorList2()
	{
		// 1 2 4 5 10
		FactorList list = new FactorList(20);
		assertEquals(5, list.size());
		assertEquals(10L, (long)list.get(4));
	}

	public void testFactorList3()
	{
		// 1 2 3 5 6 10 15
		FactorList list = new FactorList(30);
		assertEquals(7, list.size());
		assertEquals(6L, (long)list.get(4));
	}
	
}
