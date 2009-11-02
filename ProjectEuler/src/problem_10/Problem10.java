package problem_10;

import utils.PrimeGenerator;

// Find the sum of all the primes below two million
public class Problem10 {

	public long getPrimeSum(long max) {
		// init prime number generator
		PrimeGenerator p = new PrimeGenerator();
		long result = 0;
		long prime;
		
		// get primes until conditions are met
		while(true)
		{
			// get one prime after the other, let the implementation take care of the specifics
			prime = p.getNextPrime();
			// if we get a prime greater or equal to the specified maximum return with the result
			if (prime >= max)
				return result;
			// add the prime to the result sum
			result += prime;
		}
	}

}
