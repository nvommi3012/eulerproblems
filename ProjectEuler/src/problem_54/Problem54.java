package problem_54;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import utils.ArrayList;

/**
 * @author wolfgang
 * @note enums were too inflexible, use int const now
 * TODO: remove constants and replace with subclassing, ...
 */
final class Consts { 
    private Consts() { throw new AssertionError("Consts is uninstantiable"); }
    public static final int ColorHeart = 0; 
    public static final int ColorDiamond = 1;
    public static final int ColorClub = 2;
    public static final int ColorSpade = 3;
    public static final int ValueOne = 0;
    public static final int ValueTwo = 1;
    public static final int ValueThree = 2;
    public static final int ValueFour = 3;
    public static final int ValueFive = 4;
    public static final int ValueSix = 5;
    public static final int ValueSeven = 6;
    public static final int ValueEight = 7;
    public static final int ValueNine = 8;
    public static final int ValueTen = 9;
    public static final int ValueJack = 10;
    public static final int ValueQueen = 11;
    public static final int ValueKing = 12;
    public static final int ValueAce = 13;
    public static final int HighCard = 0;
    public static final int OnePair = 1;
    public static final int TwoPair = 2;
    public static final int Threes = 3;
    public static final int Straight = 4;
    public static final int Flush = 5;
    public static final int FullHouse = 6;
    public static final int Fours = 7;
    public static final int StraightFlush = 8;
    public static final int RoyalFlush = 9;
    
    public static final String[] ColorStrings = new String[] {"Heart", "Diamond", "Club", "Spade"};
    public static final String[] ValueStrings = new String[] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    public static final String[] PlayStrings = new String[] {"HighCard", "Pair", "Two Pairs", "Three", "Straight", "Flush", "Full House", "Fours", "Straight Flush", "Royal Flush"};
}

/**
 * @author wolfgang
 * @note in poker.txt how many hands does Player 1 win?
 */
public class Problem54 {

	/**
	 * @author wolfgang
	 * @note class for a hand (contains 5 cards and calculates the result)
	 */
	public class Hand
	{
		// card storage
		Card[] _cards;
		// the highest value of a Play
		int primaryValue;
		/**
		 * @param s input string from file
		 * @param Player1 if true first 5 cards are read else 6-10
		 */
		public Hand(String s, boolean Player1)
		{
			_cards = new Card[5];
			// split the string for the correct player and populate cards
			int stringidx = Player1?0:5;
			String strings[] = s.split(" ");
			for (int idx = 0; idx < 5; ++idx)
			{
				Card card = new Card(strings[stringidx + idx]);
				_cards[idx] = card;
			}
			// sort for easy evaluation
			Arrays.sort(_cards);
			primaryValue = -1;
		}
		
		/**
		 * @return true if cards represent Royal Flush (Straight Flush in one color and ending in Ace)
		 */
		private boolean isRoyalFlush()
		{
			if (isStraightFlush() && primaryValue == Consts.ValueAce)
				return true;
			return false;
		}
		
		/**
		 * @return true if Straight Flush (all in one color and in order)
		 */
		private boolean isStraightFlush()
		{
			int color = _cards[0].color;
			int high = _cards[4].value;

			// check for same color on all cards
			for (Card c: _cards)
				if (c.color != color)
					return false;
			
			primaryValue = high;
			
			// check for order of all cards
			for (int i = 3; i >= 0; --i)
			{
				Card c = _cards[i];
				if (high != c.value + 1)
					return false;
				high = c.value;
			}
			return true;
		}
		
		/**
		 * @return aggregate all cards into their values
		 */
		private int[] getValues()
		{
			// there are 14 different cards, so an array of [14] is needed
			int[] values = new int[14];
			for (Card c: _cards)
					++values[c.value];
			return values;
		}
		
		/**
		 * @return aggregate all cards into their colors
		 */
		private int[] getColors()
		{
			// only 4 colors, so array size == 4 suffices
			int[] colors = new int[4];
			for (Card c: _cards)
				++colors[c.color];
			return colors;
		}
		
