package problem_69;

import utils.PrimeFactorList;
import utils.SolutionNotFoundException;

/**
 * @author Wolfgang
 * @note Find the value of n <= 1000000 for which n/Phi(n) is a maximum.
 */
public class Problem69 {
	
	final int MAX_N = 1000000;
	final PrimeFactorList _pfl;

	/**
	 * Ctor, init the factorial object 
	 */
	public Problem69()
	{
		_pfl = new PrimeFactorList(1,100000);
	}
	
	/**
	 * @param n number to calculate N(phi(n))
	 * @return the count of coprimes of <n>
	 */
	double phicount(int n)
	{
		// the formula for coprimes of n is n*(1-1/P1)*(1-1/P2)*...*(1-1/Px) where Px are the prime factors of n
		// see http://en.wikipedia.org/wiki/Euler%27s_totient_function#Computing_example
		double result = n;
		_pfl.refactorize(n);
		
		for (Long e: _pfl.keySet())
			result *= (1 - 1/(double)e);
		return result;
	}

	public long calc()
	{
		// http://en.wikipedia.org/wiki/Euler%27s_totient_function
		// Wikipedia mentions that all minima of the totient function occur at multiples of 30,
		// so check only those
		
		double ratio = 0;
		int result = 0;
		double phi = 0;
		
		// get every phi count for all numbers <= MAX
		for (int i = 0; i <= MAX_N; i+=30)
		{
			phi = phicount(i);
		
			// calculate the ratio of n/phi(n)
			double r = 0;
			if (phi != 0)
				r = i / phi;
			else
				r = 0;

			// and find the maximum ratio (minimum phi)
			if (ratio < r)
			{
				ratio = r;
				result = i;
			}
		}
		return result;
	}
	
	/**
	 * @return the n where n/phi(n) is maximized 
	 * @throws SolutionNotFoundException if no solution could be found
	 */
	public long getSolution() throws SolutionNotFoundException
	{
		long result = calc();
		if (result == 0)
			throw new SolutionNotFoundException(Problem69.class);
		return result;
	}
}
