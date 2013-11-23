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
	
	public static boolean dateCheck() {
		/**
		 * If it is wrong, do the following thing.
		 */
		System.out.println("Date is invalid.");
		//set the date field to blank. And try again.
		return false;
	}
	
	public static boolean rangeCheck(double minimum, double maximum, double value) {
		// checks value is within minimum and maximum range, if not returns false
		if (value >= minimum && value <= maximum)
			return true;
		else {
			System.out.println("Entry is not within range.");
			//set the field to blank.
			return false;
		}
	}
	
	public static boolean typeCheck(String vType, String tType) {
		/** 
		 * If it is wrong, do the following thing.
		 */		
		//this is determine the type of variable 
		if (value1 instanceof String == true){
			vType = "String";
		}
			
		if (value1 instanceof Double == true){
			vType = "Double";
		}
			
		if (value1 instanceof Integer == true){
			vType = "Integer";
		}
		if (value1 instanceof Float == true){
			vType = "Float";
		}
		
	//==================================	
		if (tType.equals(vType)){
			return true;
		}
		else{// if type taken in is not what is expected
			System.out.println("Invalid type");
			// set field to blank
			return false;
		}
}
