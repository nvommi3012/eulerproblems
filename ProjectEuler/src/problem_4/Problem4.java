package problem_4;

// Find the largest palindrome made from the product of two 3-digit numbers.
public class Problem4 {

	// lazy conversion to string to check if number is a palindrome
	public static boolean isPalindrom(Integer i) {
		String number = i.toString();

		for (int n = 0; n < number.length(); ++n)
		{
			if (number.charAt(n) != number.charAt(number.length() - n - 1))
				return false;
		}
		
		return true;
	}

	// since we just look for the biggest palindrome start from the maximum (999 x 999)
	public static int getLargestPalindrom(int digits) {
		int maxes[] = { 9, 99, 999 };
		int mins[] = { 1, 10, 100 };
		int test = 0, maxpalindrom = 0;

		// add checks for ArrayOutOfBound Exceptions
		int max = maxes[digits - 1];
		int min = mins[digits - 1];
		
		// multiply two numbers and check the result
		for (int x = max; x >= min; --x)
			for (int y = max; y >= min; --y )
			{
				test = x * y;
				// if the result is already smaller than what we found
				// skip the rest and continue with the outer loop
				if (test < maxpalindrom)
					break;
				
				// we only look at the biggest palindromic number
				if (isPalindrom(test) && test > maxpalindrom)
					maxpalindrom = test;
			}
		return maxpalindrom;
	}
}
