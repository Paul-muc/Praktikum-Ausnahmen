package edu.hm.cs.sw2.exceptions.exceptionclasses;

public class IllegalDayEsception extends Exception
{
	public IllegalDayEsception(){
		super("Der Tag existiert nicht.");
		System.out.println("Eigegebener Tag existiert nicht!");
		
	}
}
