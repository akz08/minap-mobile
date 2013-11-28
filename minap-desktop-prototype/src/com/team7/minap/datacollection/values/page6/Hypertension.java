package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class Hypertension extends Value{
	private static byte hyperTension;
	private static String hyperTensionLongCode;
	
	public Hypertension() {	
		super("2.07", "A patient already receiving treatment (drug, dietary or lifestyle) for hypertension or with recorded  BP > 140/90 on at least two occasions prior to admission.");
	}
	
	public static void setHyperTension(byte hTension) {
		// check if valid entry
		if (hTension == 0 || hTension == 1 || hTension == 9) {
			hTension = hyperTension;
			switch (hyperTension) {
			case 0 : hyperTensionLongCode = "No"; break;
			case 1 : hyperTensionLongCode = "Yes"; break;
			case 9 : hyperTensionLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static void main(String[] args) {
		

	}

}
