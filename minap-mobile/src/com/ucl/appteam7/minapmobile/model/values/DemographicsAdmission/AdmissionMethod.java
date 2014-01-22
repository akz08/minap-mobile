/** Field 2.39 - Admission Method
 * Takes in a single number (as a byte) that represents the patient's admission method
 * This field's valid options are
 * 1 - Direct admission via emergency service
 * 2 - Self presenter to this hospital
 * 3 - Already in this hospital
 * 4 - Inter-hospital transfer for specific treatment
 * 5 - Repatriation after coronary intervention
 * 6 - Other
 * 9 - Unknown
 * If admissionMethod != 4, Referral Hospital (4.21) must be blank. Checked when exiting field.
 * @param admMethod
 * @author david
 */

/* If AdmissionMethod = 4, display referral hospital field. Hide and set to blank otherwise */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.model.Value;

public class AdmissionMethod extends Value {

	private static byte admissionMethod; // Field 2.39
	private static String admissionLongCode; // to set field's long code value
	
	public AdmissionMethod() {
		super("2.39", " ",
				"Admission Method");
	}
	
	public static boolean setAdmissionMethod(byte admMethod) {
		// check if valid entry
		if (admMethod == 1 || admMethod == 2 || admMethod == 3 || admMethod == 4 || admMethod == 5 || admMethod == 6 || admMethod == 9) {
			admissionMethod = admMethod;
			switch (admMethod) {
			case 1 : admissionLongCode = "Direct admission via emergency service"; break;
			case 2 : admissionLongCode = "Self presenter to this hospital"; break;
			case 3 : admissionLongCode = "Already in this hospital"; break;
			case 4 : admissionLongCode = "Inter-hospital transfer for specific treatment"; break;
			case 5 : admissionLongCode = "Repatriation after coronary intervention"; break;
			case 6 : admissionLongCode = "Other"; break;
			case 9 : admissionLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getAdmissionMethod() {
		return Byte.toString(admissionMethod) + " - " + admissionLongCode;
	}
	
	public static String getLongCode() {
		return admissionLongCode;
	}
}
