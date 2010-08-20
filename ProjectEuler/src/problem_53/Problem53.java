package problem_53;

import java.math.BigInteger;

/**
 * @author wolfgang
 * @note How many, not necessarily distinct, values of Cn,r, for 1 <= n <= 100, are greater than one-million?
 */
public class Problem53 {

	/**
	 * @param n number to factorialize
	 * @return n!
	 */
	public BigInteger f(int n)
	{
		// factorial starts with 1 per definition
		if (n <= 1)
			return BigInteger.ONE;
		// n! = n * (n - 1) ... (n - (n - 1))
		return BigInteger.valueOf(n).multiply(f(n-1));
	}
	
	/**
	 * @param n
	 * @param r
	 * @return C(n,r) = n! / (r! * (n-r)!); 
	 */
	public BigInteger C(int n, int r)
	{
		// per definition 1 <= r <= n <= 100
		if (n < r)
			throw new IllegalArgumentException("n < r");
		
		// split the formula into little steps
		BigInteger n1 = f(n);					// n!
		BigInteger n2_1 = f(r);					// r!
		BigInteger n2_2 = f(n-r);				// (n-r)!
		BigInteger n2 = n2_1.multiply(n2_2);	// r! * (n-r)!
		return n1.divide(n2);					// n! / r! * (n-r)!
	}
	
	/**
	 * @return the number of occurrences where C(n,r) > 1000000 for 1 <= r <= n <= 100
	 */
	public int getSolution()
	{
		// result count
		int count = 0;
		// for comparison
		final BigInteger MAX = BigInteger.valueOf(1000000L);
		
		// loop through all n
		for (int n = 1; n <= 100; ++n)
		{
			// nCr is max when n=2r
			// if that didn't reach the million mark check next n
			BigInteger result = C(n, n / 2);
			if (result.compareTo(MAX) < 0)
				continue;

			// since C(n,r) is a symmetric function it is enough
			// to calculate half the results and just increase the counter twice
			for (int r = 1; r <= n / 2; ++r)
			{
				// calculate C(n,r)
				result = C(n,r);
				// check if the result > 1000000
				if (result.compareTo(MAX) > 0)
					count+=2;
			}
			// but for all uneven results subtract one again
			if (n % 2 == 1)
				--count;
		}
		return count;
	}
}
