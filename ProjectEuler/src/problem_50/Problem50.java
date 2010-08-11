package problem_50;

import utils.Primes;

/**
 * @author wolfgang
 * @note Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Problem50 {

	// define the Million to switch easily when testing
	final long MAX = 1000000;
	
	/**
	 * @return the prime with the highest consecutive count
	 */
	public long getSolution()
	{
		// generate all primes up to max
		Primes p = new Primes(MAX);
		int max =0;
		int count = 0;
		int add = 0;
		int result = 0;
		
		// loop through the starting points
		for (int j = 0; j < MAX; ++j)
		{
			// start point must be prime
			if (false == p.isPrime(j))
				continue;
			// init the counters
			add = 0;
			count = 0;
			// loop through all primes from start to MAX
			for (int i = j; i < MAX; ++i)
			{
				// ignore if not prime
				if (false == p.isPrime(i))
					continue;
				// check if MAX is already exceeded
				if ((add + i) > MAX)
				{
					// if we are still below MAX check if the number is prime and we used more primes than before
					if (p.isPrime(add) && count > max)
					{
						// remember count and number
						max = count;
						result = add;
					}
					break;
				}
				// add prime and increase counter
				add += i;
				++count;
			}
		}
		return result;
	}
}
