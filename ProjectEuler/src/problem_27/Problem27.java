package problem_27;

import utils.PrimeCheck;

/**
 * @author Wolfgang
 * note Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
 */
public class Problem27 {

	private static final int MAX_BOUNDARY = 999;
	private static final int MIN_BOUNDARY = -999;
	/**
	 * @note Primechecker object stores all primes for easy calculations 
	 */
	private PrimeCheck _pc;

	/**
	 * Constructor 
	 */
	public Problem27()
	{
		_pc = new PrimeCheck();
	}
	
	/**
	 * @param N 
	 * @param A
	 * @param B
	 * @return result of the calculation n^2 + na + b
	 */
	private int calcFormula(int N, int A, int B)
	{
		return N*N + N*A + B;
	}
	
	/**
	 * @return the product of the coefficients of the quadratic formula yielding the most consecutive primes
	 */
	public int getMaxProduct() {
		int result = 0;
		int max = 0;
		for (int A = MIN_BOUNDARY; A <= MAX_BOUNDARY; ++A)
		{
			for (int B = MIN_BOUNDARY; B <= MAX_BOUNDARY; ++B)
			{
				int tmp = getPrimesCountForAB(A, B);
				if (tmp > max)
				{
					result = A * B;
					max = tmp;
				}
			}
		}
		
		return result;
	}

	/**
	 * @param A
	 * @param B
	 * @return the number of consecutive primes for this combination of A and B
	 */
	public int getPrimesCountForAB(int A, int B) {
		int count = 0;
		int test = calcFormula(count, A, B);
		
		while (_pc.isPrime(test))
			test = calcFormula(++count, A, B);
			
		return count;
	}

}
