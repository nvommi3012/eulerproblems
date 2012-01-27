package problem_46;

import utils.IPrimes;
import utils.PrimesFactory;

/**
 * @author Wolfgang
 * @note What is the smallest odd composite that cannot be written as the sum of a prime and twice a square? (Goldbach Conjecture)
 */
public class Problem46 {

	/**
	 * @return the smallest number that cannot be written as a sum of a prime and twice a square
	 */
	public long getSolution()
	{
		// Goldbach Conjecture formula: c = prime + 2 * n^2

		// start with a small number of primes, the optimizer should add other primes when needed
		IPrimes primes = PrimesFactory.getSieve(100);
		// start with the number 35 -- see http://projecteuler.net/index.php?section=problems&id=46
		long i = 35;
		// start with the first prime though
		long prime = 0;

		// every uneven integer is a composite number
		for (; i < Integer.MAX_VALUE; i += 2)
		{
			// generate primes until primer is greater then the tested number itself
			for (prime = 0; prime < i;)
			{
				// get next prime number greater than previous prime
				try { prime = primes.generatePrime(prime); } catch (Exception e) {}
				long j = 1;
				long square = 1;
				// now start calculating squares
				do
				{
					square = j * j;
					++j;
				} while (prime + 2 * square < i);
				
				// check the goldbach forumula, if there is a number we can quit this test
				if (prime + 2 * square == i)
					break;
			}
			// if we did not find a prime (plus square) smaller than tested number this is our result
			if (prime > i)
				return i;
		}
		// we should never get here; ideally throw an exception
		return 0;
	}
	
}
