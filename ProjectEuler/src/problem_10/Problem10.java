package problem_10;

import utils.Primes;

// Find the sum of all the primes below two million
public class Problem10 {

	public long getPrimeSum(long max) {
		// init prime number generator
		Primes p = new Primes();
		long result = 0;
		long prime = 1;
		
		// get primes until conditions are met
		while(true)
		{
			// get one prime after the other, let the implementation take care of the specifics
			try { prime = p.generatePrime(prime); } catch (Exception e) {}
			// if we get a prime greater or equal to the specified maximum return with the result
			if (prime >= max)
				return result;
			// add the prime to the result sum
			result += prime;
		}
	}

}
