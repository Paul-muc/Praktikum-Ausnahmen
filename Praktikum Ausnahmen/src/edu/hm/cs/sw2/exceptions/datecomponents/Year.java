package edu.hm.cs.sw2.exceptions.datecomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import edu.hm.cs.sw2.exceptions.HelperClass;
import edu.hm.cs.sw2.exceptions.exceptionclasses.IsFutureDateException;

public final class Year
{
	private Integer year;

	public Year(Calendar rightNow)
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

	private int requestBirthYear(Calendar rightNow)
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
