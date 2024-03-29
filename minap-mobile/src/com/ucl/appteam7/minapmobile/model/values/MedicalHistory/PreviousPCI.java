/**
 * If Previous PCI = 1 and Previous Angina = 0 and Previous AMI = 0, throw warning.
 * You have said the patient has no history of coronary disease but had a previous intervention - please check these values.
 * Must be checked when exiting field.
 */

package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class PreviousPCI extends Value {
	private static byte previousPCI;
	private static String previousPCILongCode;
	public PreviousPCI() {	
		super("2.18", "A percutaneous coronary intervention at any time prior to this admission.",
				"Previous PCI");
	}
	public static boolean setPreviousPCI(byte pPCI) {
		// check if valid entry
		if (pPCI == 0 || pPCI == 1 || pPCI == 9) {
			previousPCI = pPCI;
			switch (previousPCI) {
			case 0 : previousPCILongCode = "No"; break;
			case 1 : previousPCILongCode = "Yes"; break;
			case 9 : previousPCILongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getPreviousPCI() {
		return Byte.toString(previousPCI) + " - " + previousPCILongCode;
	}
	
	public static String getLongCode() {
		return previousPCILongCode;
	}
}
