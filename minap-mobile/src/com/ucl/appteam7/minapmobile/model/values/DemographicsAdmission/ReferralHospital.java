/** Field 4.21 - Referral Hospital
 * Takes in 3 character String that represents the Referral Hospital's Code
 * @param rId
 * @author david  
 */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.model.Value;

public class ReferralHospital extends Value {
	
	public ReferralHospital() {
		super("4.21", "Code of hospital from which patient was referred for any investigation or intervention.");
	
	}
	// Default value is user's own hospital
	private static String referralId; // field 1.04
	public static final short VAL_LENGTH = 3;
	
	
	public static boolean setReferralIdentifier(String rId) {
		// length check
		if (rId.length() == VAL_LENGTH && rId.matches("[A-Z][A-Z][A-Z]")) {
			referralId = rId;
			return true;
		}
		else
			return false;		
	}
	
	public static String getReferralIdentifier() {
		return referralId;
	}
}
	