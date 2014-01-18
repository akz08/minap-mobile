/** Field 1.04 - Patient surname
 * Takes in an alphanumeric string that represents a patient's surname(s).
 * sName must be no more than 35 characters long. This field is encrypted
 * @param sName
 * @author david
 */
	
package com.ucl.appteam7.minapmobile.model.values.PatientInfo;

import com.ucl.appteam7.minapmobile.model.Value;

public class PatientSurname extends Value {
	
	private static String surname; // field 1.04
	public static final short VAL_LENGTH = 35; // maximum length for surname
	
	public PatientSurname() {	
		super("1.04", " "); 
	}
	
	public static boolean setSurname(String sName) {
		// length check
		if (sName.length() <= VAL_LENGTH && sName.matches("[a-zA-Z0-9]+")) {
			surname = sName;
			return true;
		}
		else
			return false;		
	}
	
	public static String getSurname() {
		return surname;
	}
}
