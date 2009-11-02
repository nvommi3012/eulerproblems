package problem_9;

//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.
public class Problem9 {

	// find the pythagorean triplet that sums to "sum"
	public int[] findTriplet(int sum) {
		
		// sum is the upper limit, 1 the lower
		// iterate through all possible combinations until sum is correct, then check pythagorean 
		for (int a = 1; a < sum; ++a)
		{
			// optimize because if we assume a is correct then b cant be greater than sum - a
			for (int b = 1; b <= sum - a; ++b)
			{
				// same for c: if a and b is correct then c cant be greater than sum - a - b
				for (int c = 1; c <= sum - a - b; ++c)
				{
					if (a + b + c == sum)
					{
						int bb = b*b;
						int aa = a*a;
						int cc = c*c;
						if (aa + bb == cc || bb + cc == aa || aa + cc == bb)
							return new int[] {a,b,c};
					}
				}
			}
		}
		// return empty object (but not null to avoid exceptions)
		return new int[] {0,0,0};
	}
	
	// find the product of the exact triplet that sums to "sum"
	public long findProduct(int sum)
	{
		int[] result = findTriplet(sum);
		return result[0] * result[1] * result[2];
	}
	
}
