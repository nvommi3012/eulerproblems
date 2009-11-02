package problem_8;

//Find the greatest product of five consecutive digits in the 1000-digit number.
//73167176531330624919225119674426574742355349194934
//96983520312774506326239578318016984801869478851843
//85861560789112949495459501737958331952853208805511
//12540698747158523863050715693290963295227443043557
//66896648950445244523161731856403098711121722383113
//62229893423380308135336276614282806444486645238749
//30358907296290491560440772390713810515859307960866
//70172427121883998797908792274921901699720888093776
//65727333001053367881220235421809751254540594752243
//52584907711670556013604839586446706324415722155397
//53697817977846174064955149290862569321978468622482
//83972241375657056057490261407972968652414535100474
//82166370484403199890008895243450658541227588666881
//16427171479924442928230863465674813919123162824586
//17866458359124566529476545682848912883142607690042
//24219022671055626321111109370544217506941658960408
//07198403850962455444362981230987879927244284909188
//84580156166097919133875499200524063689912560717606
//05886116467109405077541002256983155200055935729725
//71636269561882670428252483600823257530420752963450

public class Problem8 {

	private String _source;
	
	// initialize and remember string
	public Problem8(String string) {
		_source = string;
	}

	// convert digit at "idx" to integer
	public int getAt(int idx) {
		if (idx >= _source.length())
			throw new IllegalArgumentException();

		String sub = _source.substring(idx, idx + 1);
		int result = Integer.parseInt(sub);
		return result;
	}

	// do the calculation
	// multiply 5 consecutive digits through the whole string
	public int getNumber() {
		int i1, i2, i3, i4, i5, tmp, result = 0;
		int len = _source.length();
		
		// string must not be shorter than 5 chars
		if (len < 5)
			throw new IllegalArgumentException();
		
		// from beginning to end (-5 chars because we still need those 5 as our digits)
		for (int idx = 0; idx < len - 5; ++idx)
		{
			// get the 5 numbers
			i1 = getAt(idx);
			i2 = getAt(idx + 1);
			i3 = getAt(idx + 2);
			i4 = getAt(idx + 3);
			i5 = getAt(idx + 4);
			// calc the multiple
			tmp = i1* i2 * i3 * i4 * i5;
			// compare and store largest
			if (result < tmp)
				result = tmp;
		}
		return result;
	}
	
}
