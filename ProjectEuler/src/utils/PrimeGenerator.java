package utils;

public class PrimeGenerator {

	public long getPrime(int count) {
		long result = 0;
		long start = 2;

		// initialize prime checker class
		PrimeCheck p = new PrimeCheck();
		
		// outer loop checks the count of primes
		for (int i = 0; i < count; ++i)
		{
			// inner loop goes through all the possible values
			// start is always the last found prime + 1
			for (long j = start; j < Long.MAX_VALUE; ++j)
			{
				if (p.isPrime(j))
				{
					result = j;
					start = j + 1;
					break;
				}
			}
		}
		
		return result;
	}

	private long _lastPrimeCount;
	private long _lastPrimeNumber;
	
	public PrimeGenerator()
	{
		_lastPrimeCount = 0L;
		_lastPrimeNumber = 1L;
	}
	
	public long getNextPrime()
	{
		// initialize prime checker class
		PrimeCheck p = new PrimeCheck();

		for (long j = _lastPrimeNumber + 1; j < Long.MAX_VALUE; ++j)
		{
			if (p.isPrime(j))
			{
				++_lastPrimeCount;
				_lastPrimeNumber = j;
				return _lastPrimeNumber;
			}
		}
		return 0;
	}
	
}
