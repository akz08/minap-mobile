package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class PreviousAMI extends Value {
	private static byte previousAMI;
	private static String previousAMILongCode;
	public PreviousAMI() {	
		super("2.05", "Symptoms due to cardiac ischaemia developing or already in existence at least two weeks prior to admission, and continuing up to admission.",
				"Previous AMI");
	}
	public static boolean setPreviousAMI(byte pAMI) {
		// check if valid entry
		if (pAMI == 0 || pAMI == 1 || pAMI == 9) {
			previousAMI = pAMI;
			switch (previousAMI) {
			case 0 : previousAMILongCode = "No"; break;
			case 1 : previousAMILongCode = "Yes"; break;
			case 9 : previousAMILongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getPreviousAMI() {
		return Byte.toString(previousAMI) + " - " + previousAMILongCode;
	}
	
	public static String getLongCode() {
		return previousAMILongCode;
	}
}
