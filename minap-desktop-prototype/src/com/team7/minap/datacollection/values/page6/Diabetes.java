package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class Diabetes extends Value {
	private static byte diabetes;
	private static String diabetesLongCode;
	public Diabetes() {	
		super("2.17", " ");
	}
	public static void setDiabetes(byte diabete) {
		// check if valid entry
		if (diabete == 0 || diabete == 1 || diabete == 2 || diabete == 3 || diabete == 5 || diabete == 9) {
			diabete = diabetes;
			switch (diabetes) {
			case 0 : diabetesLongCode = "Not diabetic"; break; //Not known diabetic.
			case 1 : diabetesLongCode = "Diabetes (dietary control)"; break; //Diabetic not receiving insulin or oral medication.
			case 2 : diabetesLongCode = "Diabetes (oral medicine)"; break; //Diabetic receiving oral medication prior to admission. 
			case 3 : diabetesLongCode = "NDiabetes (insulin)"; break;//Diabetic receiving insulin without additional oral medication.
			case 5 : diabetesLongCode = "Insulin plus oral medication"; break;//Diabetic receiving insulin and oral medication prior to admission.
			case 9 : diabetesLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
