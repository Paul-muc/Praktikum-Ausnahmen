/**
 * 
 */
package edu.hm.cs.sw2.exceptions.exceptionclasses;

import edu.hm.cs.sw2.exceptions.HelperClass;
/**
 * 
 * Thrown when an application attempts to use a date which is in the future.
 * 
 * @author Paul Seer
 * 
 */
public class IsFutureDateException extends Exception
{

	/**
	 * 
	 * Constructs a IsFutureDateException with message.
	 * 
	 * 
	 * @param input
	 *            is used for the message
	 */
	public IsFutureDateException(String input)
	{
		super(input);
		System.out.println(input);
	}

}
