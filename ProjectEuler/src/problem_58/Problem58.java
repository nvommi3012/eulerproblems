package problem_58;

import utils.IPrimes;
import utils.Primes;

/**
 * @author wolfgang
 * @note what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
 */
public class Problem58 {

	private IPrimes _primes;
	
	/**
	 * Ctor, init the prime checker 
	 */
	public Problem58()
	{
		_primes = new Primes();
	}

	/**
	 * @param lvlto level to calculate
	 * @return result set
	 * @note do not call this function for n > 1 since this function calculates every result from the beginning, call the overloaded function instead
	 */
	public int[] getPrimes(int lvlto)
	{
		return getPrimes(lvlto, null);
	}

	/**
	 * @param lvlto until what level to calculate
	 * @param params the returned array from the last call
	 * @return a result set (int[] containing count of tested numbers, primes, the next start point, the spiral level)
	 */
	public int[] getPrimes(int lvlto, int[] params)
	{
		// set default params 
		if (params == null)
			params = new int[] {1, 0, 1, 1};
		
		// the innermost level is always 1
		if (lvlto < 1)
			return new int[] {1, 0, 1, 1};

		// convert params array to int vars
		int count = params[0];
		int result = params[1];
		int start = params[2];
		int index = params[3];
		
		// this calculation starts at the 2nd level and
		// works itself through to the specified level
		for (; index < lvlto; ++index)
		{
			// get the for diagonal numbers and check for primeness
			for (int diag = 0; diag < 4; ++diag)
			{
				start += index * 2;
				++count;
				if (_primes.isPrime(start))
					++result;
			}
		}
		return new int[] {count, result, start, index};
	}
	
	/**
	 * @return the length of the spiral
	 * @throws Exception if no solution can be found
	 */
	public int getSolution() throws Exception
	{
		final double RATIO = 0.1;
		int n = 0;
		// call without array first, generates array for subsequent calls
		int[] a = getPrimes(n++);
		// now loop until we get a solution or end of Integer
		while (n < Integer.MAX_VALUE)
		{
			// get result set for this level
			a = this.getPrimes(n, a);
			// calculate ratio only if result set is valid
			if (a[0] > 0 && a[1] > 0)
			{
				double ratio = (double)a[1] / (double)a[0];
				// the side length is calculated directly from the level of the spiral
				if (ratio < RATIO)
					return (n-1) * 2 + 1;
			}
			++n;
		}
		throw new Exception("no solution found");
	}
}
