package problem_45;

import java.util.TreeSet;

/**
 * @author Wolfgang
 * @note Find the next triangle number that is also pentagonal and hexagonal.
 */
public class Problem45 {

	/**
	 * @note TreeSet extended by the generation of all elements 
	 */
	abstract class BaseTree extends TreeSet<Long>
	{
		// needed for the Collection - no real purpose here
		private static final long serialVersionUID = 1L;
		// each of the tree classes must implement its own f(n)
		protected abstract long f(long n);
		// check until 2 bil (arbitrary limit, from the solution)
		final long MAX = 2000000000L;
		/**
		 * Ctor, generate all elements, uses overloaded f(n) function from the subclasses 
		 */
		public BaseTree()
		{
			// start with f(1)
			long n = 1;
			while (f(n) < MAX)
				add(f(n++));
		}
	}
	
	/**
	 * @note implements the triagonal version of f(n)
	 */
	class TriTree extends BaseTree
	{
		private static final long serialVersionUID = 1L;
		protected long f(long n) {
			//Triangle Number: f(x) = x(x + 1)/2
			return n * (n + 1) / 2;
		}
	}
	
	/**
	 * @note implements the pentagonal version of f(n)
	 */
	class PentTree extends BaseTree
	{
		private static final long serialVersionUID = 1L;
		protected long f(long n) {
			//Pentagon Number: f(x) = x(3x - 1)/2
			return n * (n * 3 - 1) / 2;
		}
	}

	/**
	 * @note implements the hexagonal version of f(n)
	 */
	class HexTree extends BaseTree
	{
		private static final long serialVersionUID = 1L;
		protected long f(long n) {
			//Hexagon Number: f(x) = x(2x - 1)
			return n * (n * 2 - 1);
		}
	}
		
	/**
	 * @return the f(n) that is tri-, pent- and hexagonal
	 */
	public long getSolution()
	{
		// generate the 3 different trees
		TriTree tritree = new TriTree();
		PentTree penttree = new PentTree();
		HexTree hextree = new HexTree();
		// convert one tree to ordered array
		Long[] array = tritree.toArray(new Long[tritree.size()]);
		// start with f(286) and check the numbers in the other two trees
		for (int i = 286; i < tritree.size(); ++i)
		{
			if (penttree.contains(array[i]) && hextree.contains(array[i]))
				return array[i];
		}
		// hopefully there are numbers to be found, in which case we will never get here
		return 0;
	}
}
