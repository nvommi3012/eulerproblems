package problem_70;

import java.util.ArrayList;
import utils.IPrimes;
import utils.Primes;

/**
 * @author Wolfgang
 * @note Find the value of n, 1 < n < 10^7, for which phi(n) is a permutation of n and the ratio n/phi(n) produces a minimum.
 */
public class Problem70 {

	// MAX_N is 10^7 which is the specified maximum
	final int MAX_N = 10000000;
	final int MAX_PRIME = (int)(Math.sqrt(MAX_N) * 2);
	IPrimes _primes;

	public Problem70() throws Exception
	{
		// generate all primes up to the maximum
		_primes = new Primes(MAX_PRIME);
	}

	/**
	 * @param p1 prime number
	 * @param p2 prime number
	 * @return the totient (phi) of p1*p2;
	 * @note p1 must not be equal to p2
	 */
	double phicount(long p1, long p2)
	{
		// the formula for coprimes of n is n*(1-1/P1)*(1-1/P2)*...*(1-1/Px) where Px are the prime factors of n
		// but if 2 non-equal primes are used the totient is calculated just by (p1-1) * (p2-1) 
		// see http://en.wikipedia.org/wiki/Euler%27s_totient_function#Computing_example
		if (p1 == p2)
			return 0;
		
		return (p1 - 1)*(p2 - 1);
	}

	/**
	 * @param phi any number
	 * @param n any number
	 * @return true if phi is a permutation of n (all digits of phi are in n and vice versa) 
	 */
	public boolean isPermutation(long phi, long n)
	{
		if (phi == n)
			return false;

		// generate a list of all digits in phi
		ArrayList<Integer> alphi = new ArrayList<Integer>();
		while (phi > 0)
		{
			alphi.add((Integer)(int)(phi % 10));
			phi /= 10;
		}
		
		// compare that list to all the digits in n
		while (n > 0)
		{
			int digit = (int)n % 10;
			
			// if a digit matches remove it from the list, it must not be matched twice
			if (alphi.contains(digit))
				alphi.remove(alphi.indexOf(digit));
			else
				return false;
			n /= 10;
		}
		return true;
	}
	
	/**
	 * @return the minimal ratio of n/phi(n) where phi(n) is a permuation of n
	 * @throws Exception
	 */
	public long getSolution() throws Exception
	{
		// because the problem is asking for the "minimal" ratio there is a trick to which numbers can produce the required minimum:
		// take prime pairs (p1, p2) and calculate n as n = p1 * p2.
		// Lets assume n' is a product of prime tuple (p1, p2, p3).
		// r is ratio of n/phi(n)
		// r' is ratio of n'/phi(n').
		// So r/r' = (p3-1)/p3 which is smaller than 1.
		// r < r', so a composite number n which is a product of two primes will produce the minimal ratio
		double min = Double.MAX_VALUE;
		long result = 0;
		
		for (long p1 = 2; p1 < MAX_PRIME;)
		{
			try { p1 = _primes.generatePrime(p1); } catch (Exception ex) {break;}
			for (long p2 = p1; p2 < MAX_PRIME;)
			{
				try { p2 = _primes.generatePrime(p2); } catch (Exception ex) {break;}
				
				// work through the list of primes, and generate pairs of primes with the condition p1 != p2
				// the formula breaks down if p1 == p2, but I don't know why :(
				double n = p1*p2;

				// do not exceed maximum
				if (n > MAX_N)
					break;
				
				// get the totient (this is quite simple for the prime pairs)
				double phi = phicount(p1, p2);
				// check if phi is a permutation of n
				if (isPermutation((long)phi, (long)n))
				{
					// check if the ratio is a new minimum
					if (min > n/phi)
					{
						min = n/phi;
						result = (long)n;
					}
				}
			}
		}
		return result;
	}
}
