package com.ucl.appteam7.minapmobile.model.values.InitialReperfusion;

import com.ucl.appteam7.minapmobile.model.Value;

public class ReperfusionNotGiven extends Value {
	private static byte reperfusionNotGiven;
	private static String rNotGivenLongCode;
	public ReperfusionNotGiven() {	
		super("3.08", "Reperfusion treatment refers to primary PCI and thrombolytic treatment and applies only to patients with ST elevation infarction. "
				+ "Where there is more than one contraindication to treatment you can only enter one option, with 'Too late' having priority over all the others. ",
				"Reason Reperfusion Treatment Not Given");
	}
	public static boolean setReperfusionNotGiven(byte rNotGiven) {
		// check if valid entry
		if (rNotGiven == 0 || rNotGiven == 1 || rNotGiven == 2 || rNotGiven == 3 || rNotGiven == 4 || rNotGiven == 5 || rNotGiven == 6 || rNotGiven == 7 || rNotGiven == 8 || rNotGiven == 9) {
			reperfusionNotGiven = rNotGiven;
			switch (reperfusionNotGiven) {
			case 0 : rNotGivenLongCode = "None"; break; //This is default value which should be changed to the appropriate option.
			case 1 : rNotGivenLongCode = "Ineligible ECG"; break; //No ECGs show unequivocal ST elevation or LBBB - NB: this choice is NOT compatible with an initial diagnosis of Definite MI 
																//because that diagnosis implies that the ECG must have been diagnostic of ST elevation infarction.
			case 2 : rNotGivenLongCode = "Too late"; break;//A decision made in light of a local protocol. 
															//It may be checked against other recorded delays where initial diagnosis is definite myocardial infarction.
			case 3 : rNotGivenLongCode = "Risk of haemorrhage"; break;//Includes risk of bleeding from all sites and after prolonged resuscitation.
			case 4 : rNotGivenLongCode = "Uncontrolled hypertension"; break;//An appropriate contraindication especially in older people.
			case 5 : rNotGivenLongCode = "Administrative failure"; break;//To be used where in the opinion of a senior clinician reperfusion treatment was withheld incorrectly.
			case 6 : rNotGivenLongCode = "Elective decision"; break;//To be used where a decision was made not to treat a patient (severe coexisting morbidity, or dying).
			case 7 : rNotGivenLongCode = "Patient refused treatment"; break;//
			case 8 : rNotGivenLongCode = "Other"; break;//Use for any contraindication not covered by other options.
			case 9 : rNotGivenLongCode = "Unknown"; break;//Use when eligible patient fails to receive reperfusion treatment without a stated reason.
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getReperfusionNotGiven() {
		return Byte.toString(reperfusionNotGiven) + " - " + rNotGivenLongCode;
	}
	
	public static String getLongCode() {
		return rNotGivenLongCode;
	}
}
