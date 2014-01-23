/**
 * This field has no sanity checks associated with it
 */

package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class ChronicRenalFailure extends Value {
	private static byte chronicRenalFailure;
	private static String chronicRenalFailureLongCode;
	public ChronicRenalFailure() {	
		super("2.12", "Any form of obstructive airways disease.",
				"Chronic Renal Failure");
	}
	public static boolean setRenalFailure(byte cRenalFailure) {
		// check if valid entry
		if (cRenalFailure == 0 || cRenalFailure == 1 || cRenalFailure == 9) {
			chronicRenalFailure = cRenalFailure;
			switch (cRenalFailure) {
			case 0 : chronicRenalFailureLongCode = "No"; break;
			case 1 : chronicRenalFailureLongCode = "Yes"; break;
			case 9 : chronicRenalFailureLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getRenalFailure() {
		return Byte.toString(chronicRenalFailure) + " - " + chronicRenalFailureLongCode;
	}
	
	public static String getLongCode() {
		return chronicRenalFailureLongCode;
	}
}
