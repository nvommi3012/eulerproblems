package problem_51;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import utils.ArrayList;
import utils.IPrimes;
import utils.PrimesSieve;

public class Problem51Test {

		@Test
		public void testMask()
		{
			// 100000,110000,111000,111100,111110,
			//  10000,101000,110100,111010,111101,
			//   1000,100100,110010,110110,111011,
			//    100,100010,110001,101110,110111,
			//     10,100001,101100, 11110,101111,
			//      1, 11000,101010,111001, 11111,
			//         10100,101001,110101,
			//         10010,100110,101101,
			//         10001,100101, 11101,
			//          1100,100011,110011,
			//          1010, 11100,101011,
			//          1001, 11010, 11011,
			//           110, 11001,100111,
			//           101, 10110, 10111,
			//            11, 10101,  1111,
			//                10011,
			//                 1110,
			//                 1101,
			//                 1011,
			//                  111};
			// 6	 +15    +20    +15     +6     = 62
			Problem51 p = new Problem51();
			assertEquals(62, p.getMask(6).size());
			assertEquals(2, p.getMask(2).size());
			try
			{
				p.getMask(1);
				fail();
			} catch (IndexOutOfBoundsException ex){}
			try
			{
				p.getMask(9);
				fail();
			} catch (IndexOutOfBoundsException ex){}
		}
		
		@Test
		public void testMaskApplication()
		{
			Problem51 p = new Problem51();
			IPrimes primes = new PrimesSieve(1000000);
			ArrayList<int[]> tmp = p.getMask(2);
			assertEquals(13, p.applymask(13, tmp, primes, 6));
			tmp = p.getMask(5);
			assertEquals(56003, p.applymask(56003, tmp, primes, 7));
			tmp = p.getMask(6);
			assertEquals(121313, p.applymask(121313, tmp, primes, 8));
		}
	
		@Test
		public void testSolution()
		{
			try
			{
			Problem51 p = new Problem51();
			assertEquals(121313, p.getSolution());
			} catch (Exception ex){ fail(); }
		}
}
