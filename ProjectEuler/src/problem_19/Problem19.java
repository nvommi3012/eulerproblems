package problem_19;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Wolfgang
 * @note How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem19 {

	int[] _months;	// will carry all the months of the calendar class
	final int _startingyear = 1901;	// could be a parameter
	final int _endyear = 2000;	// could also be a parameter
	GregorianCalendar _gc;	// the Calendar object

	/**
	 * Constructor is used to allocate the Calendar objects and init the months 
	 */
	public Problem19()
	{
		_gc = new GregorianCalendar();
		_gc.set(_startingyear, Calendar.JANUARY, 1);
		_months = new int[] {Calendar.JANUARY, Calendar.FEBRUARY, Calendar.MARCH, Calendar.APRIL, Calendar.MAY, Calendar.JUNE, Calendar.JULY, Calendar.AUGUST, Calendar.SEPTEMBER, Calendar.OCTOBER, Calendar.NOVEMBER, Calendar.DECEMBER};
	}
	
	/**
	 * @return number of sundays
	 */
	public int getSundayCount() {
		int result = 0;
	
		// iterate through every year in range
		while (_endyear >= _gc.get(Calendar.YEAR))
		{
			// iterate through all the months
			for (int month = 0; month < _months.length; ++month)
			{
				// set the specific month in the Calendar (leave every other field as it was)
				_gc.set(Calendar.MONTH, _months[month]);
				// check if the 1. was a Sunday
				if (Calendar.SUNDAY == _gc.get(Calendar.DAY_OF_WEEK))
					++result;
			}
			_gc.add(Calendar.YEAR, 1);
		}
		return result;
	}
}
