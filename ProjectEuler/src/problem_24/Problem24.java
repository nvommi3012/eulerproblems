package problem_24;

public class Problem24 {

	/**
	 * @param s array to be permutated
	 * @param num count of permutations to be performed
	 * @return mutated array
	 * @note this algorithm is copied from "http://en.wikipedia.org/wiki/Permutation"
	 */
	public int[] permutation(int[] s, int num) {
		// get the factorial of the size of the array
		int factorial = 1;
		for(int i = 2; i < s.length; i++)
			factorial *= i;
 
		// go over the array
		for(int index = 0; index < s.length - 1; index++)
		{
			// ??
			int offset = (num / factorial) % (s.length - index);
			// store content of the cell
			int content = s[index + offset];
			// shift all cells to the left
			for(int i = index + offset; i > index; i--)
				s[i] = s[i-1];
			// copy the stored digit to its new location
			s[index] = content;
			// ??
			factorial /= (s.length - (index + 1));
		}
		return s;
	}

	public long getPermutation(int count) {
		// array init
		int _array[] = new int[] {0,1,2,3,4,5,6,7,8,9};
		// calculate permutations
		int mutated[] = permutation(_array, count - 1);
		// convert array back to long
		long result = 0;
		for (int i: mutated)
			result = result * 10 + i;
		return result;
	}

}