		/**
		 * @return true if four cards of same value are present
		 */
		private boolean isFours()
		{
			// check all aggregated values if any one has 4 cards
			for (int i: getValues())
				if (i == 4)
				{
					primaryValue = i;
					return true;
				}
			return false;
		}
		
		/**
		 * @return true if 3 cards of same value and 2 cards of same value are present
		 */
		private boolean isFullHouse()
		{
			boolean three = false;
			boolean two = false;
			int[] values = getValues(); 
			// check all the values
			for (int idx = 0; idx < values.length; ++idx)
			{
				// any value has 3 cards?
				if (values[idx] == 3)
				{
					primaryValue = idx;
					three = true;
				}
				// any value has 2 cards
				if (values[idx] == 2)
					two = true;
			}
			// it's a flush if both are true
			return two && three;
		}

		/**
		 * @return true if any 5 cards of same color
		 */
		private boolean isFlush()
		{
			// check for colors
			for (int n: getColors())
				if (n == 5)
					return true;
			return false;
		}

		/**
		 * @return true if any 5 cards in correct order
		 */
		private boolean isStraight()
		{
			// check for order of cards
			int high = _cards[0].value;
			for (int i = 1; i < 5; ++i)
			{
				Card c = _cards[i];
				
				if (high != c.value - 1)
					return false;
				high = c.value;
			}
			return true;
		}
		
		/**
		 * @return true if 3 cards are the same value
		 */
		private boolean isThrees()
		{
			// see if any value has 3 cards
			for (int n: getValues())
				if (n == 3)
					return true;
			return false;
		}

		/**
		 * @return true if 2 x 2 cards are the same value 
		 */
		private boolean isTwoPairs()
		{
			int paircount = 0;
			int[] values = getValues(); 
			// see how many values have two cards
			for (int idx = 0; idx < values.length; ++idx)
			{
				if (values[idx] == 2)
				{
					paircount++;
					if (idx > primaryValue)
						primaryValue = idx;
				}
			}
			// only if there are 2 pairs return true
			if (paircount == 2)
				return true;
			return false;
		}
		
		/**
		 * @return true if 2 cards are the same value
		 */
		private boolean isPair()
		{
			int paircount = 0;
			int[] values = getValues();
			// same as isTwoPairs, but if one
			for (int idx = 0; idx < values.length; ++idx)
			{
				if (values[idx] == 2)
				{
					paircount++;
					if (idx > primaryValue)
						primaryValue = idx;
				}
			}
			if (paircount == 1)
				return true;
			return false;
		}
		
		/**
		 * @return the value of the hand
		 */
		public int getPlay()
		{
			// check from highest Play to lowest (least complicated)
			if (isRoyalFlush())
				return Consts.RoyalFlush;
			else if (isStraightFlush())
				return Consts.StraightFlush;
			else if (isFours())
				return Consts.Fours;
			else if (isFullHouse())
				return Consts.FullHouse;
			else if (isFlush())
				return Consts.Flush;
			else if (isStraight())
				return Consts.Straight;
			else if (isThrees())
				return Consts.Threes;
			else if (isTwoPairs())
				return Consts.TwoPair;
			else if (isPair())
				return Consts.OnePair;
			
			// if no other Play was found it's just the highest card
			primaryValue = _cards[4].value;
			return Consts.HighCard;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString()
		{
			return "Hand: " + Arrays.toString(_cards);
		}
		
		/**
		 * @param obj other hand to compare
		 * @return 1 is this hand has more value, -1 if other hand has more value
		 */
		public int compareTo(Object obj)
		{
			Hand other = (Hand)obj;
			// get the score of both hands
			int p1 = getPlay();
			int p2 = other.getPlay();
			// if score differs it's clear who the winner is
			if (p1 > p2)
				return 1;
			else if (p1 == p2)
			{
				// if the score is the same, check who has the highest card
				if (primaryValue > other.primaryValue)
					return 1;
			}
			return -1;
		}
	}
	
