/** Field 1.01 - Hospital Identifier
 * Takes in a single number (as a byte) that represents the patient's initial diagnosis.
 * This field's valid options are 
 * 1 - Definite Myocardial Infarction
 * 3 - Acute Coronary Syndrome
 * 4 - Chest pain? cause
 * 5 - Other Initial Diagnosis.
 * If option 3 (Acute Coronary Syndrome) is chosen, field 4.32 (High Risk nSTEMI) becomes visible
 * @param iniDiagnosis
 * @author david  
 */

package com.ucl.appteam7.minapmobile.model.values.PatientInfo;

import com.ucl.appteam7.minapmobile.Value;

public class HospitalIdentifier extends Value {
	
	public HospitalIdentifier() {
		super("1.01", "The identifier allocated to the hospital by NICOR. Valid hospital identifiers are listed in a separate file.");
	
	}
	// Default value is user's own hospital
	private static String hospitalID; // field 1.04
	public static final short VAL_LENGTH = 3;
	
	
	public static boolean setHospitalIdentifier(String hospId) {
		// length check
		if (hospId.length() == VAL_LENGTH && hospId.matches("[A-Z][A-Z][A-Z]")) {
			hospitalID = hospId;
			return true;
		}
		else
			return false;		
	}
	
	public static String getHospitalIdentifier() {
		return hospitalID;
	}
}
	