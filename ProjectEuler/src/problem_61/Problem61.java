package problem_61;

import utils.ArrayList;

/**
* @author wolfgang
* @note Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type: triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, is represented by a different number in the set.
*/
public class Problem61 {

/*
	Triangle           P_(3,n)=n(n+1)/2          1, 3, 6, 10, 15, ...
	Square             P_(4,n)=n^(2)             1, 4, 9, 16, 25, ...
	Pentagonal         P_(5,n)=n(3n−1)/2         1, 5, 12, 22, 35, ...
	Hexagonal          P_(6,n)=n(2n−1)           1, 6, 15, 28, 45, ...
	Heptagonal         P_(7,n)=n(5n−3)/2         1, 7, 18, 34, 55, ...
	Octagonal          P_(8,n)=n(3n−2)           1, 8, 21, 40, 65, ...
*/
   
	/**
	 * @author wolfgang
	 * @note this interface is used to calculate P(n) for all x-agonal algorithms
	 */
	interface P
	{
		int f(int n);
	}
	class P3 implements P
	{
		@Override
		public int f(int n) {
			return n * (n + 1) / 2;
		}
	}
	class P4 implements P
	{
		@Override
		public int f(int n) {
			return n * n;
		}
	}
	class P5 implements P
	{
		@Override
		public int f(int n) {
			return n * (3*n - 1) / 2;
		}
	}
	class P6 implements P
	{
		@Override
		public int f(int n) {
			return n * (2*n - 1);
		}
	}
	class P7 implements P
	{
		@Override
		public int f(int n) {
			return n * (5*n - 3) / 2;
		}
	}
	class P8 implements P
	{
		@Override
		public int f(int n) {
			return n * (3*n - 2);
		}
	}
	
	// storage for all the x-agonal numbers
	ArrayList<ArrayList<Integer>> _store;
	
	/**
	 * Ctor, create the x-agonal numbers
	 */
	public Problem61()
	{
		createStore();
	}
	
	/**
	 * create the columns of x-agonal numbers 
	 */
	void createStore()
	{
		// use an array for the calculation objects for easy access per indices
		P[] pfn = new P[6];
		pfn[0] = new P3();
		pfn[1] = new P4();
		pfn[2] = new P5();
		pfn[3] = new P6();
		pfn[4] = new P7();
		pfn[5] = new P8();

		// create the main storage object
		_store = new ArrayList<ArrayList<Integer>>();
		
		// iterate through all calculation objects
		for (int i = 0; i < pfn.length; ++i)
		{
			// for each calculation object create a column
			_store.add(new ArrayList<Integer>());
			// now add all numbers from 1010 to 9999 that are calculated by the x-agonal functions
			for(int x = 0, n = 1;;++n)
			{
				x = pfn[i].f(n);
				if (x < 1010)
					continue;
				if (x > 10000)
					break;
				_store.get(i).add(x);
			}
		}
	}
	
	/**
	 * @param seed the number from the last iteration to start the new iteration
	 * @param exclusion array of indices not to be looked through
	 * @param result the temporary result list
	 * @return the final result list
	 */
	ArrayList<Integer> recurse(int seed, ArrayList<Integer> exclusion, ArrayList<Integer> result)
	{
		// the upper and lower limits are calculated by the last 2 digits of the seed
		// for example the seed is 7766 then all numbers from 6610 to 6699 are valid for this iteration
		int lower = (seed % 100) * 100 + 10;
		int upper = lower + 90;

		// check if there are enough results already in the list
		// result count must be exactly the number of possible columns
		if (result.size() == _store.size())
		{
			// check if the first and last numbers are still cyclic
			if ((result.get(0) / 100) == result.get(5) % 100)
				return result;
		}

		// iterate through all columns
		for (int i = 0; i < _store.size(); ++i)
		{
			// but do not look in excluded columns
			if (exclusion.contains(i))
				continue;
			
			// iterate through all numbers in the selected column
			ArrayList<Integer> a = _store.get(i);
			for (int x: a)
			{
				// if the number does not fit the boundaries skip it or break out to the next column
				if (x < lower)
					continue;
				if (x >= upper)
					break;

				// generate a temporary exclusion list for the next recursion
				ArrayList<Integer> ex2 = new ArrayList<Integer>();
				ex2.addAll(exclusion);
				ex2.add(i);
				
				// also a new temporary result list
				ArrayList<Integer> tmpresult = new ArrayList<Integer>();
				tmpresult.addAll(result);
				tmpresult.add(x);
				// add one level to the recursion
				tmpresult = recurse(x, ex2, tmpresult);
				// if the result is already final return immediately
				if (tmpresult != null)
					return tmpresult;
			}
		}
		// this indicates that this recursion did not find a fitting result
		return null;
	}
	
	/**
	 * @return the sum of the cyclic numbers
	 * @throws Exception if no solution can be found
	 */
	public int getSolution() throws Exception
	{
		final int PRIMARY_COLUMN = 0;
		// since all numbers must be cyclic anyway, just start at index zero
		ArrayList<Integer> start = _store.get(PRIMARY_COLUMN);
		// use exclusions to keep from checking endlessly against itself
		ArrayList<Integer> exclusion = new ArrayList<Integer>();
		// add the same column to the exclusions that are used to iterate through
		exclusion.add(PRIMARY_COLUMN);
		
		// iterate through all Triangle numbers
		for (int i: start)
		{
			// this is used to store temporary result lists
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(i);
			// use recursion to build up result lists until one matches
			ArrayList<Integer> ra = recurse(i, exclusion, tmp);
			// any result <> null is a valid result
			if (ra != null)
			{
				// just sum it up and return the resulting sum
				int result = 0;
				for (int x: ra)
					result += x;
				return result;
			}
		}
		throw new Exception("no solution found");
	}
}


