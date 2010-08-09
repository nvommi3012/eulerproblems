package problem_41;

import java.util.NavigableSet;
import java.util.TreeMap;
import utils.Primes;

/**
 * @author Wolfgang
 * @note find the largest n-digit pandigital that is also a prime
 */
public class Problem41 {

	/**
	 * @param number prime to be tested
	 * @return true if n-pandigital
	 */
	public boolean is_n_Palindromic(long number) {
		// TreeMap might be a bit overkill to get a sorted list of up to 7 entries
		TreeMap<Byte, Byte> digits = new TreeMap<Byte, Byte>();
		
		// separate the number into its digits
		while (number > 0)
		{
			// get the least significant digit
			Byte digit = (byte)(number % 10);
			// zero is not allowed in a pandigital number
			if (digit == 0)
				return false;
			// also each digit must not be a duplicate (Map.put returns non-null value if key is already in map)
			if (null != digits.put(digit, digit))
				return false;
			// remove the least significant number
			number /= 10;
		}
		// get a sorted set out of the map
		NavigableSet<Byte> sorted = digits.descendingKeySet();
		// check the first and last entry
		// in a descending sorted set the highest digit is the first and must match exactly the number of entries in the set
		// the last entry must be 1
		if (sorted.last() != 1 || sorted.first() != sorted.size())
			return false;
		return true;
	}

	/**
	 * @return the value of the biggest n-digital prime
	 */
	public long getSolution() {
		try {
			long prime;
			Primes gen = new Primes();
			// 7654321 is the upper limit we have to search, because
			// 1+2+3+4+5+6+7+8=36 and 1+2+3+4+5+6+7+8+9=45 both of which are
			// divisible by 3 with 0 remainder which indicates that
			// 8- or 9-pandigital numbers cannot be primes
			prime = gen.generatePreviousPrime(7654321L);
			// just in case there are no pandigital primes check for 2
			while (prime > 2)
			{
				// test the prime number
				if (is_n_Palindromic(prime))
				{
					return prime;
				}
				// get the next lowest prime
				prime = gen.generatePreviousPrime(prime);
			}
		}
		catch(Exception e){}
		// provided there is at least one pandigital prime we should never get here
		return 0L;
	}

}
