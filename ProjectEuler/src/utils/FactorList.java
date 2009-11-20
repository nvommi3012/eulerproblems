package utils;

import java.util.ArrayList;

public class FactorList extends ArrayList<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static FactorList _factors[] = null;
	private static int _max = 10000;

	public enum Mode {ALLINCLUSIVE, INCLUDING_ONE, EXCLUSIVE};

	/**
	 * @param number number to factorize
	 * @param m mode what to include in the factorization
	 */
	private void generate(long number, Mode m)
	{
		long start = 1;
		long end = number;
		
		if (_factors == null)
			_factors = new FactorList[_max];
		
		if (number < _max && _factors[(int)number] != null)
		{
			this.addAll(_factors[(int)number]);
			return;
		}
		
		// TODO: refactor for subclassing
		if (m == Mode.ALLINCLUSIVE)
		{
			start = 1;
			end = number;
		}
		else if (m == Mode.INCLUDING_ONE)
		{
			start = 1;
			end = number / 2;
		}
		else if (m == Mode.EXCLUSIVE)
		{
			start = 2;
			end = number / 2;
		}
		
		for (long i = start; i <= end; ++i)
		{
			if (number % i == 0)
			{
				add(i);
			}
		}
		
		if (number < _max)
			_factors[(int)number] = this;
		
	}
	
	/**
	 * @param number number to factorize (including 1 but not itself
	 */
	public FactorList(long number) {
		generate(number, Mode.INCLUDING_ONE);
	}

	/**
	 * @param number number to factorize
	 * @param m mode what to include in the factorization
	 */
	public FactorList(long number, Mode m) {
		generate(number, m);
	}

}
