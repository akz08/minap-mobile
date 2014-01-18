/** Field 1.07 - Patient Gender
 * Takes in a single number (as a byte) that represents the patient's gender.
 * This field's valid options are 
 * 0 - Not Known
 * 1 - Male
 * 2 - Female
 * 9 - Not Specified
 * @param gen
 * @author david  
 */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.model.Value;

public class Gender extends Value {

	private static byte patientGender; // Field 1.07
	private static String genderLongCode; // to set field's long code value
	
	public Gender() {
		super("1.07", "Note the '9. Not specified' option is to be used where patient sex is indeterminate (e.g. in neonates) and the "
				+"'0. Not known' option where patient's gender is unknown (i.e. you have not met the patient).",
				"Gender");
	}
	
	public static boolean setPatientGender(byte gen) {
		// check if valid entry
		if (gen == 0 || gen == 1 || gen == 2 || gen == 9) {
			patientGender = gen;
			switch (patientGender) {
			case 0 : genderLongCode = "Not Known"; break;
			case 1 : genderLongCode = "Male"; break;
			case 2 : genderLongCode = "Female"; break;
			case 9 : genderLongCode = "Not Specified"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getPatientGender() {
		return Byte.toString(patientGender) + " - " + genderLongCode;
	}
	
	public static String getGenderLongCode() {
		return genderLongCode;
	}
}
