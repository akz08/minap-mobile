/** Field 1.13 - Patient Ethnicity
 * Takes in a single number (as a byte) that represents the patient's ethnicity
 * This field's valid options are
 * 1 - White
 * 2 - Black
 * 3 - Asian
 * 5 - Mixed
 * 6 - Not Stated
 * 8 - Other
 * 9 - Unknown
 * @param ethnic
 * @author david
 */

package com.team7.minap.datacollection.values;
import java.util.Scanner;
public class PatientEthnicity extends Value {

	private static byte ethnicity; // Field 1.13
	private static String ethnicLongCode; // to set field's long code value
	
	public PatientEthnicity() {
		super("1.13", "The patient's ethnic group as perceived by the patient.");
	}
	
	public static void setEthnicity(byte ethnic) {
		// check if valid entry
		if (ethnic == 1 || ethnic == 2 || ethnic == 3 || ethnic == 5 || ethnic == 6 || ethnic == 8 || ethnic == 9) {
			ethnicity = ethnic;
			switch (ethnic) {
			case 1 : ethnicLongCode = "White"; break;
			case 2 : ethnicLongCode = "Black"; break;
			case 3 : ethnicLongCode = "Asian"; break;
			case 5 : ethnicLongCode = "Mixed"; break;
			case 6 : ethnicLongCode = "Not Stated"; break;
			case 8 : ethnicLongCode = "Other"; break;
			case 9 : ethnicLongCode = "Unknown"; break;
			}
		}
		else
			System.err.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static byte getEthnicity() {
		return ethnicity;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte entry;
		System.out.println("Enter the patient's ethnicity (Valid Entries: 1, 2, 3, 5, 6, 8, 9)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextByte();
		setEthnicity(entry);
		System.out.println("Ethnicity: " + ethnicity + " - " + ethnicLongCode);
		sc.close();
	}
}
