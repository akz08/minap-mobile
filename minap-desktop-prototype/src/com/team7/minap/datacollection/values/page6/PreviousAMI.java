package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class PreviousAMI extends Value {
	private static byte previousAngina;
	private static String previousAnginaLongCode;
	public PreviousAMI() {	
		super("2.05", "Identifies if and when aspirin or other antiplatelet drug was first given to patient.");
	}
	public static void setHyperTension(byte pAngina) {
		// check if valid entry
		if (pAngina == 0 || pAngina == 1 || pAngina == 9) {
			pAngina = previousAngina;
			switch (previousAngina) {
			case 0 : previousAnginaLongCode = "No"; break;
			case 1 : previousAnginaLongCode = "Yes"; break;
			case 9 : previousAnginaLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
