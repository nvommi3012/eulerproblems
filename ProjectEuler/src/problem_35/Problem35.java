package problem_35;

import java.util.ArrayList;
import java.util.Iterator;

import utils.Digits;
import utils.PrimeCheck;
import utils.PrimeGenerator;

/**
 * @author Wolfgang
 * @note get the count of all circular primes < 1000000
 */
public class Problem35 {

	// prime number generator and checker
	private PrimeGenerator _gen;
	private PrimeCheck _checker;
	private final int MAX = 1000000;
	
	/**
	 * Constructor, inits the prime generator and checker 
	 */
	public Problem35()
	{
		_gen = new PrimeGenerator();
		// *note* take advantage of the new version of the primechecker (gained ~80% over previous version)
		_checker = new PrimeCheck(MAX);
	}
	
	/**
	 * @param array array to rotate
	 * @return list of all possible rotations
	 */
	public ArrayList<int[]> rotate(int[] array)
	{
		ArrayList<int[]> result = new ArrayList<int[]>();

		// just copy the first item on the last and rotate the rest.
		// clone each result and add to the array
		for (int i = 0; i < array.length; ++i)
		{
			int tmp = array[0];
			// *NOTE* for a performance boost check if a digit is divisible by 2, if that is the case the number can not be circular prime
			// in that case return an empty result set
			for (int j = 0; j < array.length - 1; ++j)
				array[j] = array[j + 1];
			array[array.length-1] = tmp;
			result.add(array.clone());
		}
		return result;
	}
	
	
	/**
	 * @param i number to check
	 * @return true if circular
	 */
	public boolean isCircular(long i) {
		// get all rotations of the array and check each of primeness
		ArrayList<int[]> rotations = rotate(Digits.Number((int) i));
		Iterator<int[]> iterator = rotations.iterator();
		int[] array;
		int number;
		
		while (iterator.hasNext())
		{
			array = iterator.next();
			number = Digits.Array(array);
			// if a rotation is not prime it is not circular
			if (false == _checker.isPrime(number))
				return false;
		}
		return true;
	}

	/**
	 * @return count of all circular primes < 1.000.000
	 */
	public int getSolution() {
		long prime = 0;
		int result = 0;
		
		// get prime first, then on end of loop to leave the loop before MAX is reached
		prime = _gen.getNextPrime();
		do {
			if (isCircular(prime))
				++result;
			prime = _gen.getNextPrime();
		} while (prime < MAX);
		return result;
	}

}
