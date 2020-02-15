package _solution;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author
 *
 */
public class PasswordCheckerSTUDENT_Test
{

	@Before
	public void setUp() throws Exception
	{

	}

	@After
	public void tearDown() throws Exception
	{

	}

	/**
	 * Test if the password is less than 8 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		assertThrows(LengthException.class,
				() -> PasswordCheckerUtility.isValidPassword("1234567"));
		// The according to Program specification a "Weak Password" is still Valid
		// So "isValidPassword" will always make this assertion to be false, 
		// if you meant "Less Tahn 6", you can just delete 2 numbers, I tested it, it will assert True
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		assertThrows(NoUpperAlphaException.class,
				() -> PasswordCheckerUtility.isValidPassword("hellothere"));
		
	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		assertThrows(NoLowerAlphaException.class, 
				() -> PasswordCheckerUtility.isValidPassword("HELLOTHERE2"));
			
	}

	////PROFESSORR!!! --- THE BELOW CODE REPEAT ITSELF, YOU CAN UNCOMMENT IT TO STILL RUN IT,,////////
	
//	/**
//	 * Test if the password has more than 2 of the same character in sequence This
//	 * test should throw a InvalidSequenceException for second case
//	 */
//	@Test
//	public void testIsWeakPassword()
//	{
////		assertThrows(LengthException.class, 
////				() -> PasswordCheckerUtility.isValidPassword("2short"));
////		
////		assertThrows(InvalidSequenceException.class, 
////				() -> PasswordCheckerUtility.isValidPassword("HellOOOThere2"));
//		
//	}

	// -----------------------------------------
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		assertThrows(InvalidSequenceException.class,
				() -> PasswordCheckerUtility.isValidPassword("hELLOOOOTHERE2"));
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		assertThrows(NoDigitException.class, () -> PasswordCheckerUtility.isValidPassword("HelloThere"));
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("ValidPassWord2"));
		}
		catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
				| InvalidSequenceException e)
		{
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the invalidPasswords method
	 */
	@Test
	public void testValidPasswords()
	{
		ArrayList<String> badPasswords = new ArrayList<String>();
		ArrayList<String> returnList = new ArrayList<String>(); 
		
		badPasswords.add("hellothere2"); // no uppercase
		badPasswords.add("HELLOTHERE2"); // no lower case
		badPasswords.add("HelloThere"); //no digit
		badPasswords.add("HelloooThere2"); //bad Sequence
		badPasswords.add("GoodPassword2"); // good password - shouldnt show in output
		
		returnList = PasswordCheckerUtility.invalidPasswords(badPasswords);
		
		for(String pass: returnList)
		{
			System.out.println(pass);
		}
		
		if(returnList.size() != 4) //there are 4 bad passwords
		{
			fail("Did not catch all bad passwords. Only caught " + returnList.size() + " passwords");
		}
	}

}
