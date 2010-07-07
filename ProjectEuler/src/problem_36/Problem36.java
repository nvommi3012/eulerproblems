package problem_36;

/**
 * @author Wolfgang
 * @note Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2
 */
public class Problem36 {
	/**
	 * @param number
	 * @return a string of the base 10 representation of number
	 */
	public String toBase10(int number) {
		return String.valueOf(number);
	}
	
	/**
	 * @param number
	 * @return a string of the base 2 representation of number
	 */
	public String toBinary(int number) {
		
		int binarydigits = (int)Math.ceil(Math.log(number) / Math.log(2));
		int tmpnumber = number;
		String result = "";

		// the log2(2^n) is 1 less than the digits we actually need
		if ((int)Math.pow(2, binarydigits) == number)
			binarydigits++;

		// we must not use leading zeroes, so we need to convert the number exactly
		for (int idx = 0; idx < binarydigits; ++idx)
		{
			if ((tmpnumber % 2) == 1)
				result = "1".concat(result);
			else
				result = "0".concat(result);
			tmpnumber /= 2;
		}
		return result;
	}

	/**
	 * @param test
	 * @return true if test string is a palindrome
	 */
	public boolean isPalindromic(String test) {

		byte[] chars = test.getBytes();
		byte[] rchars = new byte[chars.length];

		// create the reverse byte array of the input string
		for (int i = 0; i < chars.length; ++i)
			rchars[i] = chars[chars.length - 1 - i];

		// compare original and reverse, if not exactly the same it's not a palindrome
		for (int i = 0; i < chars.length; ++i)
			if (rchars[i] != chars[i])
				return false;
		
		return true;
	}

	/**
	 * @return the sum of all palindromes in base2,10 lower than 1.000.000
	 */
	public Object getSolution() {
		int result = 0;
		
		for (int i = 1; i < 1000000; ++i)
		{
			if (isPalindromic(toBinary(i)) && isPalindromic(toBase10(i)))
				result += i;
		}
		return result;
	}
}
