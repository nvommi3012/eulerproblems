package problem_42;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Wolfgang
 * @note using words.txt how many are triangle words?
 */
public class Problem42 {

	ArrayList<String> _words;
	int[] _trianglenumbers;
	
	/**
	 * generate triangle numbers with the formula 1/2*n*(n + 1)
	 */
	private void generateTriangleNumbers()
	{
		// array index starts at zero, but formula starts at 1, so we add 1 to every 'n'
		for (int i = 0; i < 26; ++i)
			_trianglenumbers[i] = (i+1)*(i+2)/2;
	}
	
	/**
	 * @param filename filename of the wordlist
	 * @throws Exception if file not found or IO error
	 */
	public Problem42(String filename) throws Exception {
		String tmp = "";
		_words = new ArrayList<String>();
		_trianglenumbers = new int[26];

		// get the specified file located in problem_42
		File f = new File("src" + File.separator + "problem_42", filename);
		// attach file reader to file object 
		FileReader reader = new FileReader(f);
		
		// make all the triangle numbers
		generateTriangleNumbers();

		try {
			// since all the words are in one line we need to parse the file
			while (true)
			{
				int c;
				// get a character
				c = reader.read();
				// EOF?
				if (c == -1)
					break;
				// delimiter to start and end file
				if (c == '"')
				{
					// already chars in the string then add it
					if (tmp.length() > 0)
					{
						// add the built string to the word list (make a clone, so we won't overwrite existing entries) 
						_words.add(new String(tmp));
						// reset the string for next use
						tmp = "";
					}
					else
						tmp = "";	// reset also
					continue;
				}
				else if (c == ',')	// ignore this character
					continue;
				tmp += (char)c;		// add everything else to the string
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("IO Error occurred");
		}
	}

	/**
	 * @param string string to calculate
	 * @return triangle number of the string
	 */
	public int getTriangleNumber(String string) {
		// convert to lower case so it's easier to get the index
		String tmp = string.toLowerCase();
		// store result
		int result = 0;
		// check each character and add the ordinal number (+1 because A==1)
		for (char c: tmp.toCharArray())
			result += (int)(c-'a'+1);
		return result;
	}

	/**
	 * @param i index of the triangle number (between 1 and 26)
	 * @return the triangle number
	 */
	public int getTriangleNumber(int i) {
		// check correct index
		if (i < 27 && i > 0)
			return _trianglenumbers[i-1];
		return 0;
	}

	/**
	 * @return the number of words that are triangle words
	 */
	public int getSolution() {
		// store number of words
		int result = 0;
		// go through all words
		for (String word: _words)
		{
			// calculate the triangle number
			int n = getTriangleNumber(word);
			// compare the number to all possible triangle numbers
			for (int tri: _trianglenumbers)
			{
				// if it's a match increase result
				if (n == tri)
					++result;
				// since the list of triangle numbers should be ordered we can quit as soon as we find a greater triangle number
				if (n < tri)
					break;
			}
		}
		return result;
	}

	/**
	 * @return number of words in the word list
	 */
	public int getWordCount() {
		return _words.size();
	}

}
