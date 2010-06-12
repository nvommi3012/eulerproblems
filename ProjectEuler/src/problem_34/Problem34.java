package problem_34;

/**
 * @author Wolfgang
 * @note Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 */
public class Problem34 {

	/**
	 * factorials of numbers 0 through 9
	 */
	private long _factorials[];
	
	/**
	 * Ctor, init factorials array
	 */
	public Problem34()
	{
		_factorials = new long[] {1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L};
	}

	/**
	 * @param i factorial to calculate
	 * @return the factorial of i
	 * @note for much larger factorials recusrive function would be needed, but for this problem it's far more efficient to use an array
	 */
	public long factorial(int i)
	{
		return _factorials[i];
	}


	/**
	 * @return the solution to problem 34
	 */
	public long getSolution() {
		// single digits are not considered sums, so we start with 10
		int digits[] = new int[] {0, 0, 0, 1, 0};
		// store the sum of the factorials that match our criteria
		long result = 0;
		
		for (;;)
		{
			long sum = 0;
			long fact = 0;
			boolean lead = true;

			// calculate the factorial (and the resulting sum) for each digit of the number
			for (int i = 0; i < digits.length; ++i)
			{
				if (digits[i] != 0)
					lead = false;
				if (lead == false)
					sum += factorial(digits[i]);
			}
			
			// convert the array of digits into a long
			for (int i = 0; i < digits.length; ++i)
			{
				fact *= 10;
				fact += digits[i];
			}

			// check if both numbers are the same and add the number to the final result
			if (sum == fact)
				result += sum;
			
			// increment the number
			++digits[digits.length - 1];
			for (int i = digits.length - 1; i > 0; --i)
				if (digits[i] > 9)
				{
					digits[i] = 0;
					++digits[i - 1];
				}
			
			// if the "first" digit exceeds 9 than the loop is done
			if (digits[0] > 9)
				break;
		}
		return result;
	}
	
}
