package problem_16;

import java.math.BigInteger;

/**
 * @author Wolfgang
 * Problem 16: What is the sum of the digits of the number 2^(1000)?
 */
public class Problem16 {

	/**
	 * @param exponent (2^exponent)
	 * @return the sum of the digits of 2^exponent
	 */
	public int getDigitSum2Squared(int exponent) {
		// create a BigInteger of 2 and power to the specified exponent
		BigInteger square = new BigInteger("2");
		square = square.pow(exponent);

		// for each digit in the result => add them
		int result = 0;
		char[] ca = square.toString().toCharArray();
		for (char c: ca)
			result += c - '0';
		
		return result;
	}
}
