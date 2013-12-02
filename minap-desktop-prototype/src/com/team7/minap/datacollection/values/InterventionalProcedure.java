/** Field 4.29 - What Procedure was Performed at the Interventional Hospital 
 * Takes in a single number (as a byte) that represents the patient's procedure at an interventional hospital
 * This field becomes visible if Admission After STEMI is true
 * This field has the following valid options:
 * 0 - None
 * 1 - Delay due to comorbid clinical condition / competing clinical issue
 * 2 - Capacity issues
 * 3 - Patient preference
 * 8 - Other
 * 9 - Unknown
 * @param interHosProcedure
 * @author david
 */

package com.team7.minap.datacollection.values;
import java.util.Scanner;
public class InterventionalProcedure extends Value {

	private static byte interventionalProcedure; // Field 4.29
	private static String procedureLongCode; // to set field's long code value
	
	public InterventionalProcedure() {
		super("4.29", "For use by non-interventional hospitals when patients return after an intervention. "
				+ "This field is not to be used for nSTEMI records as it refers to primary reperfusion.");
	}
	
	public static void setInterventionalProcedure(byte interHosProcedure) {
		// check if valid entry
		if (interHosProcedure == 0 || interHosProcedure == 1 || interHosProcedure == 3 || interHosProcedure == 8 || interHosProcedure == 9) {
			interventionalProcedure = interHosProcedure;
			switch (interHosProcedure) {
			case 0 : procedureLongCode = "None"; break;
			case 1 : procedureLongCode = "Delay due to comorbid clinical condition / competing clinical issue"; break;
			case 2 : procedureLongCode = "Capacity issues"; break;
			case 3 : procedureLongCode = "Patient preference"; break;
			case 8 : procedureLongCode = "Other"; break;
			case 9 : procedureLongCode = "Unknown"; break;
			}
		}
		else
			System.err.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte entry;
		System.out.println("Enter an Interventional Procedure (Valid Entries: 0, 1, 2, 3, 8, 9)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextByte();
		setInterventionalProcedure(entry);
		System.out.println("Initial Diagnosis: " + interventionalProcedure + " - " + procedureLongCode);
		sc.close();
	}
}
