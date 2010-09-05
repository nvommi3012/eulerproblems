package problem_64;

import utils.ContinuedFraction;

/**
 * @author wolfgang
 * @note How many continued fractions for N <= 10000 have an odd period?
 */
public class Problem64 {

	// a little bit trial and error, until 10000 there is no periodic fraction longer than this 
	final int MAX_FRACTION_LENGTH = 350;

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
			ContinuedFraction cf = ContinuedFraction.fromSquare(i);
			// check if the fraction size is odd or even (remove 1 from size for the a0 element)
			if (((cf.periodSize() - 1) % 2) != 0)
				++result;
		}
		return result;
	}
}