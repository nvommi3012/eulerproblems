package problem_7;

import utils.PrimeGenerator;

// What is the 10001^(st) prime number?
public class Problem7 {

	public long getPrime(int max) {
		long result = 0;
		PrimeGenerator p = new PrimeGenerator();
		for (int count = 0; count < max; ++count)
			result = p.getNextPrime();
		return result;
//		return p.getPrime(max);
	}
	
}
