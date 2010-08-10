package problem_47;

import utils.PrimeFactorList;

/**
 * @author Wolfgang
 * @note Find the first four consecutive integers to have four distinct primes factors. What is the first of these numbers?
 */
public class Problem47 {
	
	/**
	 * @return the first of 4 primes to have 4 distinct prime factors
	 * @throws Exception if no solution in int was found
	 */
	public int getSolution() throws Exception {
		
		// create a prime factor list with optimized primes
		PrimeFactorList pfl = new PrimeFactorList(1, 10000);
		
		// since there is no number consisting of 4 distinct prime factors lower than 2*3*5*7 we can start there
		for (int i = 2*3*5*7; i < Integer.MAX_VALUE; ++i)
		{
			// now factorize 4 consecutive numbers and see if there are 4 distinct prime factors
			pfl.refactorize(i);
			if (pfl.size() == 4)
			{
				pfl.refactorize(i+1);
				if (pfl.size() == 4)
				{
					pfl.refactorize(i+2);
					if (pfl.size() == 4)
					{
						pfl.refactorize(i+3);
						// if all 4 numbers have 4 factors that is the solution
						if (pfl.size() == 4)
							return i;
						// if the number doesn't match we can skip the next check also (for each of the checked numbers)
						++i;
					}
					++i;
				}
				++i;
			}
		}
		throw new Exception("No solution found");
	}
}
