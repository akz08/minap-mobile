package com.ucl.appteam7.minapmobile.model.values.Angiography;

import com.ucl.appteam7.minapmobile.model.Value;

public class AngioDelay extends Value {
	private static byte angioDelay;
	private static String angioDelayLongCode;
	public AngioDelay() {	
		super("4.30", "This field serves to determine reasons behind delays in patients being referred for or having an angiogram following an admission with nSTEMI. "
				+ "The NICE guideline suggest a maximum acceptable delay to angiogram mximum of 96 hours from admission. ",
				"Delay To Performance Of Angiogram");
	}
	public static boolean setAngioDelay(byte aDelay) {
		// check if valid entry
		if (aDelay == 0 || aDelay == 1 || aDelay == 2 || aDelay == 3 || aDelay == 8 || aDelay == 9) {
			angioDelay = aDelay;
			switch (angioDelay) {
			case 0 : angioDelayLongCode = "None"; break; //Angiogram performed within 96 hours from arrival at the first hospital
			case 1 : angioDelayLongCode = "Delay due to comorbid clinical condition/ competing clinical issue"; break; //For example an infection, barrier nursing, active bleeding.
			case 2 : angioDelayLongCode = "Capacity issues"; break;//Might include delayed transfer to the interventional hospital 		
			case 3 : angioDelayLongCode = "Patient preference"; break;
			case 8 : angioDelayLongCode = "Other"; break;
			case 9 : angioDelayLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getAngioDelay() {
		return Byte.toString(angioDelay) + " - " + angioDelayLongCode;
	}
	
	public static String getLongCode() {
		return angioDelayLongCode;
	}
}
