package problem_64;

import utils.ArrayList;

/**
 * @author wolfgang
 * @note How many continued fractions for N <= 10000 have an odd period?
 */
public class Problem64 {

	// a little bit trial and error, until 10000 there is no periodic fraction longer than this 
	final int MAX_FRACTION_LENGTH = 220;

	/**
	 * @return the number of odd continued fractions for sqr(n) for 2 <= n <= 10000
	 * @throws Exception if no solution can be found 
	 */
	public int getSolution() throws Exception {
		// the result counter
		int result = 0;
		
		// check all numbers from 2 to 10000
		for (int i = 2; i <= 10000; ++i)
		{
			// get the continued fraction
			ArrayList<Integer> pattern = getPeriod(i);
			// check if the fraction size is odd or even (remove 1 from size for the a0 element)
			if (((pattern.size() - 1) % 2) != 0)
				++result;
		}
		return result;
	}
	
	/**
	 * @param S the number to calculate the fraction from
	 * @return the continued fraction for MAX_FRACTION_LENGTH digits
	 * @note http://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Example.2C_square_root_of_114_as_a_continued_fraction
	 */
	ArrayList<Integer> getContinuedFraction(int S)
	{
		// the algorithm to compute square roots using continued fraction is adapted from wikipedia
		int a0 = (int)Math.sqrt(S);
		int d0 = 1;
		int m0 = 0;
		int mn = m0;
		int dn = d0;
		int an = a0;
		
		// add a0 immediately
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(an);
		
		// if S is an even root, there is no fraction to calculate
		if (S == a0 * a0)
			return result;

		// now generate all digits of the fraction and add them to the result array
		for (int i = 0; i < MAX_FRACTION_LENGTH; ++i)
		{
			mn = dn * an - mn;
			dn = (S - mn * mn) / dn;
			an = (a0 + mn) / dn;
			result.add(an);
		}
		return result;
	}

	/**
	 * @param S the number to calculate the square root from
	 * @return the pattern of the periodic fraction
	 * @throws Exception if not pattern can be found (increase MAX_FRACTION_LENGTH if this happens!)
	 */
	public ArrayList<Integer> getPeriod(int S) throws Exception {
		// get the fraction digits
		ArrayList<Integer> fraction = getContinuedFraction(S);
		// create a result array
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// add a0 to the result (and remove it from the original fraction)
		result.add(fraction.remove(0));
		int a0 = result.get(0);
		// now add as many digits from the fraction until we find one that is exactly twice the a0
		// i am not sure why this is so, but taking a quick look at the periodic fractions it becomes
		// immediately obvious that it is so
		for (int i: fraction)
		{
			result.add(i);
			if (i == 2 * a0)
				break;
		}
		// check again for even square roots and the 2 * a0
		if (fraction.size() > 1 && 2 * a0 != result.get(result.size() - 1))
				throw new Exception("no pattern found for "+ S);
		return result;
	}
}