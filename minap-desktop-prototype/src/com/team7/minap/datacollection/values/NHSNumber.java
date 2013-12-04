/** Field 1.03 - NHS Number
 * Takes in a numeric string that represents a patient's NHS Number.
 * nhsNum must be 10 digits long. This field is encrypted
 * @param sName
 * @author david
 */
package com.team7.minap.datacollection.values;

import java.util.Scanner;

public class NHSNumber extends Value{
	
	private static String nhsNumber; // field 1.03
	public static final short VAL_LENGTH = 10; // maximum length for NHS number
	
	public NHSNumber() {	
		super("1.03", "Unique national identifier that will be used for event and mortality tracking. "
				+ "This will be encrypted before data transfer.  Any other event or procedure recorded "
				+ "by NICOR will be linked using the NHS number.");
	}
	
	public static void setNHSNum(String nhsNum) {
		// length check
		if (nhsNum.length() == VAL_LENGTH && nhsNum.matches("[0-9]+"))
			nhsNumber = nhsNum;
		else
			System.err.println("Invalid Length - Must be 10 digits long");
		
	}
	
	public static String getForename() {
		return nhsNumber;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String entry;
		System.out.println("Enter a Patient's NHS Number (Valid Entries: a string of 10 whole numbers)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		setNHSNum(entry);
		System.out.println("Patient Case Record Number: " + nhsNumber);
		sc.close();
	}
}
