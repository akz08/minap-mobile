/** Field 2.23 - Place First 12 Lead ECG Performed
 * Takes in a single number (as a byte) that represents the place the patient's first ECG was performed
 * This field's valid options are 
 * 1 - Ambulance
 * 2 - In Hospital
 * 3 - Other Healthcare Facility
 * 9 - Unknown
 * This field is not checked as part of sanity checks
 * @param fECG
 */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.model.Value;

public class FirstECG extends Value {

	private static byte firstECG; // Field 2.23
	private static String ecgLongCode; // to set field's long code value
	
	public FirstECG() {
		super("2.23", "This refers to the 1st ECG recorded, not necessarily the diagnostic ECG.",
				"Place First 12 Lead ECG Performed");
	}
	
	public static boolean setFirstECG(byte fECG) {
		// check if valid entry
		if (fECG == 1 || fECG == 2 || fECG == 3 || fECG == 9) {
			firstECG = fECG;
			switch (fECG) {
			case 1 : ecgLongCode = "Ambulance"; break;
			case 2 : ecgLongCode = "In Hospital"; break;
			case 3 : ecgLongCode = "Other Healthcare Facility"; break;
			case 9 : ecgLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getFirstECG() {
		return Byte.toString(firstECG) + " - " + ecgLongCode;
	}
	
	public static String getLongCode() {
		return ecgLongCode;
	}
}
