package utils;

public class PrimesFactory {

	public static IPrimes getAtkins(int limit)
	{
		return new PrimesAtkins(limit);
	}

	public static IPrimes getSieve()
	{
		return new PrimesSieve();
	}

	public static IPrimes getSieve(long limit)
	{
		return new PrimesSieve(limit);
	}
}
