package com.team7.minap.datacollection.values.page5;

import com.team7.minap.datacollection.values.Value;

public class SystolicBloodPressure extends Value {
	private static double systolicBP;
	public SystolicBloodPressure() {	
		super("2.20", "The first systolic blood pressure recorded after admission to hospital. "
				+ "The patient should be in a stable cardiac rhythm, ie sinus or chronic AF.  "
				+ "Where the presenting rhythm is a treatable tachyarrhythmia, "
				+ "the first stable SBP after treatment should be used.");
	}
		// check if valid entry
	public static void setSystolicBP (double sBP){//2.20, n3, systolic blood pressure
		if (0.00<=sBP && sBP<=999.99){
			systolicBP = sBP;
			}
		else{
			System.out.println("Invalid Entry");
		// set additional fields to visible here
		}
	}
	
	
}
