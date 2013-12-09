/** Field 1.02 - Patient Case Record Number
 * Takes in an alphanumeric string that uniquely identifies this particular patient's data.
 * cNumber must be 10 characters long. This field is encrypted.
 * @param cNumber
 * @author david
 */
package com.team7.minap.datacollection.values;

import java.util.Scanner;

public class PatientCaseRecordNumber extends Value {
	
	private static String caseNumber; // 1.02
	private static final short VAL_LENGTH = 10; // Set max length for caseNumber variable

	public PatientCaseRecordNumber() {	
		super("1.02", "Hospital number is required for identification if the NHS number is not known.");
	}
	
	public static void setCaseNumber(String cNumber) {
		// length check
		if (cNumber.length() == VAL_LENGTH && cNumber.matches("[a-zA-Z0-9]*"))
			caseNumber = cNumber;
		else
			System.err.println("Invalid Length - Must be 10 Characters long");
	}
	
	public static String getCaseNumber(){
		return caseNumber;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String entry;
		System.out.println("Enter a Patient Case Record Number (Valid Entries: 10 digit alphanumeric strings)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		setCaseNumber(entry);
		System.out.println("Patient Case Record Number: " + caseNumber);
		sc.close();
	}
}
