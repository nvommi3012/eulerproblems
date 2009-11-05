package problem_15;

/**
 * @author Wolfgang
 * Problem 15: How many routes are there through a 20×20 grid?
 */
public class Problem15 {

	/**
	 * @param gridsize size of the grid
	 * @return number of routes through the grid
	 */
	public long getRoutes(int gridsize) {
		// for this to work we need to resize the grid by one
		// since the problem uses the edges of the grid, and not cells
		++gridsize;
		// make a nice grid
		long[][] grid = new long[gridsize][gridsize];
		
		// init with the starting values we need to get the algorithm running
		grid[0][0] = 0;
		grid[1][0] = grid[0][1] = 1;
		
		// now look at each cell
		for (int y = 0; y < gridsize; ++y)
		{
			for (int x = 0; x < gridsize; ++x)
			{
				// we need the direct neighbors of each cell
				// since i am lazy and the neighbor could be out of bounds
				// i just let the exceptions handle this
				long pre_x = 0, pre_y = 0;
				try { pre_x = grid[y-1][x]; }
				catch(Exception e){}
				try { pre_y = grid[y][x-1];	}
				catch (Exception e){}
				
				// now that we got the neighbors the new cell is the sum of the neighbors
				if (grid[y][x] == 0)
					grid[y][x] = pre_x + pre_y;
			}
		}
		// in the last cell is the correct result
		return grid[gridsize - 1][gridsize - 1];
	}

}
