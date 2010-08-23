package problem_57;

import java.math.BigInteger;

/**
 * @author wolfgang
 * @note In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */
public class Problem57 {
	
	/**
	 * @param n the iterations of the continued fraction
	 * @return numerator and denominator in an array
	 */
	BigInteger[] getSquareRoot(int n)
	{
		// start with 1/2
		BigInteger num = BigInteger.valueOf(1);
		BigInteger denom = BigInteger.valueOf(2);
		
		// loop n-times through the algorithmn
		while (n > 0)
		{
			// the algorithm is quite simple:
			// just add 2 to the number (== 2 * denominator added to numerator)
			num = num.add(denom.add(denom));
			// then 1 / n ( == switch numerator and denominator)
			BigInteger tmp = num;
			num = denom;
			denom = tmp;
			// decrease counter
			--n;
		}

		// finally add the 1 from the formula ( == add denominator to numerator)
		num = num.add(denom);
		
		// return both in an array
		return new BigInteger[] {num, denom};
	}

	/**
	 * @return the number of fraction steps where the numerator has more digits than denominator
	 */
	public int getSolution() {
		// init result
		int result = 0;
		// do 1000 steps
		for (int n = 0; n < 1000; ++n)
		{
			// get numerator and denominator
			BigInteger[] de_nom = getSquareRoot(n);
			// convert to string to get digits and compare length
			if (de_nom[0].toString().length() > de_nom[1].toString().length())
				++result;
		}
		return result;
	}
}
