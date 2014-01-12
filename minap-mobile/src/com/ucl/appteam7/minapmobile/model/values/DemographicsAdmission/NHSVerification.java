/** No Field number - NHS verificationication
 * Takes in a single number (as a byte) that represents the patient's NHS verificationication status
 * This field's valid options are
 * 1 - Number present and verificationied
 * 2 - Number present but not traced
 * 3 - Trace required
 * 4 - Trace attempted - No match or multiple match found
 * 5 - Trace needs to be resolved - (NHS Number or patient data conflict)
 * 6 - Trace in progress
 * 7 - Number not present and trace not required
 * 8 - Trace postponed (baby under six weeks old)
 * @param verif
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.Value;

public class NHSVerification extends Value {

	private static byte verification; // Field 1.13
	private static String verificationLongCode; // to set field's long code value
	
	public NHSVerification() {
		super(" ", " ");
	}
	
	public static boolean setVerification(byte verif) {
		// check if valid entry
		if (verif >= 1 && verif <= 8) {
			verification = verif;
			switch (verification) {
			case 1 : verificationLongCode = "Number present and verificationied"; break;
			case 2 : verificationLongCode = "Number present but not traced"; break;
			case 3 : verificationLongCode = "Trace required"; break;
			case 4 : verificationLongCode = "Trace attempted - No match or multiple match found"; break;
			case 5 : verificationLongCode = "Trace needs to be resolved - (NHS Number or patient data conflict)"; break;
			case 6 : verificationLongCode = "Trace in progress"; break;
			case 7 : verificationLongCode = "Number not present and trace not required"; break;
			case 8 : verificationLongCode = "Trace postponed (baby under six weeks old)"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getVerification() {
		return Byte.toString(verification) + " - " + verificationLongCode;
	}
	
	public static String getLongCode() {
		return verificationLongCode;
	}
}
