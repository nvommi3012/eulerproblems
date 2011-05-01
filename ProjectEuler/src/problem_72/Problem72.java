package problem_72;

import utils.IPrimes;
import utils.Primes;

/**
 * @author Wolfgang
 * @note How many elements would be contained in the set of reduced proper fractions for d <= 1,000,000?
 */
public class Problem72 {

	final int MAX_ORDER = 1000000;
	final IPrimes _primes;
	long totient[] = new long[MAX_ORDER+1];

	/**
	 * @throws Exception
	 */
	public Problem72() throws Exception
	{
		try {
			_primes = new Primes(MAX_ORDER);
		}
		catch (Exception e)
		{
			throw new Exception("primes not available");
		}
	}
	
	/**
	 * @note http://mathworld.wolfram.com/TotientFunction.html
	 */
	void computeTotient()
	{
		int n = MAX_ORDER + 1;
		
		// init the totient array, these values are used for the "multiple of p" part
		for (int i = 1; i < n; i++)
			totient[i] = i;
		
		// For a prime p --> phi(p) = p - 1
		// take a general m divisible by p --> phi(m) = m - m / p
		// which is the same thing as phi(m) = m * (1 - 1 / p)
		// (that means any multiple of p can be directly derived from p)
		for (int i = 2; i < n; i++)
		{
			if (_primes.isPrime(i))
			{
				// phi(p) = p - 1 for all primes
				totient[i] = i - 1;
				// all multiples of a prime can be expressed directly too
				for (int j = 2 * i; j < n; j += i)
					totient[j] *= 1 - 1.0 / i;
			}
		}
    }

	
	/**
	 * @return the count of reduced fraction in a farey sequence of 10^6 order
	 */
	public long getSolution() {

		long result = 0;

		computeTotient();
		// http://en.wikipedia.org/wiki/Farey_sequence#Sequence_length
		// the length of any farey sequence is the sum of its Order totients,
		// so once the totients are known, it is easy to add them all up
		for (int m = 2; m <= MAX_ORDER; ++m)
			result += totient[m];
		
		return result;
	}
}
