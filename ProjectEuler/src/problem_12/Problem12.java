package problem_12;

import java.util.Map.Entry;

import utils.PrimeFactorList;

//What is the value of the first triangle number to have over five hundred divisors?
public class Problem12 {

	// iterate through all triangle numbers until we found one we like
	public int getTriangleNumberByDivisor(int divcount) {
		int i = 0, trianglenumber = 0, result = 0;
		while(true)
		{
			// get the ith trianglenumber (dont forget to increase i)
			trianglenumber = getTriangleNumber(i);
			// get the number of divisors for this number
			result = getDivisors(trianglenumber);
			// check if its enough
			if (result > divcount)
				return trianglenumber;
			// increase i and try again
			++i;
		}
	}

	// calculate the triangle numbers (arithmetic sums En (n=0..count))
	public int getTriangleNumber(int count) {
		// formula (n+1) * (n/2) 
		// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 == (1+10) * (10/2) == (11) * (5) == 55
		// 1 + 2 + 3 + 4 + 5 + 6 + 7 == (1+7) * (7/2) == (8) * (3.5) == 28
		// 1 + 2 + 3 + 4 + 5 == (1+5) * (7/2) == (8) * (3.5) == 28
		return (int)((count + 1) * (((double)count) / 2));
	}

	// get the divisor count for specified number
	public int getDivisors(int number) {
		// 0 is a special case
		if (number == 0)
			return 0;
		// If you factor a number into its prime power factors, then the total
		// number of factors is found by adding one to all the exponents and
		// multiplying those results together
		// (found on http://mathforum.org/library/drmath/view/57151.html)

		PrimeFactorList l = new PrimeFactorList(number);
		int result = 1;
		// iterate through all the results of the factor list
		for (Entry<Long, Long> e: l.entrySet())
		{
			// if there is a valid factor exponent (== value) than add 1 and multiply
			if (e.getValue() > 0)
				result *= e.getValue().intValue() + 1;
		}
		return result;
	}

}
