package edu.hm.cs.sw2.exceptions;

import edu.hm.cs.sw2.exceptions.datecomponents.Day;
import edu.hm.cs.sw2.exceptions.datecomponents.Month;
import edu.hm.cs.sw2.exceptions.datecomponents.Year;

/**
 * Contains helper methods such as wait.
 * 
 * @author Veronika Thurner
 * 
 */
public class HelperClass
{

	public final static int HELP_SECONDS = 50;

	/**
	 * Wait for a specified number of milliseconds before finishing. This
	 * provides an easy way to specify a small delay which can be used when
	 * producing animations.
	 * 
	 * @param milliseconds
	 *            the number
	 */
	public static void wait(int milliseconds)
	{
		try
		{
			Thread.sleep(milliseconds);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @param year
	 *            birth year
	 * @param month
	 *            birth month
	 * @param day
	 *            birth day
	 */
	public static void outputMain(Year year, Month month, Day day)
	{
		System.out.println("Du hast am " + day.getDay() + ". "
				+ month.getMonth() + ". " + year.getYear() + " Geburtstag.");
	}

	/**
	 * Takes any object and return the class name.
	 * 
	 * @param object
	 * @return the class name
	 */
	public static String getClassName(Object object)
	{

		String input = object.getClass().toString();
		return input.substring(input.lastIndexOf('.') + 1);
	}

	private static String translateClassName(Object object)
	{
		String input = HelperClass.getClassName(object);
		String output;

		switch (input)
		{
		case "Year":
			output = "Jahr";
			return output;
		case "Day":
			output = "Tag";
			return output;
		case "Month":
			output = "Monat";
			return output;
		default:
			return "Fehler in der helperString Methode!";
		}

	}

	private static String endingHelper(Object object)
	{
		String input = HelperClass.getClassName(object);
		String output;

		switch (input)
		{
		case "Year":
			output = "s";
			return output;
		case "Day":
		case "Month":
			output = "r";
			return output;
		default:
			return "Fehler in der helperString Methode!";
		}
	}

	public static String outputFutureHelper(Object object)
	{
		return "Eingegebene" + endingHelper(object) + " "
				+ translateClassName(object)
				+ " liegt in der Zukunft, kann nicht dein Geburts"
				+ translateClassName(object).toLowerCase() + " sein!";
	}

}
