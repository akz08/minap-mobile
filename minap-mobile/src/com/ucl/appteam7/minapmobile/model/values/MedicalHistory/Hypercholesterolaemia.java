/**
 * This field has no sanity checks associated with it
 */

package com.ucl.appteam7.minapmobile.model.values.MedicalHistory;

import com.ucl.appteam7.minapmobile.model.Value;

public class Hypercholesterolaemia extends Value{
	private static byte hyperCholesterolaemia;
	private static String hyperCholesterolaemiaLongCode;
	
	public Hypercholesterolaemia() {	
		super("2.08", "Elevation of serum cholesterol requiring dietary or drug treatment. Use field 2.15 (Serum cholesterol) for present value of cholesterol.",
				"Hypercholesterolaemia");
	}
	
	public static boolean setHyperCholesterol(byte hCholesterolaemia) {
		// check if valid entry
		if (hCholesterolaemia == 0 || hCholesterolaemia == 1 || hCholesterolaemia == 9) {
			hyperCholesterolaemia = hCholesterolaemia;
			switch (hCholesterolaemia) {
			case 0 : hyperCholesterolaemiaLongCode = "No"; break;
			case 1 : hyperCholesterolaemiaLongCode = "Yes"; break;
			case 9 : hyperCholesterolaemiaLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}

	public static String getHyperCholesterol() {
		return Byte.toString(hyperCholesterolaemia) + " - " + hyperCholesterolaemiaLongCode;
	}
	
	public static String getLongCode() {
		return hyperCholesterolaemiaLongCode;
	}
}
