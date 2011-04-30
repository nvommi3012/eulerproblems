package problem_49;

import java.util.ArrayList;

import utils.Digits;
import utils.IPrimes;
import utils.Permutation;
import utils.PrimesSieve;

/**
 * @author Wolfgang
 * @note What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Problem49 {
	/**
	 * @return the number consisting of 3 4 digit primes which are permutations of themselves and 3330 apart
	 * @throws Exception if no solution was found
	 */
	public long getSolution() throws Exception {
		// array to check which permutations were already done
		boolean done[] = new boolean[10000];
		// pregenerated prime checker
		IPrimes primes = new PrimesSieve(10000);
		// permutation object
		Permutation permutation = new Permutation();
		// result as string
		String result = "";
		
		// this is not the valid result
		done[1487] = true;
		
		// 4 digit permutation means no zero, so start at 1111
		for (int i = 1111; i < 9999; ++i)
		{
			// if already checked go to next one
			if (done[i])
				continue;
			
			// only interested if prime
			if (primes.isPrime(i))
			{
				// get all the permutations of i
				ArrayList<int[]> plist = permutation.permutate(i);
				// i is its own prime, so start counting at 1
				int primecount = 1;
				result = "";
				// now go through all iterations
				for (int j = 0; j < plist.size(); ++j)
				{
					// convert int[] back to number
					int perm = (int)Digits.Array(plist.get(j));
					// check if permuation is also prime
					if (primes.isPrime(perm))
					{
						// now check if the distance is 3330 between each prime
						if (i + 3330 * primecount != perm)
							continue;
						// if all requirements are met add result string and increase count
						++primecount;
						result += String.valueOf(perm);
					}
					// check done
					done[perm] = true;
				}
				// if exactly 3 primes meet the requirements return result 
				if (primecount == 3)
				{
					result = String.valueOf(i) + result;
					return Long.parseLong(result);
				}
			}
		}
		throw new Exception("Solution not found");
	}
}
