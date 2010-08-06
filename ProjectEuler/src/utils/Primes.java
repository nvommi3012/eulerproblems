package utils;

import java.util.TreeSet;

public class Primes {

	private TreeSet<Long> _primes;
	private boolean _optimize;
	private long _upperLimit;

	public Primes()
	{
		_primes = new TreeSet<Long>();
		_optimize = false;
	}
	
	private void optimize(long limit)
	{
		long prime = 2;
		try
		{
			while (prime <= limit)
				prime = generatePrime(prime);
			_optimize = true;
			_upperLimit = limit;
		}
		catch(Exception e)
		{
			_optimize = false;
		}
	}
	
	public long generatePrime(long start) throws Exception
	{
		if (start < 2)
			return 2;
		
		long upper = Math.round(Math.sqrt(start)) + 1;
		
		for (long n = start + 1; n < Long.MAX_VALUE; ++n)
		{
			boolean found = true;
			if (n % 2 == 0)
				continue;
			for (long div = 3; div < upper; div+=2)
			{
				// if there is a number which divides n with no rest then we can safely assume n is not a prime
				if (n % div == 0)
				{
					found = false;
					break;
				}
			}
			if (found)
			{
				_primes.add(n);
				return n;
			}
		}
		throw new Exception("No Prime found for value " + start);
	}
	
	public Primes(long limit)
	{
		_primes = new TreeSet<Long>();
		optimize(limit);
	}
	
}
