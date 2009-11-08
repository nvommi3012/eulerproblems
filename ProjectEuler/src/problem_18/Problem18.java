package problem_18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Wolfgang
 * Find the maximum total from top to bottom of the specified triangle (see problem.dat)
 */
public class Problem18 {

	int[][] _triangle;
	int _lines;
	
	/**
	 * @param filename name of the data file (file must be in the same directory as the source files)
	 * @throws Exception if there is a problem with the data file exception is thrown
	 */
	public Problem18(String filename) throws Exception
	{
		// open the data file
		File f = new File("src\\problem_18\\" + filename);
		// get a linecount so we can allocate the array correctly
		_lines = getLineCount(f);
		// allocate the array
		_triangle = new int[_lines][_lines];
		int line = 0, cell = 0;
		// use BufferedReader to get each line
		BufferedReader  r = new BufferedReader(new FileReader(f));
		String data = r.readLine();
		while (null != data)
		{
			// use the regex split to get the numbers out of the string
			String results[] = data.split(" ");
			// put each number into its cell
			for (String s: results)
			{
				_triangle[line][cell] = Integer.parseInt(s);
				++cell;
			}
			// next line
			++line;
			// first cell again after lineswitch
			cell = 0;
			// read the next line from file
			data = r.readLine();
		}
		r.close();
	}
	
	/**
	 * @param f File object containing the data file
	 * @return number of lines read
	 */
	private int getLineCount(File f) {
		// use same method as before, use BufferedReader to get the linecount
		BufferedReader r;
		int result = 0;
		try {
			r = new BufferedReader(new FileReader(f));
			while (null != r.readLine())
				++result;
			r.close();
		} catch (IOException e) {}
		return result;
	}

	/**
	 * @param triangle triangle to put on error stream
	 * @note for debugging purposes only
	 */
	@SuppressWarnings("unused")
	private void _debugout(int triangle[][])
	{
		for (int i = 0; i < _lines; ++i)
		{
			for (int j = 0; j < _lines; ++j)
			{
				if (triangle[i][j] > 0)
					System.err.print(" " + triangle[i][j]);
			}
			System.err.println(" ");
		}
			
	}
	
	/**
	 * @return the maximum total from traversing the triangle top to bottom
	 */
	public int getMaximumRoute() {
		// get a working copy
		int[][] work = _triangle.clone();

		// the algorithm is quite simple: just look at each line (or cell)
		// and calculate the sum of it and its upper cell (can be two parents)
		// if there are two sums store the larger
		// to make it even more simple i ignore the array boundaries and just
		// ignore the exceptions
		for (int line = 0; line < _lines; ++line)
		{
			for (int cell = 0; cell <= line; ++cell)
			{
				int r1 = 0, r2 = 0;
				try	{ r1 = work[line - 1][cell]; } catch (Exception e) {}
				try	{ r2 = work[line - 1][cell - 1]; } catch (Exception e) {}
				work[line][cell] = Math.max(work[line][cell] + r1, work[line][cell] + r2);
			}
			//_debugout(work);
		}
		
		// once we summed up the whole triangle, we need to look for the maximum in the bottom row
		int result = 0;
		for (int i: work[_lines - 1])
			if (i > result)
				result = i;
		return result;
	}

	/**
	 * @param line line in the triangle (zero based index)
	 * @param cell cell in the line (zero based index)
	 * @return content of the cell
	 */
	public int getCell(int line, int cell) {
		return _triangle[line][cell];
	}
}
