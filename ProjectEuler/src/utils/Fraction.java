package utils;

import java.math.BigInteger;

public class Fraction {

	BigInteger _numerator;
	BigInteger _denominator;
	
	final String _NaN = "NaN";
	
	public Fraction(int num, int denom)
	{
		_numerator = BigInteger.valueOf(num);
		_denominator = BigInteger.valueOf(denom);
	}
	
	public Fraction(long num, long denom)
	{
		_numerator = BigInteger.valueOf(num);
		_denominator = BigInteger.valueOf(denom);
		
	}

	public Fraction(BigInteger num, BigInteger denom)
	{
		_numerator = num;
		_denominator = denom;
	}
	
	public String toString()
	{
		if (_denominator == BigInteger.ZERO)
			return _NaN;
		else
			return "" + _numerator + "/" + _denominator;
	}
	
	public Fraction add(Fraction other)
	{
		if (_denominator.equals(other._denominator))
			return new Fraction(_numerator.add(other._numerator), _denominator);
		
		BigInteger newNum = _numerator.multiply(other._denominator);
		BigInteger otherNum = _denominator.multiply(other._numerator);
		BigInteger newDen = _denominator.multiply(other._denominator);
		
		newNum = newNum.add(otherNum);
		// TODO: kuerzen
		return new Fraction(newNum, newDen);
	}

	public Fraction subtract(Fraction other)
	{
		if (_denominator.equals(other._denominator))
			return new Fraction(_numerator.subtract(other._numerator), _denominator);
		
		BigInteger newNum = _numerator.multiply(other._denominator);
		BigInteger otherNum = _denominator.multiply(other._numerator);
		BigInteger newDen = _denominator.multiply(other._denominator);
		
		newNum = newNum.subtract(otherNum);
		// TODO: kuerzen
		return new Fraction(newNum, newDen);
	}
	
	public Fraction multiply(Fraction other)
	{
		return new Fraction(_numerator.multiply(other._numerator), _denominator.multiply(other._denominator));
	}

	public Fraction divide(Fraction other)
	{
		return new Fraction(_numerator.multiply(other._denominator), _denominator.multiply(other._numerator));
	}

	public boolean equals(Object other)
	{
		if (other.getClass() != Fraction.class)
			return false;
		
		Fraction oth = (Fraction)other;

		if (this._denominator.equals(BigInteger.ZERO) && oth._denominator.equals(BigInteger.ZERO))
			return true;
		
		Fraction r1 = this.reduce();
		Fraction r2 = oth.reduce();

		if (r1._denominator.equals(r2._denominator) && r1._numerator.equals(r2._numerator))
			return true;
		return false;
	}
	
	public Fraction reduce() {
		PrimeFactorList n1 = new PrimeFactorList(_numerator.longValue());
		PrimeFactorList n2 = new PrimeFactorList(_denominator.longValue());

		PrimeFactorList diff = PrimeFactorList.greatestCommonDivisor(new PrimeFactorList[] {n1,n2} );
		if (diff.size() == 0)
			return this;
		BigInteger r = BigInteger.valueOf(diff.calculateValue());
		return new Fraction(_numerator.divide(r), _denominator.divide(r));
	}

	public BigInteger numerator() {
		return this._numerator;
	}

	public BigInteger denominator() {
		return this._denominator;
	}
}
