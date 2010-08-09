package problem_37;

import utils.Primes;

/**
 * @author Wolfgang
 * @note find the sum of 11 primes that when truncated from left or right still are primes (2,3,5,7 are not counted)
 */
public class Problem37 {

	private Primes _gen;
	
	/**
	 * Constructor, init the PrimeGenerator and Checker (with better optimization)
	 */
	public Problem37()
	{
		_gen = new Primes(1000000);
	}
	
	/**
	 * @return the sum of the 11 primes
	 */
	public int getSolution() {
		int result = 0;
		try
		{
		int prime = (int)_gen.generatePrime(0);
		int count = 0;

		// get primes until 11 match the criteria
		while (count < 11)
		{
			// get the next prime
			prime = (int)_gen.generatePrime(prime);
			// check criteria
			if (hasPrimeness(prime))
			{
				// add to result and increase counter
				result += prime;
				++count;
			}
		}
		}
		catch (Exception e) {}
		return result;
	}

	/**
	 * @param n the prime to check
	 * @return true if all subnumbers are prime
	 */
	private boolean p_l2r(int n)
	{
		// remove the last digits and check for primes
		while (n > 10)
		{
			n /= 10;
			if (false == _gen.isPrime(n))
				return false;
		}
		return true;
	}
	
	/**
	 * @param n prime to check
	 * @return true if all subnumbers are prime
	 */
	private boolean p_r2l(int n)
	{
		// count the digits of the prime 
		int log10 = (int)Math.floor(Math.log10(n));

		// remove the first digits and check for primes
		while (n > 10)
		{
			// get the 10^n number of the prime so we can calculate the modulo
			// this eliminates the most significant digit
			double pow = Math.pow(10, log10);
			n %= pow;
			// check if remainder is prime
			if (false == _gen.isPrime(n))
				return false;
			// remove one digit
			--log10;
		}
		return true;
	}
	
	/**
	 * @param n prime to check
	 * @return true if all criteria are met
	 */
	public boolean hasPrimeness(int n) {
		// sanity check, should only be primes anyway
		if (false == _gen.isPrime(n))
			return false;
		
		// Primes < 10 are not to be counted
		if (n < 10)
			return false;
	
		// check the number from left to right
		if (false == p_l2r(n))
			return false;
		
		// check the number from right to left
		if (false == p_r2l(n))
			return false;
		
		return true;
	}

}
