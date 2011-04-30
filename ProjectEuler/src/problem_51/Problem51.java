package problem_51;

import utils.ArrayList;
import utils.Digits;
import utils.IPrimes;
import utils.Permutation;
import utils.PrimesSieve;

/**
 * @author wolfgang
 * @note Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
 */
public class Problem51 {
	
	final int ORDER = 8;
	
	/**
	 * @param ordinal the length of the number the mask is for
	 * @return the mask for the ordinal
	 * @throws IndexOutOfBoundsException if ordinal doesn't match expectations
	 */
	public ArrayList<int[]> getMask(int ordinal) throws IndexOutOfBoundsException
	{
		// number must be at least 2 digit long
		if (ordinal < 2)
			throw new IndexOutOfBoundsException("Ordinal must at least be 2");
		// decrease ordinal to match array index
		ordinal -= 2;
		
		// create resulting array
		ArrayList<int[]> result = new ArrayList<int[]>();
		// create permutation object
		Permutation perm = new Permutation();
		// these are the base masks that will be permuted
		int[] mask0 = new int[] {1000000,1100000,1110000,1111000,1111100,1111110};
		int[] mask1 = new int[] {100000,110000,111000,111100,111110};
		int[] mask2 = new int[] {10000,11000,11100,11110};
		int[] mask3 = new int[] {1000,1100,1110};
		int[] mask4 = new int[] {100,110};
		int[] mask5 = new int[] {10};
		// the combination of all masks for easy access with ordinal
		int[][] mask = new int[][] {mask5, mask4, mask3, mask2, mask1, mask0};
		
		try
		{
			// now permute all masks for the given ordinal
			for (int idx = 0; idx < mask[ordinal].length; ++idx)
			{
				ArrayList<int[]> tmp = perm.permutate(mask[ordinal][idx]);
				// remove duplicate entries
				tmp.distinct();
				// add to resulting array
				result.addAll(tmp);
			}
			return result;
		} catch (Exception e)
		{
			throw new IndexOutOfBoundsException("Wrong ordinal" + ordinal + "(should be <= " + mask.length + ")");
		}
	}
	
	/**
	 * @param test number to test
	 * @param masks the mask for the number
	 * @param primes the prime generator to check for primes
	 * @param order how many generated primes are needed
	 * @return the first prime >= <test> that generates <order> primes
	 */
	long applymask(long test, ArrayList<int[]> masks, IPrimes primes, int order)
	{
		// test never changes so convert to array immediately
		int[] testa = Digits.Number((int)test);
		int fail = 0;
		int count = 0;
		long firstprime = 0L;
		long l = 0L;

		// first iterate through all masks
		for (int[] mask: masks)
		{
			// reinit the counters for each mask loop
			fail = 0;
			count = 0;
			firstprime = 0;
			
			// do not use last digit since that would make the number non-prime
			if (mask[mask.length -1] == 1)
				continue;

			// now iterate through all single digit numbers
			for (int number = 0; number <= 9; ++number)
			{
				l = 0;
				// looking at the result it seems that 100109 is not a valid result,
				// which indicates that the most significant digit must not be zero
				// so we skip all masks that have the most significant digit set and number equals zero
				if (mask[0] == 1 && number == 0)
					continue;
				
				// now generate the number by applying the mask to the test-array
				for (int idx = mask.length - 1; idx >= 0; --idx)
				{
					if (mask[idx] == 0)
						l += testa[idx] * Math.pow(10, mask.length-idx-1);
					else
						l += number * Math.pow(10, mask.length-idx-1);
				}

				// check the generated number for primeness
				if (false == primes.isPrime(l))
					++fail;	// fail counter to quit early
				else
				{
					// this is to remember the first prime (it's possible that test is not the correct number (depending on the mask))
					if (firstprime == 0L)
						firstprime = l;
					++count;
				}
				// check fail count, if there are more fails than would be allowed quit this mask
				if (fail > (10 - order))
					break;
			}
			// check the result against the wanted result
			if (count >= order)
				return firstprime;
		}
		return 0L;
	}
	
	/**
	 * @return the smallest prime that generates 8 primes
	 * @throws Exception if no solution can be found
	 */
	public long getSolution() throws Exception {
		// pregenerate the primes
		IPrimes primes = new PrimesSieve(200000);
		// mask object not yet created
		ArrayList<int[]> mask = null;
		
		// there is probably a bigger start number that can be proven to work than 100
		for (long test = 100; test < Long.MAX_VALUE;)
		{
			// get the next prime
			try {test = primes.generatePrime(test);} catch(Exception ex) {break;}
			// get the digits of the prime to get the correct mask
			int log = (int) Math.log10(test) + 1;
			// get the mask
			mask = getMask(log);
			// check the number
			long result = applymask(test, mask, primes, ORDER);
			// if the result is a number != 0 the algorithm returned something valid
			if (result > 0) 
				return result;
		}
		throw new Exception("No solution could be found");
	}
	
}
