package problem_66;

import java.math.BigInteger;
import utils.ContinuedFraction;
import utils.Fraction;

/**
 * @author Wolfgang
 * @note Find the value of D <= 1000 in minimal solutions of x for which the largest value of x is obtained.
 */
public class Problem66 {
	/**
	 * constant for the maximum of D specified in the problem
	 */
	final int MAX_D = 1000;
	
	/**
	 * @param D the value of D in x^2 - Dy^2 = 1
	 * @return the minimum of x and y that match the equation
	 * @throws IllegalArgumentException if D was invalid (must not be a perfect square)
	 */
	Fraction findMin(int D) throws IllegalArgumentException
	{
		// quadratic equations in the form of x^2 - Dy^2 = 1 are called 
		// Pell Equations. see http://mathworld.wolfram.com/PellEquation.html
		// the minimum solution for such equations are calculated by
		// the convergents of the root of D

		// calculate the continued fraction for sqr(D) 
		ContinuedFraction cf;
		try {
			cf = ContinuedFraction.fromSquare(D);
		} catch (Exception e) {
			throw new IllegalArgumentException("no result for " +D);
		}
		
		// there is no solution for d^2 (e.g. 4,9,16,...) which is represented by the fraction with no periodical
		if (cf.periodSize() == 1)
			throw new IllegalArgumentException("no solution for d^2");

		// the solution is split up, depending on the size (even, odd) of the periodical
		int psize = cf.periodSize() - 1;
		if (psize % 2 == 1)
			// this should be 2r+1 but that doesn't match with the periodicals :(
			return cf.getConvergent(2 * psize - 1);
		else
			return cf.getConvergent(psize - 1);
	}
	
	/**
	 * @return the maximum of the minimums
	 */
	public int getSolution() {
		// store max D here
		int result = 0;
		// use this to compare x (the numerators)
		BigInteger max = BigInteger.ZERO;
		// iterate through all Ds
		for (int D = 1; D <= MAX_D; ++D)
		{
			try
			{
				// find the correct convergent fraction
				Fraction f = findMin(D);
				// check the numerator for new maximum
				if (max.compareTo(f.numerator()) < 0)
				{
					result = D;
					max = f.numerator();
				}
			}
			catch (IllegalArgumentException ex) {}
		}
		return result;
	}
}
