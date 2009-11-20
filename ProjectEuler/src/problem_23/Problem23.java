package problem_23;

import utils.FactorList;

/**
 * @author Wolfgang
 * @note Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Problem23 {

	private final int MAX = 28123;	// proven to be the highest number not the sum of 2 abundant ints
	private boolean _abundants[];	// array of all abundant ints (true if index number is abundant)
	
	/**
	 *	Constructor to allocate and initialize all the abundant numbers 
	 */
	public Problem23()
	{
		_abundants = new boolean[MAX + 1];
		getAllAbundants();
	}
	
	/**
	 *	calculate all abundant numbers to MAX 
	 */
	private void getAllAbundants()
	{
		// set the array at the index true if the number is abundant or false otherwise
		for (int i = 0; i <= MAX; ++i)
			if (isAbundantNumber(i))
				_abundants[i] = true;
			else
				_abundants[i] = false;
	}

	/**
	 * @param number number to be checked
	 * @return true if sums of all factors is greater than the number itself
	 */
	public boolean isAbundantNumber(int number)
	{
		int result = 0;
		// get all the factors (excluding the number itself, but including 1)
		FactorList l = new FactorList(number);
		// aggregate all factors
		for (long i: l)
			result += i;
		// check if sum is greater than the number itself
		if (result > number)
			return true;
		return false;
	}
	
	/**
	 * @return sum of all ints that are not sums of abundants
	 */
	public int getAbundantSum() {
		int result = 0;
		// store all ints that are sums of 2 abundant ints
		boolean sums[] = new boolean[MAX + 1];
		
		// since it is established that no int > MAX is the sum of 2 abundant ints we
		// need only check to MAX
		for (int i = 1; i < MAX; ++i)
		{
			// if the number is not abundant we are not interested
			if (false == _abundants[i])
				continue;
			
			// there is probably a more efficient way to eliminate duplicate checks
			// but this it the most performant i could think of
			// since "i" is iterating through all ints anyway, it's not neccessary
			// to have "j" iterate through all of them too
			for (int j = i; j < MAX; ++j)
			{
				// if "j" is not abundant we are not interested
				if (false == _abundants[j])
					continue;
				
				// if the sum is already greater than max skip this iteration
				if (i + j > MAX)
					break;

				// store the result
				sums[i + j] = true;
			}
		}
		
		// since "sums" stores all the valid abundant sums we only need to
		// add the non valid ones to get the result
		for (int i = 0; i < MAX; ++i)
			if (false == sums[i])
				result += i;
		
		return result;
	}
}
