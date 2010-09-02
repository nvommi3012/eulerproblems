package problem_65;

import java.math.BigInteger;
import utils.ArrayList;

/**
 * @author wolfgang
 * @note Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 */
public class Problem65 {

	/**
	 * @param e_frac the sequence of continued fractions of e
	 * @param n the precision to which to calculate
	 * @return the value of the numerator at index n
	 * @note http://en.wikipedia.org/wiki/Continued_fraction#Infinite_continued_fractions
	 */
	BigInteger h(ArrayList<BigInteger> e_frac, int n)
	{
		BigInteger h2 = BigInteger.ZERO;
		BigInteger h1 = BigInteger.ONE;
		BigInteger h = h2;
		
		// use the recursive theorem h(n) = a(n) * h(n-1) + h(n-2)
		// replaced recursion by loop, because recursion was taking far to long
		for (int i = 0;i <= n; ++i)
		{
			// generate new h(n)
			h = h1.multiply(e_frac.get(i)).add(h2);
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
	BigInteger k(ArrayList<BigInteger> e_frac, int n)
	{
		BigInteger k1 = BigInteger.ZERO;
		BigInteger k2 = BigInteger.ONE;
		BigInteger k = k2;
		
		// use the recursive theorem k(n) = a(n) * k(n-1) + k(n-2)
		// replaced recursion by loop, because recursion was taking far to long
		for (int i = 0;i <= n; ++i)
		{
			// generate new k(n)
			k = k1.multiply(e_frac.get(i)).add(k2);
			// update k(n-1) and k(n-2)
			k2 = k1;
			k1 = k;
		}
		return k;
	}
	
	/**
	 * @return sum of digits in the numerator of the 100th convergent of the continued fraction for e
	 */
	public int getSolution() {
		
		// to store the fraction in
		ArrayList<BigInteger> e_frac = new ArrayList<BigInteger>();
		
		// add a0 first
		e_frac.add(BigInteger.valueOf(2));
		// add the fraction periodical of e (that is [1 2k 1])
		for (int k = 1; k <= 33; ++k)
		{
			e_frac.add(BigInteger.ONE);
			e_frac.add(BigInteger.valueOf(k * 2));
			e_frac.add(BigInteger.ONE);
		}
		// calculate the 100th numerator (starting with 0 instead of 1)
		BigInteger h = h(e_frac, 99);
		// add the digits of the string representation
		int result = 0;
		for (char c: h.toString().toCharArray())
			result += c - '0';
		return result;
	}
}
