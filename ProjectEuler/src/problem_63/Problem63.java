package problem_63;

import java.math.BigInteger;

/**
 * @author wolfgang
 * @note How many n-digit positive integers exist which are also an nth power?
 */
public class Problem63 {

	/**
	 * @return the number of n-digit integers that are an n-th power
	 */
	public int getSolution() {
		int result = 0;
		// Reasoning:
		// 10² == 100 == 3 digits; 10³ == 1000 == 4 digits ...
		// pow(x, n) => x must be smaller than 10 and greater than 0 => is there a limit for n?
		// the limit for n is when log10(pow(x,n)) < n
		
		// as seen above x can never be 10 (or above) because any power of 10 has more digits than the value of its exponent
		for (int x = 1; x < 10; ++x)
		{
			BigInteger base = BigInteger.valueOf(x);
			// iterate through all possible exponents
			for (int n = 1;; ++n)
			{
				// calculate the number x^n
				BigInteger big = base.pow(n);
			
				// since BigInteger has a nice toString function use that instead of log10
				// check if the length of x^n is exactly n
				if (big.toString().length() == n)
					++result;
				// 10^n is growing at a constant rate of one digits for every increase of n
				// every base number less than 10 is growing slower than that (and every one larger is growing faster)
				// so just check when log10(x^n) is less than n and since log10 grows slower than n this
				// it is impossible that there are still exponents for x that would meet the requirements
				if (big.toString().length() < n)
					break;
			}
		}
		return result;
	}
}
