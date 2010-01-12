package problem_31;

/**
 * @author Wolfgang
 * @note How many different ways can £2 be made using any number of coins?
 */
public class Problem31 {

	// different coins and their values
	static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
	// the resulting sum of coins we want
	final int RESULT = 200;

	/**
	 * @param denomination the value of the coin we want to add
	 * @param amount the amount we already have added up to
	 * @return the number of possibilities we calculated
	 * @note this recursion calls itself with all possible denominations smaller than the original denomination
	 */
	private int getPossibles(int denomination, int amount)
	{
		int possibilities = 0;
		while (true)
		{
			// check for values greater than the desired result and switch to lower denomination if possible
			if (amount + coins[denomination] > RESULT && denomination >= 1)
				return possibilities + getPossibles(denomination - 1, amount);
			
			// now switch to lower denomination and fill that up 
			if (denomination >= 1)
				possibilities += getPossibles(denomination - 1, amount);

			// if we get the desired outcome we return all previous possibilities plus this one
			if (amount + coins[denomination] == RESULT)
				return possibilities + 1;

			// add one of the current denomination to the amount and continue
			if (amount + coins[denomination] < RESULT)
				amount += coins[denomination];
		}
	}
	
	public int getPossibleCombinations() {
		// we start with the biggest denominator possible and zero amount
		return getPossibles(coins.length - 1, 0);
	}
}
