package edu.hm.cs.sw2.exceptions.datecomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import edu.hm.cs.sw2.exceptions.HelperClass;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IllegalDayEsception;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IsFutureDateException;

/**
 * Represents the birth day.
 *
 * @author Paul Seer
 *
 */
public final class Day
{
	/**
	 * Birth day
	 */
	private final Integer day;

	/**
	 * This constructs a new birth day.
	 *
	 * @param Calendar
	 *            right now.
	 * @param Year
	 *            birth year
	 * @param Month
	 *            birth month
	 */
	public Day(Calendar rightNow, Year year, Month month)
	{
		this.day = requestBirthDay(rightNow, year, month);
	}

	/**
	 * @return the day
	 */
	public int getDay()
	{
		return day;
	}

	/**
	 * Make user request on the console and proves the input. Throws exception:
	 * -IsFutureDateException if day is in the future -NumberFormatException if
	 * input is no integer. -IOException If an input or output exception
	 * occurred. -IllegalDayEsception if input is out of day range.
	 *
	 * @param Calendar
	 *            is a calendar made by the user.
	 * @param Year
	 *            birth year
	 * @param Month
	 *            birth month
	 * @return birth day as a integer
	 */
	private int requestBirthDay(final Calendar rightNow, final Year year, final Month month)
	{
		System.out.println("Bitte gib dein Geburtstag ein:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		try
		{
			input = Integer.parseInt(in.readLine());
			if (!validateDay(input, year.getYear(), month.getMonth()))
			{
				throw new IllegalDayEsception();
			}

			else if (year.getYear() == rightNow.get(Calendar.YEAR)
					&& month.getMonth() == rightNow.get(Calendar.MONTH) + 1
					&& input > rightNow.get(Calendar.DAY_OF_MONTH))
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
			input = requestBirthDay(rightNow, year, month);

		} catch (IOException e)
		{
			e.printStackTrace();
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			input = requestBirthDay(rightNow, year, month);

		} catch (IllegalDayEsception e)
		{
			System.out.println("Eigegebener Tag existiert nicht!");
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			e.printStackTrace();
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			input = requestBirthDay(rightNow, year, month);

		} catch (IsFutureDateException e)
		{
			e.printStackTrace();
			HelperClass.wait(HelperClass.TIME_TO_WAIT);
			input = requestBirthDay(rightNow, year, month);
		}
		return input;
	}
	/**
	 * whether the day exists.
	 *
	 * @param day
	 * 			birth day.
	 * @param year
	 * 			birth year.
	 * @param month
	 * 			birth month.
	 * @return <code>true</code> if the day exists
	 */
	private boolean validateDay(final int day, final int birthYear, final int birthMonth)
	{
		int maxDays = 0;
		switch (birthMonth)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			maxDays = 30;
			break;
		case 2:
			if (isLeapYear(birthYear))
			{
				maxDays = 29;
				break;
			} else
			{
				maxDays = 28;
				break;
			}
		default:
			System.out.println("Invalid month.");
			break;
		}

		if (day > 0 && day <= maxDays)
		{
			return true;
		}

		return false;
	}
	/**
	 * whether the year is leap year.
	 *
	 * @param year
	 * 			birth year.
	 * @return <code>true</code> if year is leap year
	 */
	private boolean isLeapYear(final int year)
	{
		if ((((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)))
		{
			return true;
		} else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		// return String.format("%d", this.day);
		return day.toString();
	}
}
