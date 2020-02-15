package _solution;

public class InvalidSequenceException extends Exception
{
	private static String message = 
			"The password cannot contain more than two of the same character in sequence";

	public InvalidSequenceException()
	{
		super(message);
	}
	
	public String getMessage()
	{
		return message;
	}

}
