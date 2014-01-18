/** Field 2.22 - Admitting Consultant
 * Takes in a single number (as a byte) that represents the patient's admitting consultant
 * This field's valid options are
 * 0 - Cardiologist
 * 1 - Other General Physician
 * 9 - Other
 * 99 - Unknown
 * @param admConsul
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.model.Value;

public class AdmittingConsultant extends Value {

	private static byte admittingConsultant; // Field 2.22
	private static String consulLongCode; // to set field's long code value
	
	public AdmittingConsultant() {
		super("2.22", "The clinician having primary care of the patient immediately (first 24 hours) "
				+ "after admission to hospital (not the A&E consultant).");
	}
	
	public static boolean setAdmittingConsultant(byte admConsul) {
		// check if valid entry
		if (admConsul == 0 || admConsul == 1 || admConsul == 9 || admConsul == 99) {
			admittingConsultant = admConsul;
			switch (admConsul) {
			case 0 : consulLongCode = "Cardiologist"; break;
			case 1 : consulLongCode = "Other General Physician"; break;
			case 9 : consulLongCode = "Other"; break;
			case 99 : consulLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getAdmittingConsultant() {
		return Byte.toString(admittingConsultant) + " - " + consulLongCode;
	}
	
	public static String getLongCode() {
		return consulLongCode;
	}
}
