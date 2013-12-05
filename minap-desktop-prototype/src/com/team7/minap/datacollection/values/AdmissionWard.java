/** Field 3.17 - Admission Ward
 * Takes in a single number (as a byte) that represents the patient's admission ward
 * This field's valid options are
 * 1 - Cardiac Care Unit
 * 2 - Acute Admissions Unite
 * 3 - General Medical Ward
 * 4 - Intensive Therapy Unit
 * 5 - Other
 * 6 - Died in A & E
 * 7 - Cardiac Ward (non CCU)
 * 8 - Stepdown Ward
 * 9 - Unknown
 * @param admWard
 * @author david
 */

package com.team7.minap.datacollection.values;
import java.util.Scanner;
public class AdmissionWard extends Value {

	private static byte admissionWard; // Field 3.17
	private static String wardLongCode; // to set field's long code value
	
	public AdmissionWard() {
		super("3.17", "The purpose of this question is to determine where immediate care took place. "
				+ "Refers to the unit to which the patient is admitted either from A&E or directly by"
				+ " ambulance service and where patient will spend majority of first 24 hours in hospital. "
				+ "If patient admitted direct to cath lab, enter facility to which patient admitted on leaving lab.");
	}
	
	public static void setAdmissionWard(byte admWard) {
		// check if valid entry
		if (admWard == 1 || admWard == 2 || admWard == 3 || admWard == 4 || admWard == 5 || admWard == 6 || admWard == 7 || admWard == 8 || admWard == 9) {
			admissionWard = admWard;
			switch (admWard) {
			case 1 : wardLongCode = "Cardiac Care Unit"; break;
			case 2 : wardLongCode = "Acute Admissions Unite"; break;
			case 3 : wardLongCode = "General Medical Ward"; break;
			case 4 : wardLongCode = "Intensive Therapy Unit"; break;
			case 5 : wardLongCode = "Other"; break;
			case 6 : wardLongCode = "Died in A & E"; break;
			case 7 : wardLongCode = "Cardiac Ward (non CCU)"; break;
			case 8 : wardLongCode = "Stepdown Ward"; break;
			case 9 : wardLongCode = "Unknown"; break;
			}
		}
		else
			System.err.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static byte getAdmissionWard() {
		return admissionWard;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte entry;
		System.out.println("Enter an Admission Ward (Valid Entries: 1, 2, 3, 4, 5, 6, 7, 8, 9)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextByte();
		setAdmissionWard(entry);
		System.out.println("Admission Ward: " + admissionWard + " - " + wardLongCode);
		sc.close();
	}
}
