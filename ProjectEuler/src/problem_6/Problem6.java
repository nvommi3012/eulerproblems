package problem_6;

// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
public class Problem6 {

	// calculate the squared sums
	private long getSquaredSum(long count)
	{
		long squaredsum = 0;
		for (int i = 1; i <= count; ++i)
			squaredsum += i * i;
		return squaredsum;
	}
	// calculate the sum of the squares
	private long getSumSquared(long count)
	{
		long sum = 0;
		for (int i = 1; i <= count; ++i)
			sum += i;
		return sum * sum;
	}
	
	// get the difference between the sum of squares and the squares of the sum
	public long getSquaresDifference(long count) {
		return getSumSquared(count) - getSquaredSum(count);
	}

}
