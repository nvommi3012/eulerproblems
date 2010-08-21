package problem_56;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Problem56Test {
	@Test
	public void testSum()
	{
		Problem56 p = new Problem56();
		assertEquals(24, p.getDigitSum("334455"));
	}

	@Test
	public void testSolution()
	{
		Problem56 p = new Problem56();
		assertEquals(972, p.getSolution());
	}
}
