package problem_32;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Wolfgang
 * @note Calculate the sum of all products where x*y=z is a 9-pandigital number
 */public class Problem32 {

	/**
	 * @param i the multiplicand
	 * @param j the multiplier
	 * @return true if i & j & i*j is 9-pandigital
	 */
	public boolean isPanDigital(int i, int j) {
		// calculate the product 
		int mult = i * j;
		// String is too slow, so use StringBuilder
		StringBuilder s =  new StringBuilder();
		// make the string i&j&i*j
		s.append(i).append(j).append(mult);

		// check if string is other than 9 characters long and check for containing zeroes
		if (s.length() != 9 || s.indexOf("0") != -1)
			return false;

		// convert the digits of the number into a set (to get only unique digits)
		HashSet<Character> set = new HashSet<Character>();
		for (int idx = 0; idx < 9; ++idx)
			set.add(s.charAt(idx));

		// now check if it's really 9 digits, otherwise it's not pandigital
		if (set.size() != 9)
			return false;
		
		return true;
	}

	/**
	 * @return the sum of the products of the pandigital numbers
	 */
	public int getSum() {
		// the result must consist of unique products only so use hashmap again
		HashSet<Integer> resultset = new HashSet<Integer>();
		// this is for the final tallying
		int result = 0;
		
		// get all the possible unique combinations to test for
		// used 2000 as upper boundary because there are no values above that
		// came back positive (but i have no mathematical proof for it)
		for (int i = 1; i < 2000; ++i)
			for (int j = i; j < 2000; ++j)
				if (isPanDigital(i,j))
					resultset.add(i*j);

		// iterate through all the results in the set and sum them up
		for (Iterator<Integer> iter = resultset.iterator(); iter.hasNext();)
			result += iter.next();
		
		return result;
	}
}
