package problem_1;

import java.util.ArrayList;

// The Original Problem 1: Find the sum of all the multiples of 3 or 5 below 1000.
// Modified to accept variable Parameters
public class Problem1 {

	// Container for the multipliers used in the formula 
	public ArrayList<Integer> _multiplierList;
	
	// Constructor
	public Problem1()
	{
		// Just allocate the Array for now 
		_multiplierList = new ArrayList<Integer>();
	}
	
	// Add multipliers to the Formula
	public void addMultiplier(int i) {
		if (!_multiplierList.contains(i))
			_multiplierList.add(i);
	}

	// Calculate the sum of a 
	public int sumOf(int i) {
		int sum = 0;
		
		for (int number = 0; number < i; ++number)
		{
			for (int m: _multiplierList)
			{
				if ((number % m) == 0)
				{
					sum += number;
					break;
				}
			}
		}
		return sum;
	}

	public int countMultiplier() {
		return _multiplierList.size();
	}

}
