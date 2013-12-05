/** Field 2.22 - Admitting Consultant
 * Takes in a single number (as a byte) that represents the patient's admitting consultant
 * This field's valid options are
 * 0 - Cardiologist
 * 1 - Other General Physician
 * 9 - Other
 * 99 - Unknown
 * @param admConsul
 * @author david
 */

package com.team7.minap.datacollection.values;
import java.util.Scanner;
public class AdmittingConsultant extends Value {

	private static byte admittingConsultant; // Field 2.22
	private static String consulLongCode; // to set field's long code value
	
	public AdmittingConsultant() {
		super("2.22", "The clinician having primary care of the patient immediately (first 24 hours) "
				+ "after admission to hospital (not the A&E consultant).");
	}
	
	public static void setAdmittingConsultant(byte admConsul) {
		// check if valid entry
		if (admConsul == 0 || admConsul == 1 || admConsul == 9 || admConsul == 99) {
			admittingConsultant = admConsul;
			switch (admConsul) {
			case 0 : consulLongCode = "Cardiologist"; break;
			case 1 : consulLongCode = "Other General Physician"; break;
			case 9 : consulLongCode = "Other"; break;
			case 99 : consulLongCode = "Unknown"; break;
			}
		}
		else
			System.err.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static byte getAdmittingConsultant() {
		return admittingConsultant;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte entry;
		System.out.println("Enter an Admitting Consultant (Valid Entries: 0, 1, 9, 99)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextByte();
		setAdmittingConsultant(entry);
		System.out.println("Admitting Consultant: " + admittingConsultant + " - " + consulLongCode);
		sc.close();
	}
}
