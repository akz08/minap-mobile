package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class CerebrovascularDisease extends Value{
	private static byte cerebrovascularDisease;
	private static String cerebrovascularDiseaseLongCode;
	public CerebrovascularDisease() {	
		super("2.10", "A history of cerebrovascular ischaemia. To include transient cerebral ischaemic episodes as well as events with deficit lasting >24 hours.");
	}
	public static boolean setCerebrovascular(byte cDisease) {
		// check if valid entry
		if (cDisease == 0 || cDisease == 1 || cDisease == 9) {
			cerebrovascularDisease = cDisease;
			switch (cerebrovascularDisease) {
			case 0 : cerebrovascularDiseaseLongCode = "No"; break;
			case 1 : cerebrovascularDiseaseLongCode = "Yes"; break;
			case 9 : cerebrovascularDiseaseLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getCerebrovascular() {
		return Byte.toString(cerebrovascularDisease) + cerebrovascularDiseaseLongCode;
	}
	
	public static String getLongCode() {
		return cerebrovascularDiseaseLongCode;
	}
}
