/** Field 4.29 - What Procedure was Performed at the Interventional Hospital 
 * Takes in a single number (as a byte) that represents the patient's procedure at an interventional hospital
 * This field becomes visible if Admission After STEMI is true
 * This field has the following valid options:
 * 0 - None
 * 1 - Delay due to comorbid clinical condition / competing clinical issue
 * 2 - Capacity issues
 * 3 - Patient preference
 * 8 - Other
 * 9 - Unknown
 * This field has no sanity checks associated with it
 * @param interHosProcedure
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis;

import com.ucl.appteam7.minapmobile.model.Value;

public class InterventionalProcedure extends Value {

	private static byte interventionalProcedure; // Field 4.29
	private static String procedureLongCode; // to set field's long code value
	
	public InterventionalProcedure() {
		super("4.29", "For use by non-interventional hospitals when patients return after an intervention. "
				+ "This field is not to be used for nSTEMI records as it refers to primary reperfusion.",
				"What Procedure Was Performed At The Interventional Hospital");
	}
	
	public static boolean setInterventionalProcedure(byte interHosProcedure) {
		// check if valid entry
		if (interHosProcedure == 0 || interHosProcedure == 1 || interHosProcedure == 3 || interHosProcedure == 8 || interHosProcedure == 9) {
			interventionalProcedure = interHosProcedure;
			switch (interHosProcedure) {
			case 0 : procedureLongCode = "None"; break;
			case 1 : procedureLongCode = "Delay due to comorbid clinical condition / competing clinical issue"; break;
			case 2 : procedureLongCode = "Capacity issues"; break;
			case 3 : procedureLongCode = "Patient preference"; break;
			case 8 : procedureLongCode = "Other"; break;
			case 9 : procedureLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getInterventionalProcedure() {
		return Byte.toString(interventionalProcedure) + " - " + procedureLongCode;
	}
}
