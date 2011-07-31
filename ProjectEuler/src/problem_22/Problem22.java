package problem_22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * @author Wolfgang
 * @note What is the total of all the name scores in the file?
 */
public class Problem22 {

	/**
	 * @author Wolfgang
	 * @note helper class to keep the scores
	 */
	private class Score
	{
		public int score;
		public String name;
		public int index;

		/**
		 * @param name name to store
		 */
		public Score(String name)
		{
			this.name = name;
			score = getScore(name);
		}
		
		/**
		 * @param name name to calcualte the score from
		 * @return score of the name
		 */
		private int getScore(String name)
		{
			int score = 0;
			// just to make sure, we convert first to uppercase
			// score of A == 1, so we must add 1 after subrtacting the A
			for (char c: name.toUpperCase().toCharArray())
				score += c - 'A' + 1;
			return score;
		}
	}
	
	private TreeMap<String, Score> _names;
	
	/**
	 * @param f File to read
	 * @return map of all the names
	 * @throws IOException if the file is not valid, or does not exist
	 */
	private TreeMap<String, Score> fillMap(File f) throws IOException
	{
		// use bufferedreader to read line by line (even though in this example its only one line)
		BufferedReader r = null;
		TreeMap<String, Score> map = new TreeMap<String, Score>();
		r = new BufferedReader(new FileReader(f));
		String data = r.readLine();
		while (null != data)
		{
			// regex to split at either " or ,
			String tmp[] = data.split("[\",]");
			for (String s: tmp)
			{
				// split does return empty strings too, so ignore them
				if (s.isEmpty())
					continue;
				map.put(s, new Score(s));
			}
			data = r.readLine();
		}
		r.close();
		return map;
	}
	
	/**
	 * @param map the map to be transferred to the internal map
	 */
	private void cloneMap(TreeMap<String, Score> map)
	{
		// the result is obviously not zero based, so start at 1
		int index = 1;
		for (Entry<String, Score> e: map.entrySet())
		{
			// we store the index of each map entry
			e.getValue().index = index;
			// otherwise leave the entry alone and store it back into the objects internal map
			_names.put(e.getValue().name, e.getValue());
			++index;
		}
	}
	
	/**
	 * @param filename name of the file to be read (must be in source directory)
	 */
	public Problem22(String filename) {
		// allocate the internal map
		_names = new TreeMap<String, Score>();
		File f = new File("src" + File.separator + "problem_22", filename);
		try {
			// get a temporary map with the names
			TreeMap<String, Score> map = fillMap(f);
			// transfer the temp map to internal
			cloneMap(map);
		} catch (IOException e) {
			return;
		}
		
	}

	/**
	 * @param name name to get the index for
	 * @return index in the map
	 */
	public int getNameIndex(String name) {
		return _names.get(name).index;
	}

	/**
	 * @param name name to get the score for
	 * @return score of the name
	 */
	public int getNameScore(String name) {
		return _names.get(name).score;
	}

	/**
	 * @return the sum of the scores for each name
	 */
	public int getNamesScore() {
		int result = 0;
		for (Entry<String, Score> e: _names.entrySet())
			result += e.getValue().index * e.getValue().score;
		return result;
	}
}
