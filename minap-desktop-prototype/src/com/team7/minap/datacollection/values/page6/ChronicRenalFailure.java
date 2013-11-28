package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class ChronicRenalFailure extends Value {
	private static byte chronicRenalFailure;
	private static String chronicRenalFailureLongCode;
	public ChronicRenalFailure() {	
		super("2.11", "Any form of obstructive airways disease.");
	}
	public static void setChronicRenalFailure(byte cRenalFailure) {
		// check if valid entry
		if (cRenalFailure == 0 || cRenalFailure == 1 || cRenalFailure == 9) {
			cRenalFailure = chronicRenalFailure;
			switch (cRenalFailure) {
			case 0 : chronicRenalFailureLongCode = "No"; break;
			case 1 : chronicRenalFailureLongCode = "Yes"; break;
			case 9 : chronicRenalFailureLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
