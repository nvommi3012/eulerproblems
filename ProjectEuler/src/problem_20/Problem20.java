package problem_20;

import java.math.BigInteger;

/**
 * @author Wolfgang
 * @note Find the sum of the digits in the number 100!
 */
public class Problem20 {

	/**
	 * @param count number to calculate the factorial
	 * @return "number!" as BigInteger
	 */
	public BigInteger getFactorial(int count) {
		// the factorial of 0 is probably 0 as well
		if (count == 0)
			return new BigInteger("0");
		// start of with 1
		BigInteger result = new BigInteger("1");
		// multiply with each number less or equal than the maximum
		for (Integer i = 2; i <= count; ++i)
			result = result.multiply(new BigInteger(i.toString()));
		return result;
	}

	/**
	 * @param number number to calcualte the factorial
	 * @return the sum of all digits in the factiorial
	 */
	public int getFactorialSum(int number) {
		// get the factorial of number
		BigInteger factorial = getFactorial(number);
		int result = 0;
		// convert to string so we can get to the digits
		String s = factorial.toString();
		for (char c: s.toCharArray())
		{
			// add the value of each digit
			result += c - '0';
		}
		return result;
	}
	
}
