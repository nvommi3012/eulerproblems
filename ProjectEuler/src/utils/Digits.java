package utils;

/**
 * @author Wolfgang
 * @note converts a number to its individual digits and vice versa
 */
public class Digits {

	/**
	 * @param number number to convert to digits
	 * @return array of digits
	 */
	public static int[] Number(long number) {
		// use logarithm base10 to get the number of digits
		int count = (int)Math.log10(number) + 1;
		int[] result = new int[count];
		
		// get the last digit of the number and shift right (by one digit)
		for (int i = count - 1; i >= 0; --i)
		{
			result[i] = (int)(number % 10);
			number /= 10;
		}
		return result;
	}

	/**
	 * @param array digits to convert to number
	 * @return number corresponding to digits
	 */
	public static long Array(int[] array) {
		long result = 0;
		
		// go through each entry in the array and calculate the number
		for (int idx = 0; idx < array.length; ++idx)
		{
			result *= 10;
			result += array[idx];
		}
		return result;
	}
}
