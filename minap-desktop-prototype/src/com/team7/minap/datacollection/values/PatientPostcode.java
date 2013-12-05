/** Field 1.10 - Patient post code
 * Takes in an alphanumeric string that represents a patient's post code.
 * pCode must be 8 characters long. This field is encrypted.
 * @param pCode
 * @author david
 */

package com.team7.minap.datacollection.values;

import java.util.Scanner;

public class PatientPostcode extends Value{
	
	private static String postCode; // field 1.10
	public static final short VAL_LENGTH = 8; // maximum length for pCode
	public PatientPostcode() {	
		super("1.10", "The postcode of the address nominated by the patient "
				+ "as their main permanent residence. Use pseudo postcodes for visitors.");
	}
	
	public static void setPostcode(String pCode) {
		// length check
		if (pCode.length() <= VAL_LENGTH && (pCode.matches("[a-zA-Z]+[0-9]+[a-zA-Z]*[ ][0-9][a-zA-Z]+") || pCode.matches("zz99")))
			postCode = pCode;
		else
			System.err.println("Invalid Length - Must be 6 Characters long");
		
	}
	
	public static String getPostcode() {
		return postCode;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String entry;
		System.out.println("Enter a Patient's postcode (Valid Entries: a string of 8 alphanumeric characters)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		setPostcode(entry);
		System.out.println("Patient Case Record Number: " + postCode);
		sc.close();
	}
}

