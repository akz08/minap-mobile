package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class AsthmaOrCOPD extends Value {
	private static byte ashtmaCOPD;
	private static String ashtmaCOPDLongCode;
	public AsthmaOrCOPD() {	
		super("2.11", "Any form of obstructive airways disease.");
	}
	public static void setAshtmaCOPD(byte aCOPD) {
		// check if valid entry
		if (aCOPD == 0 || aCOPD == 1 || aCOPD == 9) {
			aCOPD = ashtmaCOPD;
			switch (aCOPD) {
			case 0 : ashtmaCOPDLongCode = "No"; break;
			case 1 : ashtmaCOPDLongCode = "Yes"; break;
			case 9 : ashtmaCOPDLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
