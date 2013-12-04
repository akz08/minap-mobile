package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class PreviousCABG extends Value {
	private static byte previousCABG;
	private static String previousCABGLongCode;
	public PreviousCABG() {	
		super("2.19", "Coronary artery bypass grafting at any time prior to this admission.");
	}
	public static void setPreviousPCI(byte pCABG) {
		// check if valid entry
		if (pCABG == 0 || pCABG == 1 || pCABG == 9) {
			pCABG = previousCABG;
			switch (previousCABG) {
			case 0 : previousCABGLongCode = "No"; break;
			case 1 : previousCABGLongCode = "Yes"; break;
			case 9 : previousCABGLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
