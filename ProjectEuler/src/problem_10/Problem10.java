package problem_10;

import utils.PrimeGenerator;

// Find the sum of all the primes below two million
public class Problem10 {

	public long getPrimeSum(long max) {
		PrimeGenerator p = new PrimeGenerator();
		long result = 0;
		long prime;
		
		while(true)
		{
			prime = p.getNextPrime();
			if (prime >= max)
				return result;
			result += prime;
		}
	}

}
