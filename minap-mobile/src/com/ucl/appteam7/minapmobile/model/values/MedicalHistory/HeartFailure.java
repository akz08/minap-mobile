package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class HeartFailure extends Value {
	private static byte heartFailure;
	private static String heartFailureLongCode;
	public HeartFailure() {	
		super("2.13", "A previously validated diagnosis of heart failure on any therapeutic regime.",
				"Heart Failure");
	}
	public static boolean setHeartFailure(byte hFailure) {
		// check if valid entry
		if (hFailure == 0 || hFailure == 1 || hFailure == 9) {
			heartFailure = hFailure;
			switch (heartFailure) {
			case 0 : heartFailureLongCode = "No"; break;
			case 1 : heartFailureLongCode = "Yes"; break;
			case 9 : heartFailureLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getHeartFailure() {
		return Byte.toString(heartFailure) + " - " + heartFailureLongCode;
	}
	
	public static String getLongCode() {
		return heartFailureLongCode;
	}
}
