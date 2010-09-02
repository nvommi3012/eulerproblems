package utils;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

public class FractionTest {
	@Test
	public void testCtor()
	{
		assertEquals("12/23", new Fraction(12,23).toString());
		assertEquals("12/23", new Fraction(12L,23L).toString());
		assertEquals("NaN", new Fraction(BigInteger.TEN, BigInteger.ZERO).toString());
	}
	
	@Test
	public void testAdd()
	{
		assertEquals("23/23", new Fraction(12,23).add(new Fraction(11,23)).toString());
		assertEquals("30/50", new Fraction(2,10).add(new Fraction(2,5)).toString());
	}

	@Test
	public void testMultiply()
	{
		assertEquals("1/4", new Fraction(1,2).multiply(new Fraction(1,2)).toString());
		assertEquals("4/50", new Fraction(2,10).multiply(new Fraction(2,5)).toString());
	}

	@Test
	public void testSubtract()
	{
		assertEquals("0/2", new Fraction(1,2).subtract(new Fraction(1,2)).toString());
		assertEquals("10/50", new Fraction(2,5).subtract(new Fraction(2,10)).toString());
	}

	@Test
	public void testDivide()
	{
		assertEquals("2/2", new Fraction(1,2).divide(new Fraction(1,2)).toString());
		assertEquals("10/20", new Fraction(2,10).divide(new Fraction(2,5)).toString());
	}
	
	@Test
	public void testReduce()
	{
		assertEquals("1/1", new Fraction(1,2).divide(new Fraction(1,2)).reduce().toString());
		assertEquals("1/2", new Fraction(2,10).divide(new Fraction(2,5)).reduce().toString());
		assertEquals("2/25", new Fraction(2,10).multiply(new Fraction(2,5)).reduce().toString());
	}

	@Test
	public void testInfinity()
	{
		assertEquals("NaN", new Fraction(1,0).toString());
	}

	@Test
	public void testEquality()
	{
		assertTrue(new Fraction(1,0).equals(new Fraction(10,0)));
		assertTrue(new Fraction(1,2).equals(new Fraction(2,4)));
		assertFalse(new Fraction(1,3).equals(new Fraction(2,3)));
	}
}
