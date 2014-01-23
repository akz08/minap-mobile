/** Field 1.03 - NHS Number
 * Takes in a numeric string that represents a patient's NHS Number.
 * nhsNum must be 10 digits long. This field is encrypted
 * 
 * This field has no sanity checks associated with it.
 * It must be checked when saving the page
 * @param sName
 * @author david
 */
package com.ucl.appteam7.minapmobile.model.values.PatientInfo;

import com.ucl.appteam7.minapmobile.model.Value;

public class NHSNumber extends Value{
	
	private static String nhsNumber; // field 1.03
	public static final short VAL_LENGTH = 10; // maximum length for NHS number
	
	public NHSNumber() {	
		super("1.03", "Unique national identifier that will be used for event and mortality tracking. "
				+ "This will be encrypted before data transfer.  Any other event or procedure recorded "
				+ "by NICOR will be linked using the NHS number.");
	}
	
	public static boolean setNHSNum(String nhsNum) {
		// length check
		if (nhsNum.length() == VAL_LENGTH && nhsNum.matches("[0-9]+")) {
			nhsNumber = nhsNum;
			return true;
		}
		else
			return false;		
	}
	
	public static String getNHSNum() {
		return nhsNumber;
	}
}
