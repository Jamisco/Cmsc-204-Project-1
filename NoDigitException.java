package _solution;

public class NoDigitException extends Exception
{

	private static String message = "The password must contain at least one digit";
			
	public NoDigitException()
	{
		super(message);
	}
	
	public String getMessage()
	{
		return message;
	}
}
