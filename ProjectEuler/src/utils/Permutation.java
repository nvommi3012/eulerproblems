package utils;

import java.util.ArrayList;

/**
 * @author Wolfgang
 * @note Class to permutate an integer array
 */
public class Permutation {

	// storage for the result list (used ArrayList for dynamical growth) 
	private ArrayList<int[]> _result;
	
	/**
	 * Constructor, not doing anything important 
	 */
	public Permutation()
	{
		_result = null;
	}
	
	/**
	 * @param array	working set
	 * @param i index to swap from
	 * @param j index to swap to
	 */
	private void swap(int[] array, int i, int j)
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		
	}
	
	/**
	 * @param array working set
	 * @param n index (max length of array for 1st iteration)
	 */
	private void _perm(int[] array, int n)
	{
		// went through all iterations?
		if (n == 1)
		{
			//System.out.println("return " + array[0]+array[1]);
			_result.add(array.clone());
			return;
		}
        
		// using Dijkstra algorithm / recursion
		for (int i = 0; i < n; i++)
        {
            swap(array, i, n-1);
            _perm(array, n-1);
            swap(array, i, n-1);
        }
	}
	
	/**
	 * @param input integer to permutate
	 * @return list of all permutations
	 */
	public ArrayList<int[]> permutate(int input)
	{
		_result = new ArrayList<int[]>();
		int[] digits = Digits.Number(input);
		_perm(digits, digits.length);
		return _result;
	}

	/**
	 * @param input input array to permutate
	 * @return list of all permutations
	 */
	public ArrayList<int[]> permutate(int[] input)
	{
		_result = new ArrayList<int[]>();
		_perm(input, input.length);
		return _result;
	}
	
}
