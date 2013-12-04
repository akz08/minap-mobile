package com.team7.minap.datacollection.values.page5;

import com.team7.minap.datacollection.values.Value;

public class Height extends Value {
	private static double height;
	public Height() {	
		super("2.29", "Height in cms to derive BMI.");
	}
		// check if valid entry
	public static void setHeight (double h){
		if (0.00<=h && h<=999.99){
			h = height;
			}
		else{
			System.out.println("Invalid Entry");
		// set additional fields to visible here
		}
	}
	
	
}
