package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class CerebrovascularDisease extends Value{
	private static byte cerebrovascularDisease;
	private static String cerebrovascularDiseaseLongCode;
	public CerebrovascularDisease() {	
		super("2.10", "A history of cerebrovascular ischaemia. To include transient cerebral ischaemic episodes as well as events with deficit lasting >24 hours.");
	}
	public static void setHyperTension(byte cDisease) {
		// check if valid entry
		if (cDisease == 0 || cDisease == 1 || cDisease == 9) {
			cDisease = cerebrovascularDisease;
			switch (cerebrovascularDisease) {
			case 0 : cerebrovascularDiseaseLongCode = "No"; break;
			case 1 : cerebrovascularDiseaseLongCode = "Yes"; break;
			case 9 : cerebrovascularDiseaseLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}

}
