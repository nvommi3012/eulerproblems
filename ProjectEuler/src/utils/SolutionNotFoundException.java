package utils;

public class SolutionNotFoundException extends Exception {

	private static final long serialVersionUID = 8233787840505721680L;
	private Class<?> _class;
	private final static String _contents = "No solution could be found";

	public SolutionNotFoundException(Class<?> c) {
		super(_contents);
		_class = c;
	}

	public String toString()
	{
		String s = _class.getName();
		String[] sa = s.split("\\.");
		if (sa != null && sa.length > 0)
			return sa[1] +  ": " + _contents;
		else
			return "Unknown Problem: " + _contents;
	}
}
