/**
 * Must be checked when changed per sanity checks
 */
package com.ucl.appteam7.minapmobile.model.values.Examinations;

import com.ucl.appteam7.minapmobile.model.Value;

public class HeartRate extends Value {
	private static double heartRate;
	public HeartRate() {	
		super("2.21", "The heart rate recorded from the first ECG after admission to hospital, "
				+ "whilst in a stable cardiac rhythm ie sinus rhythm, or chronic AF. "
				+ "In complete heart block record ventricular rate.  "
				+ "Where the presenting rhythm is a treatable tachyarrhythmia, "
				+ "the first stable heart rate after treatment should be used.",
				"Heart Rate");
	}
		// check if valid entry
	public static boolean setHeartRate (double hRate){//2.21, n3,Heart rate
		if (30.00<=hRate && hRate<=180.00){
			heartRate = hRate;
			return true;
		}
		else
			return false;
	}
	
	public static String getHeartRate() {
		return Double.toString(heartRate);
	}
}
