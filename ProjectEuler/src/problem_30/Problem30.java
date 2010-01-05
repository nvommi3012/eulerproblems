package problem_30;

/**
 * @author Wolfgang
 * @note Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 {

	/**
	 * @param number number to check
	 * @param power power to check
	 * @return true if the sum of the digits^power equals the number itself
	 */
	public boolean isSumOfPower(int number, int power) {
		int sum = 0;
		int tmp = number;

		// check through all digits by looking at the least significant then shifting by one digit
		for (int digit = tmp % 10; tmp > 0; tmp /= 10, digit = tmp % 10)
			sum += Math.pow(digit, power);

		if (sum == number)
			return true;
		return false;
	}

	/**
	 * @param lower lower boundary
	 * @param upper upper boundary to check  
	 * @param power digit power
	 * @return sum of all numbers that qualify
	 * @note upper: For this problem it doesnt make sense to check above 9^5 * 6 (since any number > 6 digits has a sum that has less digits than its number)
	 * @note lower: For this problem it must be 2 by specification
	 */
	public int getAllSumOfPower(int lower, int upper, int power) {
		int sum = 0;
		
		for (int i = lower; i <= upper; ++i)
		{
			if (isSumOfPower(i, power))
				sum += i;
		}
		
		return sum;
	}

}
