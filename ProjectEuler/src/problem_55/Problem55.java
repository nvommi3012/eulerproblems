package problem_55;

import java.math.BigInteger;

/**
 * @author Wolfgang
 * @note How many Lychrel numbers are there below ten-thousand?
 */
public class Problem55 {

	/**
	 * @param i number to check for palindrome
	 * @return true if number is palindromic
	 */
	public boolean isPalindrome(BigInteger i) {
		// convert number to string
		String number = i.toString();
		// check each digit with the counter on the other end of the string
		for (int n = 0; n < number.length() / 2; ++n)
			if (number.charAt(n) != number.charAt(number.length() - n - 1))
				return false;
		return true;
	}

	/**
	 * @param b number to reverse
	 * @return the reversed number (ie. 123 => 321)
	 */
	public BigInteger reverseNumber(BigInteger b) {
		// convert to string
		String number = b.toString();
		// store reversed string here
		String reversed = "";
		
		// loop from back of number string and add to reversed string
		for (int n = 0; n < number.length(); ++n)
			reversed += number.charAt(number.length() - n - 1);

		// create new number from reversed string and return it
		return new BigInteger(reversed);
	}

	
	/**
	 * @return the number of Lychrel numbers (<= 50 iterations) below 10000
	 */
	public int getSolution() {
		int result = 0;
		// loop through all numbers <= 10000, since 0 can't be reversed and doubled with resonable results, start with 1
		for (int number = 1; number <= 10000; ++number)
		{
			// create a BigInteger out of the number
			BigInteger b = BigInteger.valueOf(number);
			// assume there was no palindrome
			boolean found = false;
			
			// make at most 50 iterations of the algorithm
			for (int iterations = 0; iterations < 50; ++iterations)
			{
				// reverse the number and add it to the original
				BigInteger reverse = reverseNumber(b);
				b = b.add(reverse);
				// if result is palindromic, it's not a Lychrel number 
				if (isPalindrome(b))
				{
					found = true;
					break;
				}
			}
			// if the iterations did not find a palindrome increase result counter
			if (!found)
				++result;
		}
		return result;
	}
}

