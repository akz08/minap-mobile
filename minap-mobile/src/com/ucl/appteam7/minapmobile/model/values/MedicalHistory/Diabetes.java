package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class Diabetes extends Value {
	private static byte diabetes;
	private static String diabetesLongCode;
	public Diabetes() {	
		super("2.17", " ",
				"Diabetes");
	}
	public static boolean setDiabetes(byte diabete) {
		// check if valid entry
		if (diabete == 0 || diabete == 1 || diabete == 2 || diabete == 3 || diabete == 4 || diabete == 9) {
			diabetes = diabete;
			switch (diabetes) {
			case 0 : diabetesLongCode = "Not diabetic"; break; //Not known diabetic.
			case 1 : diabetesLongCode = "Diabetes (dietary control)"; break; //Diabetic not receiving insulin or oral medication.
			case 2 : diabetesLongCode = "Diabetes (oral medicine)"; break; //Diabetic receiving oral medication prior to admission. 
			case 3 : diabetesLongCode = "NDiabetes (insulin)"; break;//Diabetic receiving insulin without additional oral medication.
			case 5 : diabetesLongCode = "Insulin plus oral medication"; break;//Diabetic receiving insulin and oral medication prior to admission.
			case 9 : diabetesLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getDiabetes() {
		return Byte.toString(diabetes) + " - " + diabetesLongCode;
	}
	
	public static String getLongCode() {
		return diabetesLongCode;
	}
}
