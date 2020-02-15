package _solution;

import java.util.ArrayList;

public class PasswordCheckerUtility
{
	public static boolean isValidPassword(String password) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException
	{
		boolean hasDigit = false;
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean goodSequence = true;
		int sequenceCount = 1;
		Character previousLetter = null;

		if(password.length() >= 6) // length greater than 6
		{
			for (Character letter : password.toCharArray())
			{
				if(Character.isDigit(letter) && hasDigit == false)
				{
					hasDigit = true;
				}

				if(Character.isUpperCase(letter) && hasUpper == false)
				{
					hasUpper = true;
				}

				if(Character.isLowerCase(letter) && hasLower == false)
				{
					hasLower = true;
				}

				if(letter == previousLetter)
				{
					sequenceCount++;

					if(sequenceCount == 3)
					{
						goodSequence = false;
					}
				}
				else
				{
					sequenceCount = 1;
				}

				previousLetter = letter;
			}

			if(hasUpper == false)
			{
				throw new NoUpperAlphaException();
			}

			if(hasLower == false)
			{
				throw new NoLowerAlphaException();
			}

			if(hasDigit == false)
			{
				throw new NoDigitException();
			}

			if(goodSequence == false)
			{
				throw new InvalidSequenceException();
			}
		}
		else
		{
			throw new LengthException();
		}

		return true;
	}

	public static boolean isWeakPassword(String password)
	{
		if(password.length() >= 6 && password.length() < 9)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static ArrayList<String> invalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidPasswords= new ArrayList<String>();

		for (String password : passwords)
		{
			String message = isValid(password);
			
			if(!message.equals("Valid"))
			{
				invalidPasswords.add(password + " " + message);
			}
		}
		
		return invalidPasswords;
	}

	private static String isValid(String password)
	{
		boolean hasDigit = false;
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean goodSequence = true;
		int sequenceCount = 1;
		Character previousLetter = null;

		for (Character letter : password.toCharArray())
		{
			if(Character.isDigit(letter) && hasDigit == false)
			{
				hasDigit = true;
			}

			if(Character.isUpperCase(letter) && hasUpper == false)
			{
				hasUpper = true;
			}

			if(Character.isLowerCase(letter) && hasLower == false)
			{
				hasLower = true;
			}

			if(letter == previousLetter)
			{
				sequenceCount++;

				if(sequenceCount == 3)
				{
					goodSequence = false;
				}
			}
			else
			{
				sequenceCount = 1;
			}

			previousLetter = letter;
		}

		if(hasUpper == false)
		{
			return new NoUpperAlphaException().getMessage();
		}

		if(hasLower == false)
		{
			return new NoLowerAlphaException().getMessage();
		}

		if(hasDigit == false)
		{
			return new NoDigitException().getMessage();
		}

		if(goodSequence == false)
		{
			return new InvalidSequenceException().getMessage();
		}

		return "Valid"; // THIS CODE SHOULD NEVER RUN
	}

}
