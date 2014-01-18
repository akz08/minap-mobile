/** Field 4.20 - Interventional Centre Code
 * Takes in 3 digit string that represents the Interventional Centre
 * @param iCode
 * @author david  
 */

package com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis;

import com.ucl.appteam7.minapmobile.model.Value;

public class InterventionalCentreCode extends Value {
	
	public InterventionalCentreCode() {
		super("4.20", "The identifier for the Interventional Centre.");
	
	}
	// Default value is user's own hospital
	private static String interventionalID; // field 1.04
	public static final short VAL_LENGTH = 3;
	
	
	public static boolean setInterventionalCentre(String iCode) {
		// length check
		if (iCode.length() == VAL_LENGTH && iCode.matches("[A-Z][A-Z][A-Z]")) {
			interventionalID = iCode;
			return true;
		}
		else
			return false;		
	}
	
	public static String getInterventionalCentre() {
		return interventionalID;
	}
}
	