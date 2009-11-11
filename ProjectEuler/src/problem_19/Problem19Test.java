package problem_19;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

public class Problem19Test extends TestCase {

	public void testCalendar()
	{
			GregorianCalendar gc = new GregorianCalendar();
			gc.set(1900, Calendar.JANUARY, 1);
			int result = gc.get(Calendar.DAY_OF_WEEK);
			assertEquals(Calendar.MONDAY, result);
	}
	
	public void testSundayCount()
	{
		Problem19 p = new Problem19();
		assertEquals(171, p.getSundayCount());
	}
	
}
