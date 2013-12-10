package com.team7.minap.datacollection.values.page3;

import com.team7.minap.datacollection.values.Value;

public class InitialReperfusion extends Value {
	private static byte initialReperfusion;
	private static String initialReperfusionLongCode;
	public InitialReperfusion() {	
		super("3.39", "This refers to treatment given in your hospital.");
	}
	public static void setAngioDelay(byte iReperfusion) {
		// check if valid entry
		if (iReperfusion == 0 || iReperfusion == 1 || iReperfusion == 2 || iReperfusion == 3 || iReperfusion == 4 || iReperfusion == 9) {
			iReperfusion = initialReperfusion;
			switch (initialReperfusion) {
			case 0 : initialReperfusionLongCode = "None"; break; 
			case 1 : initialReperfusionLongCode = "Thrombolytic treatment"; break; 
			case 2 : initialReperfusionLongCode = "pPCI in house"; break;//Primary PCI for STE MI. Includes patients presenting with a clear history of AMI and LBBB. 
			case 3 : initialReperfusionLongCode = "Referred for consideration for pPCI elsewhere"; break;//Intended primary PCI for STEMI/LBBB.  
																										//At the time of referral (or data entry) the reperfusion treatment actually performed may not be known. 
																										//These cases will subsequently be linked with the interventional hospital record. 
			case 4 : initialReperfusionLongCode = "pPCI already was peformed at the interventional hospital"; break; /*This is for use by non-interventional hospitals only. 
																													Use this option when a patient comes to you for the first time following primary PCI elsewhere.*/
			case 9 : initialReperfusionLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
