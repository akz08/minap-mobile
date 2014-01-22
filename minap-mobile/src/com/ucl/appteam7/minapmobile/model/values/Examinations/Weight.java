/**
 * Must be checked when changed as part of sanity checks
 */
package com.ucl.appteam7.minapmobile.model.values.Examinations;

import com.ucl.appteam7.minapmobile.model.Value;

public class Weight extends Value {
	private static double weight;
	public Weight() {	
		super("2.30", "Weight in kgs to derive BMI.",
				"Weight");
	}
		// check if valid entry
	public static boolean setWeight (double w){
		if (30.00<=w && w<=180.00){
			weight = w;
			return true;
		}
		else
			return false;
	}
	
	public static String getWeight() {
		return Double.toString(weight);
	}
}
