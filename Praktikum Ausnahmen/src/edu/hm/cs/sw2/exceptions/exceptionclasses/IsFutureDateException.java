/**
 * 
 */
package edu.hm.cs.sw2.exceptions.exceptionclasses;

import edu.hm.cs.sw2.exceptions.HelperClass;

/**
 * @author Paul
 * 
 */
public class IsFutureDateException extends Exception
{

	/**
	 * 
	 */
	public IsFutureDateException()
	{

	}

	public IsFutureDateException(String s)
	{
		super(s);

		System.out.println(s);

	}

}
