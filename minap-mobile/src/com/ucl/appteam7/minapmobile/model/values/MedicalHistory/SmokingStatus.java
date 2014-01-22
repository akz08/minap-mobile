/**
 * This field has no sanity checks associated with it
 */

package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class SmokingStatus extends Value {
	private static byte smokingStatus;
	private static String smokingStatusLongCode;
	public SmokingStatus() {	
		super("2.16", " ",
				"Smoking Status");
	}
	public static boolean setSmokingStatus(byte sStatus) {
		// check if valid entry
		if (sStatus == 0 || sStatus == 1 || sStatus == 2 || sStatus == 3 || sStatus == 9) {
			smokingStatus = sStatus;
			switch (smokingStatus) {
			case 0 : smokingStatusLongCode = "Never smoked"; break; //Patient has never smoked.
			case 1 : smokingStatusLongCode = "Ex smoker"; break; //An ex smoker is one who has given up smoking more than one month previously.
			case 2 : smokingStatusLongCode = "Current smoker"; break; //A current smoker is a patient regularly smoking an average of 1 or more cigarettes per day, or equivalent. 
																	//Any cigarettes smoked in the last month classify the patient as a current smoker.
			case 3 : smokingStatusLongCode = "Non smoker - smoking history unknown"; break;//Currently a non smoker but past history unknown.
			case 9 : smokingStatusLongCode = "Unknown"; break;//Smoking status unknown.
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getSmokingStatus() {
		return Byte.toString(smokingStatus) + " - " + smokingStatusLongCode;
	}
	
	public static String getLongCode() {
		return smokingStatusLongCode;
	}
}
