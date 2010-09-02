package problem_5;

import utils.PrimeFactorList;

// What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?
public class Problem5 {

	// get the least common multiple on a sequence of numbers from 1 to "count"
	public static long getSmallestDivider(int count) {
		
		PrimeFactorList numbers[];

		// since we use prime factorization we need to get the "count" result sets
		numbers = new PrimeFactorList[20];
		for (int i = 0; i < count; ++i)
			numbers[i] = new PrimeFactorList(i + 1);

		// now combine the results from the individual results in a single result
		PrimeFactorList result = new PrimeFactorList(0);
		result = PrimeFactorList.lowestCommonMultiple(numbers);

		// the least common multiple can be calculated from that result
		long kgv = result.calculateValue();
		
		return kgv;
	}
}
