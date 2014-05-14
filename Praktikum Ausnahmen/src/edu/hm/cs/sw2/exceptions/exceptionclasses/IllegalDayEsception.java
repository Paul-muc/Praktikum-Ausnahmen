package edu.hm.cs.sw2.exceptions.exceptionclasses;

/**
 * 
 * Thrown when requestBirthDay attempts to use a false integer which is out of range.
 *
 * @author Paul Seer
 * 
 */
public class IllegalDayEsception extends Exception
{
	/**
	 * Constructs a IllegalDayEsception with message.
	 */
	public IllegalDayEsception()
	{
		super("Der Tag existiert nicht.");
	}
}
