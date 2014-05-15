package edu.hm.cs.sw2.exceptions.datecomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import edu.hm.cs.sw2.exceptions.HelperClass;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IsFutureDateException;

/**
 * Represents the birth year.
 *
 * @author Paul Seer
 *
 */
public final class Year
{
	/**
	 * Birth year.
	 */
	private Integer year;

	/**
	 * This constructs a new birth year.
	 *
	 * @param Calendar
	 *            right now.
	 */
	public Year(final Calendar rightNow)
	{
		this.year = requestBirthYear(rightNow);
	}

	/**
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * Make user request on the console and proves the input. Throws exception:
	 * -IsFutureDateException if year is in the future -NumberFormatException if
	 * input is no integer. -IOException If an input or output exception
	 * occurred
	 * 
	 * @param Calendar
	 *            is a calendar made by the user.
	 * @return birth year as a integer
	 */
	private int requestBirthYear(final Calendar rightNow)
	{
		System.out.println("Bitte gib dein Geburtsjahr ein:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;

		try
		{
			input = Integer.parseInt(in.readLine());
			if (input > rightNow.get(Calendar.YEAR))
			{
				throw new IsFutureDateException(
						HelperClass.outputFutureHelper(this));
			}

		} catch (NumberFormatException e)
		{
			System.out.println("Ouch, das war keine Zahl!!!");
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			e.printStackTrace();
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			input = requestBirthYear(rightNow);

		} catch (IOException e)
		{
			e.printStackTrace();
			input = requestBirthYear(rightNow);
		} catch (IsFutureDateException e)
		{
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			e.printStackTrace();
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			input = requestBirthYear(rightNow);
		}
		return input;
	}

	@Override
	public String toString()
	{
		// return String.format("%d", this.year);
		return year.toString();
	}

}
