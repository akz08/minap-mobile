package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class PreviousCABG extends Value {
	private static byte previousCABG;
	private static String previousCABGLongCode;
	public PreviousCABG() {	
		super("2.19", "Coronary artery bypass grafting at any time prior to this admission.",
				"Previous CABG");
	}
	public static boolean setPreviousCABG(byte pCABG) {
		// check if valid entry
		if (pCABG == 0 || pCABG == 1 || pCABG == 9) {
			previousCABG = pCABG;
			switch (previousCABG) {
			case 0 : previousCABGLongCode = "No"; break;
			case 1 : previousCABGLongCode = "Yes"; break;
			case 9 : previousCABGLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getPreviousCABG() {
		return Byte.toString(previousCABG) + " - " + previousCABGLongCode;
	}
	
	public static String getLongCode() {
		return previousCABGLongCode;
	}
}
