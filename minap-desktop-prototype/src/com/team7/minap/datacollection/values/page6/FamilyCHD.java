package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class FamilyCHD extends Value {
	private static byte familyCHD;
	private static String familyCHDLongCode;
	public FamilyCHD() {	
		super("2.32", "Identifies a family history of premature CHD by diagnosis, (males before 55, females before 65).");
	}
	public static void setFamilyCHD(byte fCHD) {
		// check if valid entry
		if (fCHD == 0 || fCHD == 1 || fCHD == 9) {
			fCHD = familyCHD;
			switch (familyCHD) {
			case 0 : familyCHDLongCode = "No"; break;
			case 1 : familyCHDLongCode = "Yes"; break;
			case 9 : familyCHDLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
