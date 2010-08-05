package problem_43;

/**
 * @author Wolfgang
 * @note Find the sum of all 0 to 9 pandigital numbers with this (special) property.
 */
public class Problem43 {
	
	/**
	 * @param digits byte array containing all 10 digits
	 * @param permutation number of the permutation to be calculated
	 * @return the resulting permutated array of digits
	 * @note this function is adapted from a javascript function found on the internet
	 */
	public byte[] permutenth(byte[] digits, int permutation)
	{
		byte j = 0, k = 0;
		int factorials[] = new int[digits.length];
		byte idn[] = new byte[digits.length];
		
		// calculate factorials up to n 
		factorials[digits.length - 1] = 1;
		for(j = (byte)(digits.length - 2); j >= 0; --j)
			factorials[j] = factorials[j+1] * (digits.length - 1 - j);

		// ???
		for(j = 0; j < (byte)(digits.length - 1); ++j)
			idn[j] = j;

		// switch the digits
		for (j = 0; j < digits.length; ++j)
		{
			// the factorials define what numbers can stay the same and what has to move
			// assume we have a set {1,2,3,4,5} and want the 5 permutation:
			// we can now safely say we don't need to move the 1 and 2 because with the subset
			// {3,4,5} we already have 3! permutations to do (3! > 5)
			byte idx = (byte) (permutation / factorials[j]);
			byte tmp = idn[j];
			idn[j] = idn[j + idx];
			idn[j + idx] = tmp;
			tmp = digits[j + idx];
			
			for (k = idx; k > 0; --k)
				digits[j + k] = digits[j + k - 1];
			
			digits[j] = tmp;

			// remove the already done permutations
			permutation -= (idx*factorials[j]);
		}
		return digits;
	}
	
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
			byte[] digits = permutenth(new byte[] {1,2,3,4,5,6,7,8,9,0}, i);
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
