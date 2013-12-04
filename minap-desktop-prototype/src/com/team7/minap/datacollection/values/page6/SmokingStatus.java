package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class SmokingStatus extends Value {
	private static byte smokingStatus;
	private static String smokingStatusLongCode;
	public SmokingStatus() {	
		super("2.16", " ");
	}
	public static void setSmokingStatus(byte sStatus) {
		// check if valid entry
		if (sStatus == 0 || sStatus == 1 || sStatus == 2 || sStatus == 3 || sStatus == 9) {
			sStatus = smokingStatus;
			switch (smokingStatus) {
			case 0 : smokingStatusLongCode = "Never smoked"; break; //Patient has never smoked.
			case 1 : smokingStatusLongCode = "Ex smoker"; break; //An ex smoker is one who has given up smoking more than one month previously.
			case 2 : smokingStatusLongCode = "Current smoker"; break; //A current smoker is a patient regularly smoking an average of 1 or more cigarettes per day, or equivalent. 
																	//Any cigarettes smoked in the last month classify the patient as a current smoker.
			case 3 : smokingStatusLongCode = "Non smoker - smoking history unknown"; break;//Currently a non smoker but past history unknown.
			case 9 : smokingStatusLongCode = "Unknown"; break;//Smoking status unknown.
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
