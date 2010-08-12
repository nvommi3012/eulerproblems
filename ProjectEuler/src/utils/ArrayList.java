package utils;

import java.util.TreeSet;

/**
 * @author wolfgang
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class ArrayList<T> extends java.util.ArrayList<T> {

	/**
	 * @return true if T is a primitive array (int[] ...)
	 * @throws IndexOutOfBoundsException if no items are in the ArrayList
	 */
	private boolean TisArray() throws IndexOutOfBoundsException
	{
		Class<?> ct = get(0).getClass().getComponentType(); 
		if (ct == null)
			return false;
		return true;
	}
	
	/**
	 * @return the class type of the array (int[] == int)
	 * @throws IndexOutOfBoundsException if no items are in the ArrayList
	 */
	private Class<?> getComponentType() throws IndexOutOfBoundsException
	{
		return get(0).getClass().getComponentType();
	}
	
	/**
	 * @throws UnsupportedOperationException if component type is not supported
	 */
	public void distinct() throws UnsupportedOperationException
	{
		try
		{
			// if type is [] array
			if (TisArray())
			{
				// get underlying (component) type
				Class<?> type = getComponentType();
				
				// awkward: for each supported type we need to duplicate the code here :(
				// TODO: find some way to generalize this
				if (type == int.class)
				{
					// compare each item with the next items
					for (int idx = 0; idx < size(); ++idx)
					{
						int[] entry = (int[])this.get(idx);
						for (int idx2 = idx + 1; idx2 < size(); ++idx2)
						{
							int[] cmp = (int[])this.get(idx2);
							if (entry.length == cmp.length)
							{
								boolean same = true;
								for (int n = 0; n < entry.length; ++n)
								{
									if (entry[n] != cmp[n])
										same = false;
								}
								if (same)
								{
									// remove the item in question, and reset the index because the other items
									// move up where the removed item was
									remove(idx2);
									--idx2;
								}
							}
						}
					}
				}
				else if (type == long.class)
				{
					for (int idx = 0; idx < size(); ++idx)
					{
						long[] entry = (long[])this.get(idx);
						for (int idx2 = idx + 1; idx2 < size(); ++idx2)
						{
							long[] cmp = (long[])this.get(idx2);
							if (entry.length == cmp.length)
							{
								boolean same = true;
								for (int n = 0; n < entry.length; ++n)
								{
									if (entry[n] != cmp[n])
										same = false;
								}
								if (same)
								{
									remove(idx2);
									--idx2;
								}
							}
						}
					}
				}
				else
				{
					// add support for types as needed ...
					throw new UnsupportedOperationException("Unknown type " + type.toString());
				}
			}
			else
			{
				// if T is not a primitive Array TreeSet can do the work
				TreeSet<T> tmp = new TreeSet<T>();
				for (int i = 0; i < this.size(); ++i)
				{
					// just try to copy all items into the tree and remove if insert does not work (duplicate)
					if (false == tmp.add(this.get(i)))
						this.remove(i);
				}
			}
		}
		catch(IndexOutOfBoundsException ex)
		{
			// if there are not entries, there are no duplicates either
			return;
		}
	}
}
