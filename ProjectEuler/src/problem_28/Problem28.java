package problem_28;

/**
 * @author Wolfgang
 * @note What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class Problem28 {

	/**
	 * @param lvl specifies the level for which to calculate the diagonale sum
	 * @return the sum of the 4 diagonale values for the level
	 * @note could be performance enhanced by seeding with the last startvalue, since we are calculating the sum of everything, so there is no need to run the whole loop every time
	 */
	private int getLevelSum(int lvl)
	{
		// the innermost level is always 1
		if (lvl <= 1)
			return 1;

		int result = 1;
		int start = 1;

		// this calculation starts at the 2nd level and
		// works itself through to the specified level
		// all results except the last are disregarded
		for (int count = 1; count < lvl; ++count)
		{
			// i need to calculate the start diagonale (which is the lowest of the 4 values)
			int step = count * 2;
			start += step;
			// this is important: we only need the result values from the last iteration
			result = start;
			// then i add the 3 other diagonale values
			for (int diag = 0; diag < 3; ++diag)
			{
				start += step;
				result += start;
			}
		}
		return result;
	}
	
	/**
	 * @param size the size of the "spiral"
	 * @return the sum of all diagonale values
	 */
	public int getDiagonaleSum(int size)
	{
		// recalc size to fit the input parameters from the problem
		size = size / 2 + 1;
		int result = 0;
		// calc sum of each level until size
		for (int i = 1; i <= size; ++i)
			result += getLevelSum(i);
		return result;
	}
}
