package utils;

/**
 * @author Wolfgang
 * @note Prime number generator up to Long.MAX_VALUE
 */
public class PrimeGenerator {

	// Prime Checker member
	private PrimeCheck _check;
	// to store the last prime for get next and previous
	private long _lastPrimeCount;
	private long _lastPrimeNumber;
	
	/**
	 * @param count the nth prime starting with 2 (count == 1)
	 * @return the nth prime
	 */
	public long getPrime(int count) {
		long result = 0;

		if (count < _lastPrimeCount)
		{
			_lastPrimeCount = 0;
			_lastPrimeNumber = 1L;
		}
		
		// outer loop checks the count of primes
		for (long i = _lastPrimeCount; i < count; ++i)
		{
			// inner loop goes through all the possible values
			// start is always the last found prime + 1
			for (long j = _lastPrimeNumber + 1; j < Long.MAX_VALUE; ++j)
			{
				if (_check.isPrime(j))
				{
					_lastPrimeNumber = result = j;
					_lastPrimeCount = i + 1;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Default CTor, no pregeneration of primes
	 */
	public PrimeGenerator()
	{
		_lastPrimeCount = 0L;
		_lastPrimeNumber = 1L;
		_check = new PrimeCheck();
	}
	
	/**
	 * @param max upper limit to pregenerate primes for
	 */
	public PrimeGenerator(long max)
	{
		_check = new PrimeCheck(max);
		_lastPrimeCount = 0L;
		_lastPrimeNumber = 1L;
	}
	
	/**
	 * @param upper value to generate primes back from
	 * @return the highest prime <= upper
	 */
	public long getUpperLimitPrime(long upper)
	{
		_lastPrimeNumber = upper + 1;
		return getPreviousPrime();
	}
	
	/**
	 * @return the highest primes < the last generated prime
	 */
	public long getPreviousPrime()
	{
		// start off last prime - 1 and loop to 2 at most
		for (long j = _lastPrimeNumber - 1; j >= 2; --j)
		{
			// if the value is prime, remember and return prime
			if (_check.isPrime(j))
			{
				--_lastPrimeCount;
				_lastPrimeNumber = j;
				return _lastPrimeNumber;
			}
		}
		return 0;		
	}
	
	/**
	 * @return the next higher prime from last generated prime
	 */
	public long getNextPrime()
	{
		// start at the last prime + 1 and loop until MaxValue
		for (long j = _lastPrimeNumber + 1; j < Long.MAX_VALUE; ++j)
		{
			// check for primeness and return prime number
			if (_check.isPrime(j))
			{
				++_lastPrimeCount;
				_lastPrimeNumber = j;
				return _lastPrimeNumber;
			}
		}
		return 0;
	}
}
