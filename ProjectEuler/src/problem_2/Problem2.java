package problem_2;

// Find the sum of all the even-valued terms in the sequence which do not exceed four million.
public class Problem2 {

	// recursive fibonacci algorithm for a specific fibonacci count
	public int fibonacci(int count) {
		int f = 0;
		
		// terminating fibonacci sequence if nothing else is to be calculated
		if (count < 2)
			f = 1;
		else
			f = fibonacci(count - 1) + fibonacci(count - 2);
		return f;
	}

	// problem specific calculation
	public int calculate(int max) {
		int sum = 0;
		int count = 1;
		
		while (true)
		{
			int fib;
			
			// only take even values and add to a sum. stop before reaching max
			fib = fibonacci(count);
			if ((fib % 2) == 0 && (fib < max))
				sum += fib;
			else if (fib >= max)
				return sum;
			
			++count;
		}
	}
}
