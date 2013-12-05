/** Field 1.07 - Patient Gender
 * Takes in a single number (as a byte) that represents the patient's gender.
 * This field's valid options are 
 * 0 - Not Known
 * 1 - Male
 * 2 - Female
 * 9 - Not Specified
 * @param gen
 * @author david  
 */

package com.team7.minap.datacollection.values;
import java.util.Scanner;
public class Gender extends Value {

	private static byte patientGender; // Field 1.07
	private static String genderLongCode; // to set field's long code value
	
	public Gender() {
		super("1.07", " ");
	}
	
	public static void setPatientGender(byte gen) {
		// check if valid entry
		if (gen == 0 || gen == 1 || gen == 2 || gen == 9) {
			patientGender = gen;
			switch (patientGender) {
			case 0 : genderLongCode = "Not Known"; break;
			case 1 : genderLongCode = "Male"; break;
			case 2 : genderLongCode = "Female"; break;
			case 9 : genderLongCode = "Not Specified"; break;
			}
		}
		else
			System.err.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static byte getPatientGender() {
		return patientGender;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte entry;
		System.out.println("Enter the patient's gender (Valid Entries: 0, 1, 2, 9)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextByte();
		setPatientGender(entry);
		System.out.println("Gender: " + patientGender + " - " + genderLongCode);
		sc.close();
	}
}
