/** Field 1.05 - Patient forename
 * Takes in an alphanumeric string that represents a patient's forename(s).
 * fName must be no more than 35 characters long. This field is encrypted
 * @param sName
 * @author david
 */
package com.team7.minap.datacollection.values;

import java.util.Scanner;

public class PatientForename extends Value{
	
	private static String forename; // field 1.05
	public static final short VAL_LENGTH = 35; // maximum length for forename
	public PatientForename() {	
		super("1.05", " ");
	}
	
	public static void setForename(String fName) {
		// length check
		if (fName.length() <= VAL_LENGTH && fName.matches("[a-zA-Z0-9]+"))
			forename = fName;
		else
			System.err.println("Invalid Length - Must be 35 Characters long");
		
	}
	
	public static String getForename() {
		return forename;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String entry;
		System.out.println("Enter a Patient's surname (Valid Entries: a string of 35 or less alphanumeric characters)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		setForename(entry);
		System.out.println("Patient Case Record Number: " + forename);
		sc.close();
	}
}
