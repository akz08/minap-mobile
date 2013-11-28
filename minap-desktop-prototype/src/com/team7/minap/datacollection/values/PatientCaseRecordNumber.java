/** Field 1.02 - Patient Case Record Number
 * Takes in an alphanumeric string that uniquely identifies this particular patient's data.
 * cNumber must be 10 characters long. This field is encrypted.
 * @param cNumber
 * @author david
 */
package com.team7.minap.datacollection.values;

public class PatientCaseRecordNumber extends Value {
	
	private static String caseNumber; // 1.02
	private static final short VAL_LENGTH = 10; // Set max length for caseNumber variable

	public PatientCaseRecordNumber() {	
		super("1.02", "Hospital number is required for identification if the NHS number is not known.");
	}
	
	public static void setCaseNumber(String cNumber) {
		// length check
		if (cNumber.length() == VAL_LENGTH)
		caseNumber = cNumber;
	}
}
