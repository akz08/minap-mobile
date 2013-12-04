package com.team7.minap.datacollection.values.page5;

import com.team7.minap.datacollection.values.Value;

public class Weight extends Value {
	private static double weight;
	public Weight() {	
		super("2.30", "Weight in kgs to derive BMI.");
	}
		// check if valid entry
	public static void setWeight (double w){
		if (0.00<=w && w<=999.99){
			w = weight;
		}
		else{
			System.out.println("Invalid Entry");
		// set additional fields to visible here
		}
	}
	
	
}
