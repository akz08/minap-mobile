package com.ucl.appteam7.minapmobile.model.values.Examinations;

import com.ucl.appteam7.minapmobile.model.Value;

public class Weight extends Value {
	private static double weight;
	public Weight() {	
		super("2.30", "Weight in kgs to derive BMI.");
	}
		// check if valid entry
	public static boolean setWeight (double w){
		if (0.00<=w && w<=999.99){
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
