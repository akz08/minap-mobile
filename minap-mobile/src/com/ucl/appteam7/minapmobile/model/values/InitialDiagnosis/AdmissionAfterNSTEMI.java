/** No Field Number - Admission After STEMI
 * Takes in a boolean value to represent admission after STEMI for this patient
 * If set to true, fields 4.29, 4.26 and Interventional Center become available
 * This field has no sanity checks associated with it
 * @param admASTEMI
 * @author david
 */
	
package com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis;

import com.ucl.appteam7.minapmobile.model.Value;

public class AdmissionAfterNSTEMI extends Value {
	
	private static boolean admissionAfterSTEMI = false;
	
	public AdmissionAfterNSTEMI() {
		super("Null", "Use even if intended primary reperfusion treatment was not performed. "
				+ "Not for use with non STE ACS.",
				"Admission After Treatment Elsewhere");
	}
	
	public static boolean setAdmissionAfterSTEMI(boolean admASTEMI) {
		// additional logic goes here?
		admissionAfterSTEMI = admASTEMI;
		// set additional fields to visible here
		return admissionAfterSTEMI;
	}
	
	public static String getAdmissionAfterSTEMI() {
		return Boolean.toString(admissionAfterSTEMI);
	}
}
