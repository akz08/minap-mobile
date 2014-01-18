package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class PreviousAngina extends Value {
	private static byte previousAngina;
	private static String previousAnginaLongCode;
	public PreviousAngina() {	
		super("2.06", "Identifies if and when aspirin or other antiplatelet drug was first given to patient.",
				"Previous Angina");
	}
	public static boolean setPreviousAngina(byte pAngina) {
		// check if valid entry
		if (pAngina == 0 || pAngina == 1 || pAngina == 9) {
			previousAngina = pAngina;
			switch (previousAngina) {
			case 0 : previousAnginaLongCode = "No"; break;
			case 1 : previousAnginaLongCode = "Yes"; break;
			case 9 : previousAnginaLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getPreviousAngina() {
		return Byte.toString(previousAngina) + " - " + previousAnginaLongCode;
	}
	
	public static String getLongCode() {
		return previousAnginaLongCode;
	}
}
