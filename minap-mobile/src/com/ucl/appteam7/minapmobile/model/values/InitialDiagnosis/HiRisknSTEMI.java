/** Field 4.32 - High Risk nSTEMI
 * Takes in a single number (as a byte) that represents the patient's risk for STEMI.
 * This field becomes visible if option 3 (Acute Coronary Syndrome) is chosen for field 2.01 (Initial Diagnosis)
 * This field's valid options are 
 * 0 - No
 * 1 - Yes
 * 9 - Unknown. 
 * @param hiNSTEMI
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis;

import com.ucl.appteam7.minapmobile.Value;

public class HiRisknSTEMI extends Value {

	private static byte hiRisknSTEMI; // Field 4.32
	private static String nSTEMILongCode; // to set field's long code value
	
	public HiRisknSTEMI() {
		super("4.32", "Patients clinically suspected as having a non-ST elevation acute coronary syndrome (NSTEACS) "
				+ "with on-going or recurrent chest pain/discomfort believed to be of cardiac origin, together with "
				+ "at least one of the following: Persistent ECG changes of ST depression >1mm, or transient ST elevation; "
				+ "Pathological T wave inversion in V1-V4 suggesting an 'LAD syndrome'; Dynamic T wave inversion >2mm in two "
				+ "or more contiguous leads; Haemodynamic (e.g.: hypotension, pulmonary oedema or heart failure) or electrical "
				+ "instability (sustained ventricular arrhythmias - VT/VF) which are thought to be due to cardiac ischaemia; "
				+ "Troponin positive/negative based on the criteria and measurement system used locally.\n"
				+ "NB: The above should not override 'clinical judgement'. Any NSTEACS patient thought by the admitting "
				+ "hospital staff to be high risk or who potentially may benefit from early angiography/PCI should be "
				+ "discussed with the local cardiologists and, where appropriate, with the regional cardiac centre.\n"
				+ "A formal risk scoring assessment (e.g.: GRACE score) should still be undertaken as part of the assessment "
				+ "on all patients admitted with UA/NSTEMI, in line with NICE guidance.");
	}
	
	public static boolean setHiRisknSTEMI(byte hiNSTEMI) {
		// check if valid entry
		if (hiNSTEMI == 0 || hiNSTEMI == 1 || hiNSTEMI == 9) {
			hiRisknSTEMI = hiNSTEMI;
			switch (hiRisknSTEMI) {
			case 0 : nSTEMILongCode = "No"; break;
			case 1 : nSTEMILongCode = "Yes"; break;
			case 9 : nSTEMILongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getHiRisknSTEMI() {
		return Byte.toString(hiRisknSTEMI) + " - " + nSTEMILongCode;
	}
}
