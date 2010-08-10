package problem_48;

import java.math.BigInteger;

/**
 * @author Wolfgang
 * @note Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000
 */
public class Problem48 {

	/**
	 * @return the last ten digits of E(n)=n^n (n from 1 to 1000)
	 */
	public long getSolution() {
		// init the sum
		BigInteger sum = BigInteger.valueOf(0);
		// loop through all numbers from 1 to 1000
		for (int i = 1; i <= 1000; ++i)
		{
			// make n^n
			BigInteger n = BigInteger.valueOf(i);
			n = n.pow(i);
			// add n^n to the sum
			sum = sum.add(n);
		}
		// now get the last 10 digits
		BigInteger result = sum.mod(BigInteger.valueOf(10000000000L));
		// convert to long and return
		return result.longValue();
	}
}
