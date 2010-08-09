package utils;

import java.util.TreeSet;

public class Primes {

	private TreeSet<Long> _primes;
	private TreeSet<Long> _unordered;
	private boolean _optimize;
	private long _upperLimit;

	public Primes()
	{
		_primes = new TreeSet<Long>();
		_unordered = new TreeSet<Long>();
		_primes.add(2L);
		_unordered.add(2L);
		_optimize = false;
	}

	public Primes(long limit)
	{
		_primes = new TreeSet<Long>();
		_unordered = new TreeSet<Long>();
		_primes.add(2L);
		optimize(limit);
	}
	
	private void optimize(long limit)
	{
		try
		{
			_optimize = true;
			_upperLimit = 2L;
			long prime = 2L;
			while (prime <= limit)
				prime = generatePrime(prime);
		}
		catch(Exception e)
		{
			_optimize = false;
		}
	}
	
	private long getUpperLimit(long n)
	{
		return (long)Math.ceil(Math.sqrt(n));
	}
	
	private boolean checkModulo(long n, long upper)
	{
		// if n divides by 2 (or a multiple thereof) it is not prime (with the exception of 2 itself)
		if (n > 2 && n % 2 == 0)
			return false;
		// since 2 is not a factor, start at three and leave all even numbers out
		for (long div = 3; div <= upper; div+=2)
		{
			// if there is a number which divides n with no rest then we can safely assume n is not a prime
			if (n % div == 0)
				return false;
		}
		return true;
	}
	
	private boolean checkFactor(long n, long upper)
	{
		if (_primes.size() > 0)
		{
			for (long fac: _primes)
			{
				if (fac > upper)
					break;
				if ((n % fac) == 0)
					return false;
			}
		}

		if (_unordered.size() > 0)
		{
			for (long fac: _unordered)
			{
				if (fac > upper)
					break;
				if ((n % fac) == 0)
					return false;
			}
		}
		return true;
	}
	
	private void addPrime(long n, long start)
	{
		if (start == _primes.last() + 1)
		{
			_upperLimit = n;
			_primes.add(n);
		}
		else
		{
			_unordered.add(n);
		}
	}
	
	public long generatePrime(long start) throws Exception
	{
		if (start < 2)
			return 2;
		
		for (long n = start + 1; n < Long.MAX_VALUE; ++n)
		{
			long upper = getUpperLimit(n);
			if (true == checkModulo(n, upper))
			{
				addPrime(n, start);
				return n;
			}
		}
		throw new Exception("No Prime found for value " + start);
	}
	
	public long generatePreviousPrime(long start) throws Exception
	{
		// >>!! could be optimized
		for (long n = start - 1; n > 1; --n)
		{
			long upper = getUpperLimit(n);
			if (true == checkModulo(n, upper))
			{
				addPrime(n, 0);
				return n;
			}
		}
		// <<!!
		throw new Exception("No Prime found for value " + start);
	}
	
	public boolean isPrime(long n)
	{
		if (_primes.contains(n))
			return true;

		if (_unordered.contains(n))
			return true;

		if (_optimize && n < _upperLimit)
			return false;

		if (n < 2)
			return false;

		long upper = getUpperLimit(n);

		if (false == checkFactor(n, upper))
			return false;
		if (false == checkModulo(n, upper))
			return false;

		try 
		{
			if (_optimize)
			{
				if (generatePrime(_primes.last() + 1) == n)
				{
					addPrime(n, _primes.last() + 1);
				}
			}
			else
				addPrime(n, 0);
		}
		catch (Exception e)
		{
			addPrime(n, 0);
		}
		return true;
	}
}
