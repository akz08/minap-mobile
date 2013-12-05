/** Field 2.01 - Initial Diagnosis
	 * Takes in a single number (as a byte) that represents the patient's initial diagnosis.
	 * This field's valid options are 
	 * 1 - Definite Myocardial Infarction
	 * 3 - Acute Coronary Syndrome
	 * 4 - Chest pain? cause
	 * 5 - Other Initial Diagnosis.
	 * If option 3 (Acute Coronary Syndrome) is chosen, field 4.32 (High Risk nSTEMI) becomes visible
	 * @param iniDiagnosis
	 * @author david  
	 */

package com.team7.minap.datacollection.values;
import java.util.Scanner;
public class InitialDiagnosis extends Value {

	private static byte initialDiagnosis; // Field 2.01
	private static String diagnosisLongCode; // to set field's long code value
	
	public InitialDiagnosis() {
		super("2.01", "This is a working diagnosis whose primary purpose is to identify those patients with a diagnosis of definite ST elevation MI. "
				+ "This includes an initial diagnosis made by an ambulance paramedic crew, or other clinician in a position to provide definitive treatment. "
				+ "Do not change Initial diagnosis on the basis of further ECGs or enzymes/markers. (See 2.03 ECG determining treatment).");
	}
	
	public static void setInitialDiagnosis(byte iniDiagnosis) {
		// check if valid entry
		if (iniDiagnosis == 1 || iniDiagnosis == 3 || iniDiagnosis == 4 || iniDiagnosis == 5) {
			initialDiagnosis = iniDiagnosis;
			switch (initialDiagnosis) {
			case 1 : diagnosisLongCode = "Definite myocardial infarction"; break;
			case 3 : diagnosisLongCode = "Acute coronary syndrome"; /* field 4.32 (High Risk nSTEMI).visible = true; */ break;
			case 4 : diagnosisLongCode = "Chest pain ? cause"; break;
			case 5 : diagnosisLongCode = "Other initial diagnosis"; break;
			}
		}
		else
			System.err.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static byte getInitialDiagnosis() {
		return initialDiagnosis;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte entry;
		System.out.println("Enter an Initial Diagnosis (Valid Entries: 1, 3, 4, 5)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextByte();
		setInitialDiagnosis(entry);
		System.out.println("Initial Diagnosis: " + initialDiagnosis + " - " + diagnosisLongCode);
		sc.close();
	}
}
