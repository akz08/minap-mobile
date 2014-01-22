/** Field 1.05 - Patient forename
 * Takes in an alphanumeric string that represents a patient's forename(s).
 * fName must be no more than 35 characters long. This field is encrypted
 * 
 * This field has no sanity checks associated with it
 * It must be checked when exiting the field
 * @param fName
 * @author david
 */
package com.ucl.appteam7.minapmobile.model.values.PatientInfo;

import com.ucl.appteam7.minapmobile.model.Value;
public class PatientForename extends Value{
	
	private static String forename; // field 1.05
	public static final short VAL_LENGTH = 35; // maximum length for forename
	public PatientForename() {	
		super("1.05", " ");
	}
	
	public static boolean setForename(String fName) {
		// length check
		if (fName.length() <= VAL_LENGTH && fName.matches("[a-zA-Z0-9]+")) {
			forename = fName;
			return true;
		}
		else
			return false;		
	}
	
	public static String getForename() {
		return forename;
	}
}
