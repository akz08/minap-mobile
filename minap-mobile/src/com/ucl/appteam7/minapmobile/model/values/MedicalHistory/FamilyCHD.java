package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class FamilyCHD extends Value {
	private static byte familyCHD;
	private static String familyCHDLongCode;
	public FamilyCHD() {	
		super("2.32", "Identifies a family history of premature CHD by diagnosis, (males before 55, females before 65).");
	}
	public static boolean setFamilyCHD(byte fCHD) {
		// check if valid entry
		if (fCHD == 0 || fCHD == 1 || fCHD == 9) {
			familyCHD = fCHD;
			switch (familyCHD) {
			case 0 : familyCHDLongCode = "No"; break;
			case 1 : familyCHDLongCode = "Yes"; break;
			case 9 : familyCHDLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getFamilyCHD() {
		return Byte.toString(familyCHD) + " - " + familyCHDLongCode;
	}
	
	public static String getLongCode() {
		return familyCHDLongCode;
	}
}
