/** Field 1.10 - Patient post code
 * Takes in an alphanumeric string that represents a patient's post code.
 * pCode must be 8 characters long. This field is encrypted.
 * Checked when exiting field as part of sanity checks. Must be either fixed or left blank.
 * @param pCode
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.model.Value;

public class PatientPostcode extends Value{
	
	private static String postCode; // field 1.10
	public static final short VAL_LENGTH = 8; // maximum length for pCode
	public PatientPostcode() {	
		super("1.10", "The postcode of the address nominated by the patient "
				+ "as their main permanent residence. Use pseudo postcodes for visitors."
				, "Full Postcode");
	}
	
	public static boolean setPostcode(String pCode) {
		// length check
		if (pCode.length() <= VAL_LENGTH && (pCode.matches("[a-zA-Z]+[0-9]+[a-zA-Z]*[ ][0-9][a-zA-Z]+") || pCode.matches("zz99"))) {
			postCode = pCode;
			return true;
		}
		else
			return false;
	}
	
	public static String getPostcode() {
		return postCode;
	}
}

