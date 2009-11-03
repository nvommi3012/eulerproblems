package utils;

import junit.framework.TestCase;

public class BigIntTest extends TestCase {

	public void testAddition()
	{
		BigInt i1 = new BigInt("1111");
		BigInt i2 = new BigInt("2222");
		
		BigInt result = i1.add(i2);
		assertEquals(result, "3333");
		
		result = i1.add(new BigInt("1"));
		assertEquals(result, "1112");

		result = i1.add(new BigInt("9"));
		assertEquals(result, "1120");

		result = i1.add(new BigInt("9999"));
		assertEquals(result, "11110");
		
		result = new BigInt("9999").add(new BigInt("9999"));
		assertEquals(result, "19998");

		result = new BigInt("5555").add(new BigInt("5554"));
		assertEquals(result, "11109");

		result = new BigInt("1111111111111111111111111111111111111111").add(new BigInt("1111111111111111111111111111111111111111"));
		assertEquals(result, "2222222222222222222222222222222222222222");
	}
	
}
