package _solution;

public class UnmatchedException extends Exception
{
	private static String message = "The passwords do not match";
	
	public UnmatchedException()
	{
		super(message);
	}
}
