/**
 * If Initial Reperfusion (3.39) = 1, 2 or 3, ECG Determine Treatment cannot be 0, 1 or 2
 * Must be checked when exiting field
 */
package com.ucl.appteam7.minapmobile.model.values.InitialReperfusion;

import com.ucl.appteam7.minapmobile.model.Value;

public class EcgDetermineTreatment extends Value {
	private static byte ecgDetermineTreatment;
	private static String ecgDetermineTreatmentLongCode;
	public EcgDetermineTreatment() {	
		super("2.03", "The ECG appearances upon which a decision to offer reperfusion treatment including primary PCI, was based. "
				+ "This can include any 12 lead ECG performed in the pre-hospital setting. "
				+ "If ST elevation consistent with infarction is recorded on any ECG during the admission, regardless of treatment, "
				+ "the discharge diagnosis should be Myocardial infarction (ST elevation).",
				"ECG Determining Treatment");
	}
	public static boolean setECGTreatment(byte eDetermineTreatment) {
		// check if valid entry
		if (eDetermineTreatment == 0 || eDetermineTreatment == 1 || eDetermineTreatment == 2 || eDetermineTreatment == 3 || eDetermineTreatment == 4 || eDetermineTreatment == 5 || eDetermineTreatment == 9) {
			ecgDetermineTreatment = eDetermineTreatment;
			switch (ecgDetermineTreatment) {
			case 0 : ecgDetermineTreatmentLongCode = "No acute changes"; break; //ECG is normal or unchanged from one recorded before this admission.
			case 1 : ecgDetermineTreatmentLongCode = "ST segment elevation"; break; //Appearances considered typical of acute ST elevation myocardial??infarction.
			case 2 : ecgDetermineTreatmentLongCode = "Left bundle branch block"; break;/*New LBBB. Whether or not LBBB is 'new' causes practical difficulties. In order to confirm this it is necessary to have evidence 
			that it did not exist before this event, by comparing with previous ECGs. Unless there is definite ST segment elevation in addition to LBBB, 
			the admission diagnosis for a patient with LBBB of uncertain duration has to be Acute coronary syndrome.*/ 		
			case 3 : ecgDetermineTreatmentLongCode = "ST segment depression"; break;//Any degree of ST segment depression involving more than one lead without any ST elevation (except aVR).
			case 4 : ecgDetermineTreatmentLongCode = "T wave changes only"; break;//Includes non Q wave infarction.
			case 5 : ecgDetermineTreatmentLongCode = "Other acute abnormality"; break;//Other ECG abnormality related to this acute event.
			case 9 : ecgDetermineTreatmentLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getECGTreatment() {
		return Byte.toString(ecgDetermineTreatment) + " - " + ecgDetermineTreatmentLongCode;
	}
	
	public static String getLongCode() {
		return ecgDetermineTreatmentLongCode;
	}
}
