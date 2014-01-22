/**
 * Must be checked when changed as part of sanity checks
 */
package com.ucl.appteam7.minapmobile.model.values.Examinations;

import com.ucl.appteam7.minapmobile.model.Value;

public class Height extends Value {
	private static double height;
	public Height() {	
		super("2.29", "Height in cms to derive BMI.",
				"Height");
	}
		// check if valid entry
	public static boolean setHeight (double h){
		if (140.00<=h && h<=220.00){
			height = h;
			return true;
		}
		else
			return false;
	}
	
	public static String getHeight() {
		return Double.toString(height);
	}
}
