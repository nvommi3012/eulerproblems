package problem_38;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author Wolfgang
 * @note What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
public class Problem38 {

	/**
	 * @param s string (long number) to be checked
	 * @return true if the number is n-Palimdronic
	 * @note zero is not a valid digit for the palindrome (only 1-9)
	 */
	public boolean isPalindromic(String s) {
		// store digits in a hashset
		Collection<Character> set = new HashSet<Character>();
		// go through all the digits
		for (char c: s.toCharArray())
		{
			// if zero comes up the number is not palindromic
			if (c == '0')
				return false;
			// if the number was already added (add returns false) the number is also not palindromic
			if (false == set.add(c))
				return false;
		}
		
		// if the number of digits stored is equal to the length of the number (string) it is palindromic
		if (set.size() == s.length())
			return true;
		return false;
	}

	/**
	 * @return the solution to problem 38 (largest palindromic number)
	 */
	public long getSolution() {
		// string builder for more performance
		StringBuilder s = new StringBuilder();
		// 9999 should be way more than the upper limit
		// since we need to do at least 9999*1 + 9999*2 for the criteria to match
		// ==> 999919998
		for (long l = 9999; l > 0; --l)
		{
			// reset the string builder
			s.setLength(0);
			// do a few steps, 10 is the theoretical max (1*1 + 1*2 + 1*3 + ... + 1*9 = 1234565789)
			for (long step = 1; step < 10; ++step)
			{
				// calc the next part of the string
				long test = l * step;
				// add the next part to the string
				s.append(test);
				// check for palindrome
				if (false == isPalindromic(s.toString()))
					break;
				// if it is palindromic the other criteria are:
				// 1-9 palindromic and more than 1 step was used
				if (s.length() == 9 && step > 1)
				{
					//System.out.println("Found one at " + s + "["+l+"]" + "["+step+"]");
					return Long.parseLong(s.toString());
				}
				// if the length is already more than 9 it's no match
				else if (s.length() > 9)
					break;
			}
		}
		return 0;
	}
}
