package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class PreviousAMI extends Value {
	private static byte previousAMI;
	private static String previousAMILongCode;
	public PreviousAMI() {	
		super("2.06", "Symptoms due to cardiac ischaemia developing or already in existence at least two weeks prior to admission, and continuing up to admission.");
	}
	public static void setPreviousAMI(byte pAMI) {
		// check if valid entry
		if (pAMI == 0 || pAMI == 1 || pAMI == 9) {
			pAMI = previousAMI;
			switch (previousAMI) {
			case 0 : previousAMILongCode = "No"; break;
			case 1 : previousAMILongCode = "Yes"; break;
			case 9 : previousAMILongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
