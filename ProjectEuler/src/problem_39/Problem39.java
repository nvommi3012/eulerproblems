package problem_39;

/**
 * @author Wolfgang
 * @note For which value of p <= 1000, is the number of solutions maximised?
 */
public class Problem39 {

	/**
	 * @param a leg a
	 * @param b leg b 
	 * @param c hypotenuse
	 * @return true if right angled (a^2 + b^2 = c^2)
	 */
	public boolean isRightAngled(int a, int b, int c) {
		if (a*a + b*b == c*c)
			return true;
		return false;
	}

	/**
	 * @param perimeter perimeter of the triangle
	 * @return number of possible Pythagorean triples
	 */
	public int getNumberOfTriangles(int perimeter) {
		int result = 0;

		// one side must never be larger than the perimeter
		for (int a = 1; a < perimeter; ++a)
			// the other side must never be larger than (perimeter - a) and must be at least a to elimiate duplicates
			for (int b = a; b < perimeter - a; ++b)
			{
				// if a, b and perimeter are known c is trivial to calculate
				int c = perimeter - a - b;
				// check if a+b exceed perimeter
				if (c <= 0)
					break;
				// only if all sides added up equal exactly the perimeter and the resulting triangle is a right triangle
				if ((a+b+c == perimeter) && isRightAngled(a,b,c))
					// add 1 to the solution
					result++;
			}
		return result;
	}

	/**
	 * @return the maximized perimeter
	 */
	public int getSolution() {
		int result = 0;
		int max = 0;
		int num;
		
		// check all perimeters <= 1000
		for (int perimeter = 1; perimeter <= 1000; ++perimeter)
		{
			// get the solution of the perimter
			num = getNumberOfTriangles(perimeter);
			// check if this solution is better (larger) than the previous best solution
			if (num > max)
			{
				// if yes then set the new maximum solution and remember the perimeter
				max = num;
				result = perimeter;
			}
		}
		// return the best perimeter
		return result;
	}
}
