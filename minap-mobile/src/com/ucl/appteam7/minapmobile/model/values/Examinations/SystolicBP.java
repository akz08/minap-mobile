package com.ucl.appteam7.minapmobile.model.values.Examinations;

import com.ucl.appteam7.minapmobile.Value;

public class SystolicBP extends Value {
	
	private static double systolicBP;
	
	public SystolicBP() {	
		super("2.20", "The first systolic blood pressure recorded after admission to hospital. "
				+ "The patient should be in a stable cardiac rhythm, ie sinus or chronic AF.  "
				+ "Where the presenting rhythm is a treatable tachyarrhythmia, "
				+ "the first stable SBP after treatment should be used.");
	}
		// check if valid entry
	public static boolean setSystolicBP (double sBP){//2.20, n3, systolic blood pressure
		if (0.00<=sBP && sBP<=999.99){
			systolicBP = sBP;
			return true;
		}
		else
			return false;
	}
	
	public static String getSystolicBP() {
		return Double.toString(systolicBP);
	}
}
