package problem_59;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * @author wolfgang
 * @note Decrypt the message and find the sum of the ASCII values in the original text.
 */
public class Problem59 {

	// storage for converted input file
	private byte[] _data;
	
	/**
	 * @param filename name of the input file containing comma separated numbers describing ASCII codes
	 */
	public Problem59(String filename) {

		try
		{
			// just read the file, convert it and store it
			File f = new File("src" + File.separator + "problem_59" + File.separator + filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			// comma separated so split by ','
			String[] numbers = s.split(",");
			int idx = 0;
			_data = new byte[numbers.length];
			// convert each number into its ASCII code
			for (String number: numbers)
			{
				_data[idx++] = Byte.parseByte(number);
			}
		}
		catch(Exception ex)
		{
			_data = new byte[0];
		}
	}

	/**
	 * @param decode byte to test
	 * @return true if <decode> seems to be legible
	 */
	private boolean testDecode(byte decode)
	{
		// 32 - 122 doesn't seem to work, so define some more exclusions that are not in normal english words
		byte[] exclusions = new byte[] {'#', '/', '\\', '-', '+', '~', '*'};
		if (Arrays.binarySearch(exclusions, decode) > 0)
			return false;
		if (decode < 32 || decode > 122)
			return false;
		return true;
	}
	
	/**
	 * @param idx index in the encoded data storage
	 * @return the byte of encoded data at <idx>
	 */
	public byte get(int idx)
	{
		if (idx < 0 || idx > _data.length)
			return 0;
		return _data[idx];
	}
	
	
	/**
	 * @param old the previous cipher
	 * @return a new cipher based on <old>
	 */
	private byte[] getNewCipher(byte[] old)
	{
		// just increase alphabetically until we overflow, then move the index one forward
		int idx = 0;
		
		while (idx >= 0)
		{
			if (old[idx] == 'z')
			{
				old[idx] = 'a';
				idx++;
			}
			else
			{
				++old[idx];
				return old;
			}
		}
		return null;
	}
	
	/**
	 * @param encoded the encoded byte stream
	 * @param cipher the password to decode <encoded>
	 * @return the decoded byte stream
	 */
	private byte[] decodeData(byte[] encoded, byte[] cipher)
	{
		byte[] decoded = new byte[encoded.length];
		
		for (int idx = 0; idx < encoded.length;)
		{
			for (int cidx = 0; cidx < cipher.length; ++cidx, ++idx)
			{
				if (idx >= encoded.length)
					break;
				decoded[idx] = (byte)(encoded[idx] ^ cipher[cidx]);
				// test for correct characters
				if (testDecode(decoded[idx]) == false)
					return null;
			}
		}
		return decoded;
	}
	
	/**
	 * @return the sum of all chars ASCII codes of the decoded message
	 * @throws Exception 
	 */
	public int getSolution() throws Exception {
		// starting cipher, all lower case letters
		byte[] cipher = new byte[] {'a','a','a'};
		
		while (true)
		{
			// do not modify original data
			byte[] data = _data.clone();
			// decode
			data =  decodeData(data, cipher);
			// if data was not decoded correctly get next cipher and try again
			if (data == null)
			{
				cipher = getNewCipher(cipher);
				if (cipher == null)
					break;
				continue;
			}
			// data was correctly decoded, so get the sum of all ASCII codes
			int result = 0;
			for (byte b: data)
				result += b;
			return result;
		}
		throw new Exception("no solution found");
	}
}
