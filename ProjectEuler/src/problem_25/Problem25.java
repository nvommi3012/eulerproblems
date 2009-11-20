package problem_25;

import java.math.BigInteger;

/**
 * @author Wolfgang
 * @note What is the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem25 {

	/**
	 * @param digits defines how many digits the fibonacci sequence should contain
	 * @return number of iterations through the fibonacci sequence
	 */
	private int fibo(int digits)
	{
		// fibonacci starts with 1 + 1
		BigInteger f1 = BigInteger.ONE;
		BigInteger f2 = BigInteger.ONE;
		// we already defined the first 2 elements
		int count = 2;
		
		for (;;)
		{
			// next iteration
			++count;
			// alternately add to f1 or f2
			if (count % 2 == 0)
			{
				f1 = f1.add(f2);
				// check termination criteria
				if (f1.toString().length() >= digits)
					return count;
			}
			else
			{
				f2 = f2.add(f1);
				// check termination criteria
				if (f2.toString().length() >= digits)
					return count;
			}
		}
	}
	
	/**
	 * @param digits defines how many digits the fibonacci sequence should contain
	 * @return number of iterations through the fibonacci sequence
	 */
	public int getFibonacciDigits(int digits) {
		return fibo(digits);
	}

}