	/**
	 * @author Wolfgang
	 * @note class representing a Card; implements Comparable so Arrays.sort is working correctly
	 */
	public class Card implements Comparable<Object>
	{
		// color (see Consts class)
		int color;
		// value (see Consts class)
		int value;
		
		/**
		 * @param c color to apply to the card
		 */
		private void setColor(char c)
		{
			switch(c)
			{
				case 'H': color = Consts.ColorHeart; break;
				case 'C': color = Consts.ColorClub; break;
				case 'S': color = Consts.ColorSpade; break;
				case 'D': color = Consts.ColorDiamond; break;
				default: throw new IllegalArgumentException("Invalid color");
			}
		}
		
		/**
		 * @param v value to apply to the card
		 */
		private void setValue(char v)
		{
			switch(v)
			{
			case 'A': value = Consts.ValueAce; break;
			case '2': value = Consts.ValueTwo; break;
			case '3': value = Consts.ValueThree; break;	
			case '4': value = Consts.ValueFour; break;	
			case '5': value = Consts.ValueFive; break;	
			case '6': value = Consts.ValueSix; break;	
			case '7': value = Consts.ValueSeven; break;	
			case '8': value = Consts.ValueEight; break;	
			case '9': value = Consts.ValueNine; break;	
			case 'T': value = Consts.ValueTen; break;	
			case 'J': value = Consts.ValueJack; break;
			case 'Q': value = Consts.ValueQueen; break;
			case 'K': value = Consts.ValueKing; break;
			default: throw new IllegalArgumentException("Invalid value");
			}
		}
		
		/**
		 * @param in the split string of the input file, containing only the color and value (i.e. 'AH')
		 */
		public Card(String in)
		{
			// value is first
			setValue(in.charAt(0));
			// color is 2nd char
			setColor(in.charAt(1));
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString()
		{
			return "" + Consts.ValueStrings[value] + " of " + Consts.ColorStrings[color] + "s";
		}
		
		/**
		 * @param other card to compare to
		 * @return true if color and value is equal
		 */
		public boolean equals(Card other)
		{
			if (other.value == value && other.color == color)
				return true;
			return false;
		}
		
		/**
		 * @param other card to compare to
		 * @return true if color is equal
		 */
		public boolean equalsColor(Card other) {
			if (other.color == color)
				return true;
			return false;
		}

		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Object obj) {
			Card other = (Card)obj;
			if (value > other.value)
				return 1;
			if (value == other.value)
				return 0;
			return -1;
		}
	}
	
	// storage for the players hands in the file
	ArrayList<Hand> Player1;
	ArrayList<Hand> Player2;
	
	/**
	 * @param filename filename of the file containing the hands (without path) 
	 * @throws IOException if file was unreadable
	 */
	public Problem54(String filename) throws IOException
	{
		// init the storage
		Player2 = new ArrayList<Hand>();
		Player1 = new ArrayList<Hand>();
		// file object, build path
		File f = new File("src" + File.separator + "problem_54" + File.separator + filename);
		// filereader and bufferedreader for easy line reading
		FileReader r = new FileReader(f);
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(r);
			// as long as there is data left in the file
			while (fr.ready())
			{
				// get a line and build the 2 hands
				String line = fr.readLine();
				Hand h1 = new Hand(line, true);
				Hand h2 = new Hand(line, false);
				// add both hands to storage
				Player1.add(h1);
				Player2.add(h2);
			}
		} catch (FileNotFoundException e) {}
		finally
		{
			try {fr.close();} catch (IOException e) {}
		}
	}
	
	/**
	 * @return the number of hands player1 has won
	 */
	public int getSolution()
	{
		// counter
		int result = 0;
		
		if (Player1.size() != Player2.size())
			return 0;
		
		// iterate through all hands
		for (int i = 0; i < Player1.size(); ++i)
		{
			// get player1's hand
			Hand h1 = Player1.get(i);
			// get player2's hand
			Hand h2 = Player2.get(i);
			// use the Hand.compareTo function to evaluate the hands
			if (h1.compareTo(h2) > 0)
				++result;
		}
		return result;
	}
}
