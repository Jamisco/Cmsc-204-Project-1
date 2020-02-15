package _solution;

public class NoUpperAlphaException extends Exception
{
	private static String message =
			"The password must contain at least one uppercase alphabetic character";
	
	public NoUpperAlphaException()
	{
		super(message);
	}
	
	public String getMessage()
	{
		return message;
	}
}
