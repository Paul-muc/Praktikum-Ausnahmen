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
		} catch (NumberFormatException e)
		{
			System.out.println("Ouch, das war keine Zahl!!!");
			HelperClass.wait(HelperClass.HELP_SECONDS);
			e.printStackTrace();
			HelperClass.wait(HelperClass.HELP_SECONDS);
			input = requestBirthYear(rightNow);

		} catch (IOException e)
		{
			e.printStackTrace();
			 input = requestBirthYear(rightNow);
		}
		if(input>rightNow.get(Calendar.YEAR)){
			try
			{
				throw new IsFutureDateException(HelperClass.outputFutureHelper(this));
			} catch (IsFutureDateException e)
			{
				
				//System.out.println(HelperClass.outputFutureHelper(this));
				HelperClass.wait(HelperClass.HELP_SECONDS);
				e.printStackTrace();
				HelperClass.wait(HelperClass.HELP_SECONDS);
				input = requestBirthYear(rightNow);
			}
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
