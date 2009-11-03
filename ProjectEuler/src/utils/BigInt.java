package utils;

// Helper class for large numbers represented as strings
public class BigInt {

	private String _number;
	
	// Constructor taking a string
	public BigInt(String string) {
		_number = string;
	}
	// overloaded equals taking either string or a BigInt
	@Override
	public boolean equals(Object other)
	{
		BigInt b = null;
		
		// if the 2 objects are the same object return true
		if (other == this)
			return true;
		
		// if the parameter was a string (ie. "12345") try and convert it to a BigInt object
		if (other instanceof String)
			b = new BigInt((String)other);
		// if the parameter was neither string nor BigInt it cant be equal
		else if (!(other instanceof BigInt))
			return false;
		// if the parameter already was BigInt use it
		else
			b = (BigInt)other;
		
		// now just check string.equals
		return _number.equals(b._number);
	}
	// gets a digit from the number (0 is least important)
	public int getDigit(int index)
	{
		int len = _number.length();
		try
		{
			// we try to get a single digit from the string
			// but i need it as string so the conversion to integer will be much easier
			String s = _number.substring(len - index - 1, len - index);
			return Integer.parseInt(s);
		}
		catch(Exception e)
		{
			// if the index was out of range just return 0
			return 0;
		}
	}
	// add 2 big ints
	public BigInt add(BigInt other) {
		// calculate the maximum length of the 2 numbers
		int len = _number.length() > other._number.length() ? _number.length() : other._number.length();
		// this is used as flag for overflows (sum of two digits > 9) 
		int overflow = 0;
		// store the result in this string
		String result = "";
		
		// iterate through both number strings
		for (int i = 0; i < len; ++i)
		{
			// first we get the values of the digits at "i"
			int i1 = getDigit(i);
			int i2 = other.getDigit(i);
			// then the sum of the digits (with the remembered overflow)
			int sum = i1 + i2 + overflow;
			// if there is overflow
			if (sum > 9)
			{
				// reduce the sum and concat the string to the new digit
				// (remember we go from back to front ie. least significant first)
				result = String.valueOf(sum - 10) + result;
				overflow = 1;
			}
			else
			{
				// no overflow means we can just concat the digit and the result
				result = String.valueOf(sum) + result;
				overflow = 0;
			}
		}

		// after all is done check the overflow again and add it to the result if necessary
		if (overflow > 0)
		{
			result = String.valueOf(overflow) + result;
		}
		// convert the result string into a BigInt object and return it
		return new BigInt(result);
	}
	// get the most significant digit index
	public int getMostSignificantIndex()
	{
		return _number.length();
	}
	
}
