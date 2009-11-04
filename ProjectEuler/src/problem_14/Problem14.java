package problem_14;

//Which starting number, under one million, produces the longest chain? (Collatz problem)
public class Problem14 {

	// memory to store the most important chains
	int _chains[];
	
	// constructor to init the storage
	public Problem14()
	{
		_chains = new int[1000001];
	}

	// calculate the chain
	public int generateCollatzChain(int orig) {
		int count = 1;	// start off with 1 because we need to count the starting element too
		long i = orig;	// long is needed for calculation, obviously the numbers get larger than MAXINT
		
		// if i ever gets to 1 the chain is done
		while (i != 1)
		{
			// new element in the chain, so add one to our counter
			++count;

			// rule is: divide even numbers by 2 and multiply uneven numbers by 3 and add 1
			if (i % 2 == 0)
				i = i / 2;
			else
				i = i * 3 + 1;
			
			// check if we already got a result for that number
			if (i < _chains.length && _chains[(int)i] > 0)
			{
				// if we have this number we only need to add the
				// chain count so far and put it in storage
				_chains[orig] = _chains[(int)i] + count;
				return _chains[orig];
			}
		}
		// new chain, store it
		_chains[orig] = count;
		return count;
	}

	// brute force to get the maximum chain length
	public int generateLongestChain() {
		int result = 0;
		int maxchain = 0;
		int chain = 0;
		
		// iterate through all possible chains
		for (int i = 2; i < 1000000; ++i)
		{
			chain = generateCollatzChain(i);
			// if this chain is larger than what we already have store this
			if (chain > maxchain)
			{
				maxchain = chain;
				result = i;
			}
		}
		//System.err.println("Result = " + result + " (" + maxchain + ")");
		return result;
	}
}
