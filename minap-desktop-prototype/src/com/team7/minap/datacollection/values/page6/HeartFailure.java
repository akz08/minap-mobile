package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class HeartFailure extends Value {
	private static byte heartFailure;
	private static String heartFailureLongCode;
	public HeartFailure() {	
		super("2.13", "A previously validated diagnosis of heart failure on any therapeutic regime.");
	}
	public static void setHeartFailure(byte hFailure) {
		// check if valid entry
		if (hFailure == 0 || hFailure == 1 || hFailure == 9) {
			hFailure = heartFailure;
			switch (heartFailure) {
			case 0 : heartFailureLongCode = "No"; break;
			case 1 : heartFailureLongCode = "Yes"; break;
			case 9 : heartFailureLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
