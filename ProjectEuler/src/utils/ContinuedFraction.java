package utils;

import java.math.BigInteger;

public class ContinuedFraction {

	ArrayList<Integer> e_frac;
	
	public ContinuedFraction()
	{
		e_frac = null;
	}
	
	public ContinuedFraction(int[] frac)
	{
		e_frac = new ArrayList<Integer>();
		for (int i: frac)
			e_frac.add(i);
	}

	public ContinuedFraction(ArrayList<Integer> frac)
	{
		e_frac = new ArrayList<Integer>();
		e_frac.addAll(frac);
	}
	
	private int get(int index)
	{
		if (index >= e_frac.size())
		{
			// remove a0
			index = (index % (e_frac.size() - 1)) + 1;
			return e_frac.get(index);
		}
		return e_frac.get(index);
	}
	
	/**
	 * @param e_frac the sequence of continued fractions of e
	 * @param n the precision to which to calculate
	 * @return the value of the numerator at index n
	 * @note http://en.wikipedia.org/wiki/Continued_fraction#Infinite_continued_fractions
	 */
	BigInteger h(int n)
	{
		BigInteger h2 = BigInteger.ZERO;
		BigInteger h1 = BigInteger.ONE;
		BigInteger h = h2;
		
		// use the recursive theorem h(n) = a(n) * h(n-1) + h(n-2)
		// replaced recursion by loop, because recursion was taking far to long
		for (int i = 0;i <= n; ++i)
		{
			// generate new h(n)
			h = h1.multiply(BigInteger.valueOf(get(i))).add(h2);
			// update h(n-1) and h(n-2)
			h2 = h1;
			h1 = h;
		}
		return h;
	}
	
	/**
	 * @param e_frac the sequence of continued fractions of e
	 * @param n the precision to which to calculate
	 * @return the value of the denominator at index n
	 * @note http://en.wikipedia.org/wiki/Continued_fraction#Infinite_continued_fractions
	 */
	BigInteger k(int n)
	{
		BigInteger k1 = BigInteger.ZERO;
		BigInteger k2 = BigInteger.ONE;
		BigInteger k = k2;
		
		// use the recursive theorem k(n) = a(n) * k(n-1) + k(n-2)
		// replaced recursion by loop, because recursion was taking far to long
		for (int i = 0;i <= n; ++i)
		{
			// generate new k(n)
			k = k1.multiply(BigInteger.valueOf(get(i))).add(k2);
			// update k(n-1) and k(n-2)
			k2 = k1;
			k1 = k;
		}
		return k;
	}

	public Fraction getConvergent(int n)
	{
		if (e_frac == null)
			throw new IllegalArgumentException("Fraction period needed");
		return new Fraction(h(n), k(n));
	}
}
