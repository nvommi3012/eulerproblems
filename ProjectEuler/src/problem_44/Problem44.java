package problem_44;

import java.util.TreeSet;

/**
 * @author Wolfgang
 * @note Find the pair of pentagonal numbers, P_(j) and P_(k), for which their sum and difference is pentagonal and D = |P_(k) − P_(j)| is minimised; what is the value of D?
 */
public class Problem44 {

	/**
	 * @param n
	 * @return P(n) = n*(n*3-1)/2
	 */
	public int getPentNumber(int n) {
		// this is the formula given
		int result = n * (n * 3 - 1) / 2;
		return result;
	}

	/**
	 * @return the minimized value of P(j) - P(k)
	 */
	public int getSolution() {
		// set maximum to test the results against
		int result = Integer.MAX_VALUE;
		// P(n) starts with 1
		int i = 1;
		// store the pentagonal numbers in a tree for easy and quick searching
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		// fill the tree with the first 10 million numbers
		int number = getPentNumber(i);
		while (number < 10000000)
		{
			tree.add(number);
			++i;
			number = getPentNumber(i);
		}

		// for optimized traversal of the tree get a ordered array with all entries in the tree
		Integer[] array = new Integer[tree.size()];
		array = tree.toArray(array);
		
		// check every pentagonal number against every other
		for (int j = 0; j < array.length; ++j)
		{
			for (int k = j; k < array.length; ++k)
			{
				// check if |P(j) - P(k)| and P(j) + P(k) are also pentagonal numbers 
				int sub = Math.abs(array[j] - array[k]);
				int add = array[j] + array[k];

				if (tree.contains(sub) && tree.contains(add))
				{
					// if both are pentagonal check against previous maximum, and store new value if less than previous
					if (result > Math.abs(array[j] + array[k]))
						result = Math.abs(array[j] - array[k]);
				}
			}
		}
		return result;
	}
}
