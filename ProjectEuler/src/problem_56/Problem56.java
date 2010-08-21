package problem_56;

import java.math.BigInteger;

/**
 * @author Wolfgang
 * @note Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
 */
public class Problem56 {

	/**
	 * @param s input number
	 * @return the sum of digits of <s>
	 */
	public int getDigitSum(String s) {
		int result = 0;
		// iterate through all 'digits' in the input number
		for (char c: s.toCharArray())
			result += c - '0';	// convert char to it's corresponding digit
		return result;
	}

	/**
	 * @return the maxiumum of the digit sum of a^b (for a,b < 100)
	 */
	public int getSolution() {
		// store maximum sum here
		int max = 0;
		// loop through all a's
		for (int a = 99; a > 0; --a)
		{
			// convert a to BigInteger
			BigInteger bigA = BigInteger.valueOf(a);
			// inner loop through all b's
			for (int b = 99; b > 0; --b)
			{
				// calculate a^b
				BigInteger AB = bigA.pow(b);
				
				// calculate sum of digits for a^b
				int dsum = getDigitSum(AB.toString());
				// check if this sum is greater than previous maximum
				if (dsum > max)
					max = dsum;
			}
		}
		return max;
	}

}
