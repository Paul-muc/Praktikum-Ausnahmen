package edu.hm.cs.sw2.exceptions.datecomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import edu.hm.cs.sw2.exceptions.HelperClass;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IllegalMonthException;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IsFutureDateException;

/**
 * Represents the birth month.
 *
 * @author Paul Seer
 *
 */
public final class Month
{
	/**
	 * Birth month.
	 */
	private Integer month;

	/**
	 * This constructs a new birth month.
	 *
	 * @param Calendar
	 *            right now.
	 * @param Year
	 *            birth year
	 */
	public Month(final Calendar rightNow, final Year birthYear)
	{

		this.month = requestBirthMonth(rightNow, birthYear);
	}

	/**
	 * @return the month
	 */
	public Integer getMonth()
	{
		return month;
	}

	/**
	 * Make user request on the console and proves the input. Throws exception:
	 * -IsFutureDateException if month is in the future -NumberFormatException
	 * if input is no integer. -IOException If an input or output exception
	 * occurred. -IllegalMonthException if input is out of month range.
	 * 
	 * @param Calendar
	 *            is a calendar made by the user.
	 * @param Year
	 *            birth year
	 * @return birth month as a integer
	 */
	private int requestBirthMonth(final Calendar rightNow, final Year birthYear)
	{
		System.out.println("Bitte gib deinen Geburtsmonat ein:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		try
		{
			input = Integer.parseInt(in.readLine());
			if (input > 12 || input < 1)
			{
				throw new IllegalMonthException();
			} else if (birthYear.getYear() == rightNow.get(Calendar.YEAR)
					&& input > rightNow.get(Calendar.MONTH) + 1)
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
			input = requestBirthMonth(rightNow, birthYear);

		} catch (IOException e)
		{
			e.printStackTrace();
			input = requestBirthMonth(rightNow, birthYear);

		} catch (IllegalMonthException e)
		{
			System.out.println("Wert für Monat muss zwischen 1 und 12 liegen.");
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			e.printStackTrace();
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			input = requestBirthMonth(rightNow, birthYear);

		} catch (IsFutureDateException e)
		{
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			e.printStackTrace();
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			input = requestBirthMonth(rightNow, birthYear);
		}
		return input;
	}

	@Override
	public String toString()
	{
		return month.toString();
	}

}
