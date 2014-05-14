package edu.hm.cs.sw2.exceptions.datecomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import edu.hm.cs.sw2.exceptions.HelperClass;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IllegalDayEsception;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IsFutureDateException;

public final class Day
{

	private final Integer day;

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

	private int requestBirthDay(Calendar rightNow, Year year, Month month)
	{
		System.out.println("Bitte gib dein Geburtstag ein:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		try
		{
			input = Integer.parseInt(in.readLine());
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
		}

		if (!validateDay(input, year.getYear(), month.getMonth()))
		{
			try
			{
				throw new IllegalDayEsception();
			} catch (IllegalDayEsception e)
			{
				System.out.println("Eigegebener Tag existiert nicht!");
				HelperClass.wait(HelperClass.TIME_TO_WAIT);
				e.printStackTrace();
				HelperClass.wait(HelperClass.TIME_TO_WAIT);
				input = requestBirthDay(rightNow, year, month);
			}
		}

		if (year.getYear() == rightNow.get(Calendar.YEAR)
				&& month.getMonth() == rightNow.get(Calendar.MONTH) + 1
				&& input > rightNow.get(Calendar.DAY_OF_MONTH))
		{
			try
			{
				throw new IsFutureDateException(HelperClass.outputFutureHelper(this));
			} catch (IsFutureDateException e)
			{
				e.printStackTrace();
				HelperClass.wait(HelperClass.TIME_TO_WAIT);
				input = requestBirthDay(rightNow, year, month);
			}
		}

		return input;
	}

	private boolean validateDay(int day, int birthYear, int birthMonth)
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

	private boolean isLeapYear(int year)
	{
		if ((((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public String toString()
	{
		// return String.format("%d", this.day);
		return day.toString();
	}
}
