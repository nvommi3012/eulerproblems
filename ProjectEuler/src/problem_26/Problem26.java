package problem_26;

/**
 * @author Wolfgang
 * @note Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Problem26 {

	private static final int MAX_PRECISION = 1000;

	/**
	 * @param divisor the number to divide 1 with 
	 * @return the length of the recurring pattern in the result of the division
	 */
	public int getPatternLength(int divisor) {

		// used for "manual" division: stores the ?
		int[] quotients = new int[MAX_PRECISION];
		// used to store the remainder of the division steps
		int[] remainders = new int[MAX_PRECISION];
 
		remainders[0] = 1;	// init with 1 because this is the number we need to divide
 
		for (int i = 1; i < MAX_PRECISION; ++i)
		{
			// calculate the next step
			// 1. remainder * 10
			// 2. get the modulo and division result by dividing with the divisor
			// 3. the division result is the next digit in the result
			// 4. the remainder is used as the next step
			int step = remainders[i - 1] * 10;
			quotients[i] =  step / divisor;
			remainders[i] = step - quotients[i] * divisor;
 
			// check if we repeat a pattern. if a single step is exactly like something we already encountered
			// there is no way out of that and so our pattern is finished
			for (int j = 1; j < i; ++j)
				if (quotients[j] == quotients[i] && remainders[j] == remainders[i])
					return i-j;
		}
 		return 0;
	}
 
	/**
	 * @param count number to calculate to
	 * @return the number smaller than count which has the largest pattern
	 */
	public int getLargestPattern(int count)
	{
		int result = 0;	// store the number with the max pattern
		int max = 0;	// the max pattern length

		// iterate through all numbers smaller than count
		for (int i = 2; i < count; ++i)
		{
			// get the pattern length from number
			int tmp = getPatternLength(i);
			// if pattern is greater than previous then store pattern and corresponding number
			if (tmp > max)
			{
				max = tmp;
				result = i;
			}
		}
		return result;
	}
	
}
