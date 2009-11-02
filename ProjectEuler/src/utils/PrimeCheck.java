package utils;

import java.util.TreeMap;

// helper class for checking primeness of numbers
public class PrimeCheck {
	// for more performance in repeated checks we remember all found primes (in a BST for quick searches)
	private TreeMap<Long, Long> _primes;

	public PrimeCheck()
	{
		_primes = new TreeMap<Long, Long>();
	}

	public boolean isPrime(long test) {
		// test for primeness. a prime is a number divisible only by 1 and itself
		// so we start with 2 until we reach the square root of the number
		// (for example 100 cant be divided by anything greater than 50, so we can stop there)
		

		// first check against already known primes
		if (_primes.containsKey(test))
		{
			return true;
		}
		
		long start = 2;
		// then check against factors of already known primes
		// so we can perhaps reduce the range we need to check
		if (_primes.size() > 0)
		{
			for(long factor: _primes.keySet())
			{
				if (test % factor == 0)
					return false;
			}
			start = _primes.lastKey();
		}
		long upper = Math.round(Math.sqrt(test)) + 1;
		for (long i = start; i < upper; ++i)
		{
			// if there is a number i which divides test with no rest then we can safely assume it is not a prime
			if (test % i == 0)
				return false;
		}
		
		_primes.put(test, test);
		return true;
	}
}
