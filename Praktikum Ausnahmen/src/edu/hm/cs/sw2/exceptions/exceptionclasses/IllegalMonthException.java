package edu.hm.cs.sw2.exceptions.exceptionclasses;

public class IllegalMonthException extends Exception
{
	public IllegalMonthException(){
		
		System.out.println("Wert f�r Monat muss zwischen 1 und 12 liegen.");
	}
}
