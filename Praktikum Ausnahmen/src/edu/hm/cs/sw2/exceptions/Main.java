package edu.hm.cs.sw2.exceptions;

import java.util.Calendar;
import edu.hm.cs.sw2.exceptions.datecomponents.Day;
import edu.hm.cs.sw2.exceptions.datecomponents.Month;
import edu.hm.cs.sw2.exceptions.datecomponents.Year;
/**
 * Entry point for application that request information and print it out on the
 * console.
 *
 * @author Paul Seer
 *
 */
public class Main
{
	public static void main(String[] args)
	{

		// create calendar
		Calendar rightNow = Calendar.getInstance();

		// create request for year, month and Day
		Year year = new Year(rightNow);
		Month month = new Month(rightNow, year);
		Day day = new Day(rightNow, year, month);

		// console output
		HelperClass.outputMain(year, month, day);

	}

}
