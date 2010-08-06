package problem_43;

import utils.Permutation;

/**
 * @author Wolfgang
 * @note Find the sum of all 0 to 9 pandigital numbers with this (special) property.
 */
public class Problem43 {
	
	/**
	 * @param digits array of digits
	 * @param start start index in the array
	 * @param len number of digits to be used
	 * @return the resulting number
	 */
	public long makenumber(byte[] digits, int start, int len)
	{
		// init resulting number with zero
		long result = 0;
		// loop through digits from starting index to starting index + number of digits
		for (int i = start; i < start + len; ++i)
		{
			// calculate the number by first shifting the existing digits (*10) and then adding the new digit
			result *= 10;
			result += digits[i];
		}
		return result;
	}
	
	/**
	 * @param digits array of digits
	 * @param n subnumber to generate
	 * @return the 3 digit subnumber
	 */
	public int getSubnumbernth(byte[] digits, int n) {
		// d2d3d4, d3d4d5 ..., d8d9d10
		byte startingdigit[] = new byte[]{1,2,3,4,5,6,7};
		return (int)makenumber(digits, startingdigit[n], 3);
	}

	/**
	 * @return the sum of all pan digital numbers that match the strange requirements
	 */
	public long getSolution() {
		long result = 0;
		// this is one of the requirements (subnumbers divideable by these primes)
		int primes[] = new int[] {2,3,5,7,11,13,17};
		boolean found = false;
		// 3628800 == 10! which is exactly the count of numbers we need to permute
		for (int i = 0; i < 3628800; ++i)
		{
			// assume requirements are met
			found = true;
			// get the nth permutation
			byte[] digits = Permutation.permutenth(new byte[] {1,2,3,4,5,6,7,8,9,0}, i);
			// check the 7 subnumbers
			for (int j = 0; j < 7; ++j)
			{
				int test = 0;
				test = getSubnumbernth(digits, j);
				// if even one of the subnumbers is not divisible by its prime it's not valid
				if (test % primes[j] != 0)
				{
					found = false;
					break;
				}
			}
			if (found)
			{
				// make number of digits and add to result
				result += makenumber(digits, 0, 10);;
			}
		}
		return result;
	}

}
