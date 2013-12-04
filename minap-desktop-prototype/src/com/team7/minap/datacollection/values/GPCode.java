/** Field 1.11 - GP / PCT Code
 * Takes a String that represents the patient's GP/PCT's code.
 * gpctCode must be 6 characters long. This field is encrypted.
 * @param gpctCode 
 * @author david
 */

package com.team7.minap.datacollection.values;

import java.util.Scanner;

public class GPCode extends Value{
	
	private static String gpCode; // field 1.11
	public static final short VAL_LENGTH = 6; // maximum length for gpCode
	public GPCode() {	
		super("1.11", "The national code for the practice of the patient's registered GP or PCT.");
	}
	
	public static void setForename(String pctCode) {
		// length check
		if (pctCode.length() == VAL_LENGTH && pctCode.matches("[a-zA-Z0-9]+"))
			gpCode = pctCode;
		else
			System.err.println("Invalid Length - Must be 6 Characters long");
		
	}
	
	public static String getGPCode() {
		return gpCode;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String entry;
		System.out.println("Enter a Patient's GP or PCT Code (Valid Entries: a string of 6 alphanumeric characters)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		setForename(entry);
		System.out.println("Patient Case Record Number: " + gpCode);
		sc.close();
	}
}
