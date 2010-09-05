package problem_68;

import utils.ArrayList;
import utils.Permutation;
import utils.SolutionNotFoundException;

/**
 * @author Wolfgang
 * @note What is the maximum 16-digit string for a "magic" 5-gon ring?
 */
public class Problem68 {

	/**
	 * @param a array to sum up
	 * @return the sum of the numbers in the array
	 */
	int sum(int[] a)
	{
		int result = 0;
		for (int i: a)
			result += i;
		return result;
	}
	
	/**
	 * @param a array to check
	 * @return true if all arrays in <a> have the same sum of their digits
	 */
	boolean isEqual(int[][] a)
	{
		for (int x = 0; x < a.length - 1; ++x)
		{
			if (sum(a[x]) != sum(a[x+1]))
				return false;
		}
		return true;
	}
	
	/**
	 * @param a arrays to convert to a single long value
	 * @return the number representing the arrays
	 */
	long getLongNumber(int[][] a)
	{
		long result = 0;
		for (int x = 0; x < a.length; ++x)
		{
			for (int y = 0; y < a[x].length; ++y)
			{
				// make a special case for 10, since that needs to be inserted into long as it is
				if (a[x][y] == 10)
					result = result * 100 + 10;
				else
					result = result*10 + a[x][y];
			}
		}
		return result;
	}
	
	/**
	 * @return the maximum 16-digit string of the 5-gon ring
	 * @throws Exception 
	 */
	public long getSolution() throws SolutionNotFoundException {
		// the problem states that the 5 numbers start with the outer ring, and that the least
		// of those numbers is to be chosen as a starting point. that leaves only 6 as the starting number, as
		// all large numbers are needed in the outer ring (10 wouldnt work, since 2 inner numbers are needed
		// in the sequence).

		// so define 1-5 as the inner ring
		int[] set1 = {1,2,3,4,5};
		// and define 6-10 as the outer ring (but since 6 is known to be at the start leave it out of the set)
		int[] set2 = {7,8,9,10};
		long result = 0L;
		Permutation p = new Permutation();
		
		// permutate all members of the inner and outer ring
		ArrayList<int[]> P1 = p.permutate(set1);
		ArrayList<int[]> P2 = p.permutate(set2);
	
		// now loop through both rings and build the 5 numbers that are needed to check
		for (int i = 0; i < P1.size(); ++i)
		{
			for (int j = 0; j < P2.size(); ++j)
			{
				int[][] S = new int[5][3];
				
				// the 5 numbers are build to the following specifications:
				// start at the outerring, and add 2 numbers of the inner ring (that form a line)
				// given the graphic of the pentagon ring it is obvious that these
				// are the possible combinations of positions.
				// what is left is the combination of numbers, and the loop over the permutations takes care of that
				S[0] = new int[]{6, P1.get(i)[0], P1.get(i)[1]};
				S[1] = new int[]{P2.get(j)[0], P1.get(i)[1], P1.get(i)[2]};
				S[2] = new int[]{P2.get(j)[1], P1.get(i)[2], P1.get(i)[3]};
				S[3] = new int[]{P2.get(j)[2], P1.get(i)[3], P1.get(i)[4]};
				S[4] = new int[]{P2.get(j)[3], P1.get(i)[4], P1.get(i)[0]};
				
				// another specification is that all 5 numbers share the same sum of its "digits"
				if (isEqual(S))
				{
					// if there is such a number, the maximum of those numbers is needed
					if (getLongNumber(S) > result)
						result = getLongNumber(S);
				}
			}
		}
		if (result == 0)
			throw new SolutionNotFoundException(Problem68.class);
		return result;
	}
}
