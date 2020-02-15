package _solution;

public class LengthException extends Exception
{
	private static String message = "The password must be at least 6 characters long";

	public LengthException()
	{
		super(message);
	}
	
	public String getMessage()
	{
		return message;
	}
}
