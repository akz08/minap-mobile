package com.team7.minap.validation;

import java.util.Date;

public class Validation {
	
	private static boolean isValid() {
		return false;
	}
	
	private static boolean isComplete() {
		return false;
	}
	
	private static void getValue() {
		// call isValid?
	}
	
	private static void setValue() {
		// must call isValid
	}
	
	private static boolean dateCheck(Date date) {
		/**
		 * If it is wrong, do the following thing.
		 */
		System.out.println("DOB is invalid.");
		//set the dob field to blank. And try again.
		return false;
	}
	
	private static boolean rangeCheck() {
		/** 
		 * If it is wrong, do the following thing.
		 */
		System.out.println("Entry is not within range.");
		//set the field to blank.
		return false;
	}
	
	private static boolean typeCheck() {
		/** 
		 * If it is wrong, do the following thing.
		 */
		// if type taken in is not what is expected
		System.out.println("Invalid type");
		// set field to blank
		return false;
	}
}
