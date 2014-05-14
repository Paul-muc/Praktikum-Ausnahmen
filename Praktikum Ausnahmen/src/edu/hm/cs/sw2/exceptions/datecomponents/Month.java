package edu.hm.cs.sw2.exceptions.datecomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import edu.hm.cs.sw2.exceptions.HelperClass;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IllegalMonthException;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IsFutureDateException;

public final class Month
{

	private Integer month;

	public Month(Calendar rightNow, Year birthYear)
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

	private int requestBirthMonth(Calendar rightNow, Year birthYear)
	{
		System.out.println("Bitte gib deinen Geburtsmonat ein:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		try
		{
			input = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e)
		{
			System.out.println("Ouch, das war keine Zahl!!!");
			HelperClass.wait(50);
			e.printStackTrace();
			HelperClass.wait(50);
			input = requestBirthMonth(rightNow, birthYear);

		} catch (IOException e)
		{
			e.printStackTrace();
			input = requestBirthMonth(rightNow, birthYear);
		}
		if (input > 12 || input < 1)
		{
			try
			{
				throw new IllegalMonthException();
			} catch (IllegalMonthException e)
			{
				e.printStackTrace();
				HelperClass.wait(50);
				input = requestBirthMonth(rightNow, birthYear);
			}
		}
		//WARUM FÄNGT DER MONAT BEI 0 AN?!
		if (birthYear.getYear() == rightNow.get(Calendar.YEAR)
				&& input > rightNow.get(Calendar.MONTH)+1)
		{
			try
			{
				throw new IsFutureDateException(HelperClass.outputFutureHelper(this));
			} catch (IsFutureDateException e)
			{
				HelperClass.wait(HelperClass.HELP_SECONDS);
				e.printStackTrace();
				HelperClass.wait(HelperClass.HELP_SECONDS);
				input = requestBirthMonth(rightNow, birthYear);
			}
		}

		return input;
	}

	public String toString()
	{
		// return String.format("%d", this.month);
		return month.toString();
	}

}
