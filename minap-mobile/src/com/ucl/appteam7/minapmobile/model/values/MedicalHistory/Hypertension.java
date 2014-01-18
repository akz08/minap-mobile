package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.Value;

public class Hypertension extends Value{
	private static byte hyperTension;
	private static String hyperTensionLongCode;
	
	public Hypertension() {	
		super("2.07", "A patient already receiving treatment (drug, dietary or lifestyle) for hypertension or with recorded  BP > 140/90 on at least two occasions prior to admission.");
	}
	
	public static boolean setHyperTension(byte hTension) {
		// check if valid entry
		if (hTension == 0 || hTension == 1 || hTension == 9) {
			hyperTension = hTension;
			switch (hyperTension) {
			case 0 : hyperTensionLongCode = "No"; break;
			case 1 : hyperTensionLongCode = "Yes"; break;
			case 9 : hyperTensionLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}

	public static String getHyperTension() {
		return Byte.toString(hyperTension) + " - " + hyperTensionLongCode;
	}
	
	public static String getLongCode() {
		return hyperTensionLongCode;
	}
}
