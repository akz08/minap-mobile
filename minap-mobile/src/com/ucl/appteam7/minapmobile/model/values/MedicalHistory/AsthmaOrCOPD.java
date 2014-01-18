package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class AsthmaOrCOPD extends Value {
	private static byte asthmaCOPD;
	private static String asthmaCOPDLongCode;
	public AsthmaOrCOPD() {	
		super("2.11", "Any form of obstructive airways disease.");
	}
	public static boolean setAsthmaCOPD(byte aCOPD) {
		// check if valid entry
		if (aCOPD == 0 || aCOPD == 1 || aCOPD == 9) {
			asthmaCOPD = aCOPD;
			switch (aCOPD) {
			case 0 : asthmaCOPDLongCode = "No"; break;
			case 1 : asthmaCOPDLongCode = "Yes"; break;
			case 9 : asthmaCOPDLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getAsthmaCOPD() {
		return Byte.toString(asthmaCOPD) + " - " + asthmaCOPDLongCode;
	}
	
	public static String getLongCode() {
		return asthmaCOPDLongCode;
	}
}
