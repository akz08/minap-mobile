/** Field 1.04 - Patient surname
 * Takes in an alphanumeric string that represents a patient's surname(s).
 * sName must be no more than 35 characters long. This field is encrypted
 * @param sName
 */
	
package com.team7.minap.datacollection.values;

import java.util.Scanner;

public class PatientSurname extends Value {
	
	private static String surname; // field 1.04
	public static final short VAL_LENGTH = 35; // maximum length for surname
	
	public PatientSurname() {	
		super("1.04", " "); 
	}
	
	public static void setSurname(String sName) {
		// length check
		if (sName.length() <= VAL_LENGTH && sName.matches("[a-zA-Z0-9]+"))
			surname = sName;
		else
			System.err.println("Invalid Length - Must be 35 Characters long");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String entry;
		System.out.println("Enter a Patient's surname (Valid Entries: a string of 35 or less alphanumeric characters)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		setSurname(entry);
		System.out.println("Patient Case Record Number: " + surname);
		sc.close();
	}
}
