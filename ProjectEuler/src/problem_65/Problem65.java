package problem_65;

import utils.ArrayList;
import utils.ContinuedFraction;
import utils.Fraction;

/**
 * @author wolfgang
 * @note Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 */
public class Problem65 {
	/**
	 * @return sum of digits in the numerator of the 100th convergent of the continued fraction for e
	 */
	public int getSolution() {
		
		// to store the fraction in
		ArrayList<Integer> e_frac = new ArrayList<Integer>();
		
		// add a0 first
		e_frac.add(Integer.valueOf(2));
		// add the fraction periodical of e (that is [1 2k 1])
		for (int k = 1; k <= 33; ++k)
		{
			e_frac.add(1);
			e_frac.add(k * 2);
			e_frac.add(1);
		}
		
		ContinuedFraction cf = new ContinuedFraction(e_frac);
		
		// calculate the 100th numerator (starting with 0 instead of 1)
		Fraction f = cf.getConvergent(99);
		// add the digits of the string representation
		int result = 0;
		for (char c: f.toString().split("/")[0].toString().toCharArray())
			result += c - '0';
		return result;
	}
}
