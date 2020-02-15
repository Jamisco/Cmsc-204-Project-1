package _solution;

public class NoLowerAlphaException extends Exception
{

	private static String message = 
			"The password must contain at least one lowercase alphabetic character";
	
	public NoLowerAlphaException()
	{
		super(message);
	}
	
	public String getMessage()
	{
		return message;
	}
}
