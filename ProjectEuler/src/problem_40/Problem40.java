package problem_40;

/**
 * @author Wolfgang
 * @note If d_(n) represents the n^(th) digit of the fractional part, find the value of the following expression.
 */
public class Problem40 {

	/**
	 * @param number number to get the digit from
	 * @param pos position of the digit
	 * @return digit at position
	 */
	private int getRightDigit(int number, int pos)
	{
		// for example number 1234567890, we want the 5 digit (which would be 5) 
		// 10^5 = 100000
		// 1234567890 / 100000 = 12345
		// 12345 % 10 = 5, which is the correct digit
		
		// get the 10^n of the position
		int div = (int)Math.pow(10, pos);
		// divide by 10^n so the digit we want is at last position
		int remainder = number / div;
		// now just mod by 10 so we get just the digit
		int result = remainder % 10;
		return result;
	}
	
	/**
	 * @param digit which digit do we want in our irrational number
	 * @return the value of the digit
	 */
	public int getDigit(int digit) {
		int idx = 0;
		int number = 0;
		int result = 1;
		do
		{
			// iterate through all numbers (since that is how the irrational number is defined)
			number++;
			// count the digits we already used by using log10 (which gets the number of digits in a number)
			idx+=Math.log10(number) + 1;
			// if we get there exactly just get the last digit and return the value
			if (idx == digit)
			{
				result = number % 10;
				return result;
			}
			// if we gone too far, we need to step back a few (idx-digit) digits 
			if (idx > digit)
			{
				// calculate the right digit
				result = getRightDigit(number, idx-digit);
				return result;
			}
		} while (idx < digit);
		// theoretically this is never used
		return result;
	}
	
	public int getSolution() {
		return getDigit(1) * getDigit(10) * getDigit(100) * getDigit(1000) * getDigit(10000) * getDigit(100000) * getDigit(1000000);
	}
}
