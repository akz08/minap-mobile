package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class PreviousPCI extends Value {
	private static byte previousPCI;
	private static String previousPCILongCode;
	public PreviousPCI() {	
		super("2.18", "A percutaneous coronary intervention at any time prior to this admission.");
	}
	public static void setPreviousPCI(byte pPCI) {
		// check if valid entry
		if (pPCI == 0 || pPCI == 1 || pPCI == 9) {
			pPCI = previousPCI;
			switch (previousPCI) {
			case 0 : previousPCILongCode = "No"; break;
			case 1 : previousPCILongCode = "Yes"; break;
			case 9 : previousPCILongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
