package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.Value;

public class PeripheralVascularDisease extends Value{
	private static byte peripheralVascularDisease;
	private static String peripheralVascularDiseaseLongCode;
	
	public PeripheralVascularDisease() {	
		super("2.09", "The presence of peripheral vascular disease, either presently symptomatic or previously treated by intervention or surgery. Include known renovascular disease and aortic aneurysm.");
	}
	
	public static boolean setPeripheralVascularDisease (byte pVascularDisease){//2.09, options, Peripheral vascular disease		
		// check if valid entry
		if (pVascularDisease == 0 || pVascularDisease == 1 || pVascularDisease == 9) {
			peripheralVascularDisease = pVascularDisease;
			switch (pVascularDisease) {
			case 0 : peripheralVascularDiseaseLongCode = "No"; break;
			case 1 : peripheralVascularDiseaseLongCode = "Yes"; break;
			case 9 : peripheralVascularDiseaseLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getPeripheralVascularDisease() {
		return Byte.toString(peripheralVascularDisease) + " - " + peripheralVascularDiseaseLongCode;
	}
	
	public static String getLongCode() {
		return peripheralVascularDiseaseLongCode;
	}
}
