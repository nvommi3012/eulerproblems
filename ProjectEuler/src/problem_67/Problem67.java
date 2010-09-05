package problem_67;

import java.io.File;
import java.io.IOException;
import problem_18.Problem18;

public class Problem67 {

	public int getSolution(String filename) throws IOException
	{
		File f = new File("src"+ File.separator +"problem_67", filename);
		Problem18 p18 = new Problem18(f);
		return p18.getMaximumRoute();
	}

}