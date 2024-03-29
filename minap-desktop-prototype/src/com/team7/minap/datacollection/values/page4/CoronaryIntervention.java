package com.team7.minap.datacollection.values.page4;

import com.team7.minap.datacollection.values.Value;

public class CoronaryIntervention extends Value {
	private static byte coronaryIntervention;
	private static String coronaryInterventionLongCode;
	public CoronaryIntervention() {	
		super("4.14", "Coronary intervention during this episode performed either in your hospital or by referral to another hospital. "
				+ "Do not use for primary PCI or rescue which are covered by 3.39 and 3.40.");
	}
	public static void setCoronaryAngiography(byte cIntervention) {
		// check if valid entry
		if (cIntervention == 1 || cIntervention == 2 || cIntervention == 4 || cIntervention == 5 || cIntervention == 6 || cIntervention == 7 || cIntervention == 8 || cIntervention == 9) {
			cIntervention = coronaryIntervention;
			switch (coronaryIntervention) {
			case 1 : coronaryInterventionLongCode = "Percutaneous coronary intervention"; break; 
			case 2 : coronaryInterventionLongCode = "CABG"; break; 
			case 4 : coronaryInterventionLongCode = "PCI planned after discharge"; break;
			case 5 : coronaryInterventionLongCode = "CABG planned after discharge"; break;
			case 6 : coronaryInterventionLongCode = "Not applicable"; break;//For use when there is advanced malignancy, dementia, progressive neurological disease or other conditions having an immediate impact on prognosis. 
																			//Includes other clinical reasons identified by the clinician.
			case 7 : coronaryInterventionLongCode = "Patient refused "; break;
			case 8 : coronaryInterventionLongCode = "Not performed or arranged"; break;
			case 9 : coronaryInterventionLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
