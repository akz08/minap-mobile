/** No Field Number - Admission After STEMI
 * Takes in a boolean value to represent admission after STEMI for this patient
 * If set to true, fields 4.29, 4.26 and Interventional Center become available
 * @param admASTEMI
 */
	
package com.team7.minap.datacollection.values;

public class ASTEMIAdmission extends Value {
	
	private static boolean admissionAfterSTEMI = false;
	
	public ASTEMIAdmission() {
		super("Null", "If set to true, show fields 4.29, 4.26 and Interventional Centre");
	}
	
	public static void setAdmissionAfterSTEMI(boolean admASTEMI) {
		// additional logic goes here?
		admissionAfterSTEMI = admASTEMI;
		// set additional fields to visible here
	}
	
	public static boolean getAdmissionAfterSTEMI() {
		return admissionAfterSTEMI;
	}
}
