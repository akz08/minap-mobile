package com.team7.minap.datacollection.values.page3;

import com.team7.minap.datacollection.values.Value;

public class LocationAtSTEMI extends Value {
	private static byte locationAtSTEMI;
	private static String locationAtSTEMILongCode;
	public LocationAtSTEMI() {	
		super("2.40", "The purpose of this field is to permit identification of STE MI not originating in the community, "
				+ "in order that such patients can be excluded, where appropriate, "
				+ "from call to needle and call to balloon analyses.");
	}
	public static void setAngioDelay(byte lAtSTEMI) {
		// check if valid entry
		if (lAtSTEMI == 1 || lAtSTEMI == 2 || lAtSTEMI == 3 || lAtSTEMI == 8 || lAtSTEMI == 9) {
			lAtSTEMI = locationAtSTEMI;
			switch (locationAtSTEMI) {
			case 1 : locationAtSTEMILongCode = "Onset of STEMI while patient not in hospital (STE on first ECG)"; break; 
			/*This implies that ST elevation was found on first ECG performed in an ambulance or other medical facility (GP surgery etc) before arrival at 
			 * the first hospital or on the first ECG recorded in hospital for a self presenter.  
			 * If no ECG was taken prior to arrival at the first hospital (whether admitted or not) and first ECG recorded in hospital  shows ST elevation then 
			 * it should be assumed that STEMI  developed before reaching hospital. 
			 * This option should also be selected where an ECG was not considered diagnostic before admission, but STE is diagnosed on arrival at A&E.*/
			case 2 : locationAtSTEMILongCode = "Delay due to comorbid clinical condition/ competing clinical issue"; break; 
			/*The word subsequent applies to any ECG taken after an initial non-diagnostic ECG was performed 
			 * in the ambulance or at the non-interventional hospital.  
			 * This group of patients will have arrived in hospital without a diagnosis of STE MI,
			 *  and then develop ST segment elevation after hospital arrival (whether admitted or not). 
			 *  The subsequent ECG may be at any time after admission to hospital.  
			 *  This option covers a spectrum from patients initially presenting with features consistent 
			 *  with ACS who go on to develop STEMI through 
			 * to patients who are admitted for some other condition who develop STEMI while in hospital.*/
			case 3 : locationAtSTEMILongCode = "Capacity issues"; break;
			/*The word subsequent applies to any ECG taken after an initial non-diagnostic ECG 
			 * was performed in the ambulance or at the interventional hospital.  
			 * This group of patients will have arrived in hospital without a diagnosis of STE MI, 
			 * and then develop ST segment elevation after hospital arrival (whether admitted or not). 
			 * The subsequent ECG may be at any time after admission to hospital.  
			 * This option covers a spectrum from patients initially presenting with 
			 * features consistent with ACS who go on to develop STEMI through to patients 
			 * who are admitted for some other condition who develop STEMI while in hospital.*/
			case 8 : locationAtSTEMILongCode = "Not applicable"; break;
			case 9 : locationAtSTEMILongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
