package problem_33;

import utils.PrimeFactorList;

/**
 * @author Wolfgang
 * @note find the value of the denominator of the exactly four non-trivial curious fractions less than one in value, and containing two digits in the numerator and denominator
 */
public class Problem33 {

	/**
	 * @param i numerator
	 * @param j denominator
	 * @return true if it is a "curious" fraction
	 */
	public boolean check(int i, int j) {
	
		// paranoia check
		if (i < 10 || j < 10)
			return false;
		
		// check to see if the digits match so we can eliminate them
		int numerator = i % 10;
		int denominator = j / 10;
		if (numerator != denominator)
			return false;
		
		// now calculate the "larger" fraction
		double fraction1 = (double)i / (double)j, fraction2 = 0;
		// must be smaller than one
		if (fraction1 >= 1)
			return false;
		// and must not be trivial (i.e. not divisible by 10)
		if (i % 10 == 0 && j % 10 == 0)
			return false;
		
		// now the fraction with the eliminated digits
		fraction2 = (double)(i / 10) / (double)(j % 10);
		
		if (fraction1 == fraction2)
			return true;
		return false;
	}

	/**
	 * @return the denominator of the product of the fractions
	 */
	public int getSolution() {
		
		int result1 = 1;
		int result2 = 1;

		// check all 2-digit numbers, when divided are less than 1
		for (int i = 11; i < 98; ++i)
			for (int j = 11; j < 99; ++j)
				if (check(i, j))
				{
					// calculate the product of the fractions
					result1 *= i;
					result2 *= j;
				}

		// use prime factorization to get to the smallest denominator
		PrimeFactorList p1 = new PrimeFactorList(result1);
		PrimeFactorList p2 = new PrimeFactorList(result2);
		PrimeFactorList result = PrimeFactorList.differFactorLists(p1, p2);
		return (int)result.calculateValue();
	}
}
