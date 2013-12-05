/** Field 2.23 - Place First 12 Lead ECG Performed
 * Takes in a single number (as a byte) that represents the place the patient's first ECG was performed
 * This field's valid options are 
 * 1 - Ambulance
 * 2 - In Hospital
 * 3 - Other Healthcare Facility
 * 9 - Unknown
 * @param fECG
 */

package com.team7.minap.datacollection.values;
import java.util.Scanner;

public class FirstECG extends Value {

	private static byte firstECG; // Field 2.23
	private static String ecgLongCode; // to set field's long code value
	
	public FirstECG() {
		super("2.23", "This refers to the 1st ECG recorded, not necessarily the diagnostic ECG.");
	}
	
	public static void setFirstECG(byte fECG) {
		// check if valid entry
		if (fECG == 1 || fECG == 2 || fECG == 3 || fECG == 9) {
			firstECG = fECG;
			switch (fECG) {
			case 1 : ecgLongCode = "Ambulance"; break;
			case 2 : ecgLongCode = "In Hospital"; break;
			case 3 : ecgLongCode = "Other Healthcare Facility"; break;
			case 9 : ecgLongCode = "Unknown"; break;
			}
		}
		else
			System.err.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static byte getFirstECG() {
		return firstECG;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte entry;
		System.out.println("Enter an First ECG Performed (Valid Entries: 1, 2, 3, 9)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextByte();
		setFirstECG(entry);
		System.out.println("First ECG Performed: " + firstECG + " - " + ecgLongCode);
		sc.close();
	}
}
