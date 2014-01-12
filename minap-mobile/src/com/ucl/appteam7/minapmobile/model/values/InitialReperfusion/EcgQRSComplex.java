package com.ucl.appteam7.minapmobile.model.values.InitialReperfusion;

import com.ucl.appteam7.minapmobile.Value;

public class EcgQRSComplex extends Value {
	private static byte ecgQRSComplex;
	private static String ecgQRSComplexLongCode;
	public EcgQRSComplex() {	
		super("2.37", "Must be stable feature on ECGs during admission. NICE MI secondary prevention audit criteria.");
	}
	public static boolean setECGQRSComplex(byte eQRSComplex) {
		// check if valid entry
		if (eQRSComplex == 1 || eQRSComplex == 2 || eQRSComplex == 3 || eQRSComplex == 9) {
			ecgQRSComplex = eQRSComplex;
			switch (ecgQRSComplex) {
			case 1 : ecgQRSComplexLongCode = "QRS complex duration >= 120 msec"; break; 
			case 2 : ecgQRSComplexLongCode = "QRS complex duration <120 msec"; break; 
			case 9 : ecgQRSComplexLongCode = "Unknown"; break;	
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getECGQRSComplex() {
		return Byte.toString(ecgQRSComplex) + " - " + ecgQRSComplexLongCode;
	}
	
	public static String getLongCode() {
		return ecgQRSComplexLongCode;
	}
}
