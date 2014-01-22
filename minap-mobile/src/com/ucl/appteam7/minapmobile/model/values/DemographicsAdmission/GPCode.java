/** Field 1.11 - GP / PCT Code
 * Takes a String that represents the patient's GP/PCT's code.
 * gpctCode must be 6 characters long. This field is encrypted.
 * Checked when focus is lost as part of sanity checks
 * @param gpctCode 
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.model.Value;

public class GPCode extends Value{
	
	private static String gpCode; // field 1.11
	public static final short VAL_LENGTH = 6; // maximum length for gpCode
	public GPCode() {	
		super("1.11", "The national code for the practice of the patient's registered GP or PCT.",
				"GP Practice Code/PCT Code");
	}
	
	public static boolean setGPCode(String pctCode) {
		// length check
		if (pctCode.length() == VAL_LENGTH && pctCode.matches("[a-zA-Z0-9]+")){
			gpCode = pctCode;
			return true;
		}
		else
			return false;		
	}
	
	public static String getGPCode() {
		return gpCode;
	}
}
