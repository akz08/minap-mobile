package com.team7.minap.datacollection.values.page6;

import com.team7.minap.datacollection.values.Value;

public class Hypercholesterolaemia extends Value{
	private static byte hyperCholesterolaemia;
	private static String hyperCholesterolaemiaLongCode;
	
	public Hypercholesterolaemia() {	
		super("2.08", "Elevation of serum cholesterol requiring dietary or drug treatment. Use field 2.15 (Serum cholesterol) for present value of cholesterol.");
	}
	
	public static void setHyperCholesterolaemia(byte hCholesterolaemia) {
		// check if valid entry
		if (hCholesterolaemia == 0 || hCholesterolaemia == 1 || hCholesterolaemia == 9) {
			hCholesterolaemia = hyperCholesterolaemia;
			switch (hCholesterolaemia) {
			case 0 : hyperCholesterolaemiaLongCode = "No"; break;
			case 1 : hyperCholesterolaemiaLongCode = "Yes"; break;
			case 9 : hyperCholesterolaemiaLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}

}
