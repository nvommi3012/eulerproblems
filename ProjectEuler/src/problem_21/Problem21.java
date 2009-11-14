package problem_21;

import java.util.ArrayList;

/**
 * @author Wolfgang
 * @note Evaluate the sum of all the amicable numbers under 10000
 */
public class Problem21 {

	/**
	 * @param max the maximum to count to
	 * @return the sum of all the amicable numbers less than max
	 */
	public int getAmicableNumberSum(int max) {
		int result = 0;
		for (int i = 1; i < max; ++i)
		{
			// get the divisor sum for i
			int a = getDivisorSum(i);
			// get the divisor sum for the divisor sum of i
			int b = getDivisorSum(a);
			// if b equals the original number and both divisor sums are not equal too
			// this is an amicable number (see the problem text for details)
			if (b == i && a != b)
				result += a;
		}
		return result;
	}

	/**
	 * @param number number to calculate the divisors of
	 * @return sum of the divisors
	 */
	public int getDivisorSum(int number) {
		ArrayList<Integer> list = getFactorList(number);
		int sum = sumUpList(list);
		return sum;
	}

	/**
	 * @param list list of divisors to sum up
	 * @return the sum of the list entries
	 */
	private int sumUpList(ArrayList<Integer> list)
	{
		int result = 0;
		for (int i: list)
			result += i;
		return result;
	}
	
	/**
	 * @param number number to factorize
	 * @return list of all factors (including 1, but not itself)
	 */
	private ArrayList<Integer> getFactorList(int number)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		// start at 1 (since it is required, and go to the maximum of number/2
		// (no more proper divisions possible for n > number/2)
		for (int i = 1; i <= number / 2; ++i)
			if (number % i == 0)
				result.add(i);
		return result;
	}
	
}
