package problem_71;

/**
 * @author Wolfgang
 * @note By listing the set of reduced proper fractions for d <= 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7
 */
public class Problem71 {

	final int MILLION = 1000000;
	
	/**
	 * @return numerator of the farey sequence (Order = 10^6) which is directly left of (3/7)
	 */
	public int getSolution() {

		// the sequence of reduced fractions specified in Problem 71 is called a Farey Sequence
		// http://en.wikipedia.org/wiki/Farey_sequence
		// the logic behind the algorithm is explained in the wiki article. To summarize:
		// if a/b and c/d are neighbours in a Farey sequence then the first term that appears between them
		// as the order of the Farey sequence is increased is (a+c)/(b+d)
		// which first appears in the Farey sequence of order b + d.
		//
		// it seems logical that when 2/5 is the direct neighbor of 3/7 in a Farey Order(8)
		// the result for Order(10^6) must be > 2/5, so we take this as the known starting point
		// of the farey sequence, with 3/7 as the specified endpoint.
		//
		// using that values the actual algorithm is quite simple
		
		// a/b is the starting point (2/5)
		int a = 2, b = 5;
		// c/d is the end point (3/7)
		int c = 3, d = 7;

		// b + d specifies the farey order
		while (b + d <= MILLION) {
			// generate a new "mediant" between a/b and c/d
		    a += c;
		    b += d;
		}
		// once the Order(10^6) is reached a/b must be the direct neighbor of c/d (which is still 3/7)
		return a;
	}
}
