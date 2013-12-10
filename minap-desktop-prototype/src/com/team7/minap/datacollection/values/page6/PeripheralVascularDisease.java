package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class PeripheralVascularDisease extends Value{
	private static byte peripheralVascularDisease;
	private static String peripheralVascularDiseaseLongCode;
	
	public PeripheralVascularDisease() {	
		super("2.09", "The presence of peripheral vascular disease, either presently symptomatic or previously treated by intervention or surgery. Include known renovascular disease and aortic aneurysm.");
	}
	
	public static void setPeripheralVascularDisease (byte pVascularDisease){//2.09, options, Peripheral vascular disease		
		// check if valid entry
		if (pVascularDisease == 0 || pVascularDisease == 1 || pVascularDisease == 9) {
			pVascularDisease = peripheralVascularDisease;
			switch (pVascularDisease) {
			case 0 : peripheralVascularDiseaseLongCode = "No"; break;
			case 1 : peripheralVascularDiseaseLongCode = "Yes"; break;
			case 9 : peripheralVascularDiseaseLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
}
