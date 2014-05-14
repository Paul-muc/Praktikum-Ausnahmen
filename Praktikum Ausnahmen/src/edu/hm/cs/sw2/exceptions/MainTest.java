package edu.hm.cs.sw2.exceptions;

import java.util.Calendar;

import edu.hm.cs.sw2.exceptions.datecomponents.Day;
import edu.hm.cs.sw2.exceptions.datecomponents.Month;
import edu.hm.cs.sw2.exceptions.datecomponents.Year;

public class MainTest
{

	public static void main(String[] args)
	{

		Calendar rightNow = Calendar.getInstance();
		
		
		Year year = new Year(rightNow);
		Month month = new Month(rightNow, year);
		Day day = new Day(rightNow, year, month);
		
		HelperClass.outputMain(year, month, day);
		
	}

}
