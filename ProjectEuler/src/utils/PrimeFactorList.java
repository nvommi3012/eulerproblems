package utils;

import java.util.TreeMap;
import java.util.Map.Entry;


// class to do prime factorization
public class PrimeFactorList extends TreeMap<Long, Long> {
	private static final long serialVersionUID = 1L;

	// factorize the number
	private void factorizeNumber(long i)
	{
		// check for stupid numbers
		if (i == 0)
			return;

		// get the prime checker
		PrimeCheck p = new PrimeCheck();
		// we divide the original number by its primes until it is no longer divisible
		while (i > 1)
		{
			for (long x = 2; x <= i; ++x)
			{
				if (((i % x) == 0) && p.isPrime(x))
				{
					// since we not only want to know which primes are a factor
					// but also in which power, we will add one power for each factor we find
					this.put(x, getPower(x) + 1);
					i = i / x;
					break;
				}
			}
		}
	}
	
	// constructor is used to factorize a number immediatly
	public PrimeFactorList(long i)
	{
		super();
		factorizeNumber(i);
	}
	
	// take a bunch of indiviual lists and make them one
	public static PrimeFactorList aggregateFactorLists(PrimeFactorList[] others)
	{
		PrimeFactorList result = new PrimeFactorList(0L);
		
		for (PrimeFactorList pfl: others)
		{
			if (pfl == null)
				continue;
			for(Entry<Long, Long> entry: pfl.entrySet())
			{
				if (entry == null)
					continue;
				
				// if the current entry is of a larger power than what we had previously
				// we need to update the result with the larger power
				// otherwise we ignore it
				if (entry.getValue() > result.getPower(entry.getKey()))
					result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}

	// only way to check if a factor was used (returns 0 if not, or > 0 if used)
	public long getPower(long i) {
		if (this.containsKey(i))
		{
			return this.get(i);
		}
		return 0;
	}

	// get each factor and its power and just multiply them
	public long calculateValue() {
		long result = 1;
		
		for (Entry<Long, Long> entry: this.entrySet())
		{
			// there is probably a math function which does the same
			for (long i = 0; i < entry.getValue(); ++i)
				result = result * entry.getKey();
		}
		
		return result;
	}
}