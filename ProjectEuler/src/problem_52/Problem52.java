package problem_52;

import java.util.Arrays;
import utils.Digits;

/**
 * @author Wolfgang
 * @note Find the smallest positive integer, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
public class Problem52 {

	/**
	 * @param n1 number to compare
	 * @param n2 other number to compare
	 * @return true if <n1> has the same digits as <n2>
	 */
	public boolean sameDigits(int n1, int n2)
	{
		// convert numbers to arrays
		int[] a1 = Digits.Number(n1);
		int[] a2 = Digits.Number(n2);
		
		// sort the arrays
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		// iterate through the digits and see if every one at the same index is the same
		for (int idx = 0; idx < a1.length; ++idx)
			if (a1[idx] != a2[idx])
				return false;
		// if all digits were the same return true
		return true;
	}
	
	/**
	 * @return the solution of problem 52 
	 * @throws Exception if no solution can be found
	 */
	public int getSolution() throws Exception {
		// n * 6 is only the same size if n is between 1000 and 1666 (and magnitudes thereof) so
		// make pairs of numbers that take that into consideration
		int[] checks = new int[]{100,166,1000,1666,10000,16666,100000,166666,1000000,1666666};

		// loop through the check-pairs
		for (int idx = 0; idx < checks.length; idx += 2)
		{
			int lower = checks[idx];
			int upper = checks[idx + 1];

			// loop from lower to upper limit to find the result
			// check same digits for i and its multiplications (from 2 to 6) 
			for (int i = lower; i < upper; ++i)
				if (sameDigits(i, i*2) && sameDigits(i, i*3) && sameDigits(i, i*4) && sameDigits(i, i*5) && sameDigits(i, i*6))
					return i;
		}
		throw new Exception("no solution found");
	}
}
