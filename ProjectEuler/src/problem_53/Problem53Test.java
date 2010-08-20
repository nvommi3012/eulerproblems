package problem_53;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Test;

public class Problem53Test {
	@Test 
	public void testFac()
	{
		Problem53 p = new Problem53();
		assertEquals(BigInteger.valueOf(6), p.f(3));
		assertEquals(BigInteger.valueOf(362880), p.f(9));
	}
	
	@Test
	public void testCnr()
	{
		Problem53 p = new Problem53();
		assertEquals(BigInteger.valueOf(10), p.C(5,3));
		assertEquals(BigInteger.valueOf(1144066), p.C(23,10));
	}
	
	@Test
	public void testSolution()
	{
		Problem53 p = new Problem53();
		assertEquals(4075, p.getSolution());
	}
}
