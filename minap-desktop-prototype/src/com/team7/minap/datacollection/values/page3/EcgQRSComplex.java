package com.team7.minap.datacollection.values.page3;

import com.team7.minap.datacollection.values.Value;

public class EcgQRSComplex extends Value {
	private static byte ecgQRSComplex;
	private static String ecgQRSComplexLongCode;
	public EcgQRSComplex() {	
		super("2.37", "Must be stable feature on ECGs during admission. NICE MI secondary prevention audit criteria.");
	}
	public static void setAngioDelay(byte eQRSComplex) {
		// check if valid entry
		if (eQRSComplex == 1 || eQRSComplex == 2 || eQRSComplex == 3 || eQRSComplex == 9) {
			eQRSComplex = ecgQRSComplex;
			switch (ecgQRSComplex) {
			case 1 : ecgQRSComplexLongCode = "QRS complex duration >= 120 msec"; break; 
			case 2 : ecgQRSComplexLongCode = "QRS complex duration <120 msec"; break; 
			case 9 : ecgQRSComplexLongCode = "Unknown"; break;	
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
