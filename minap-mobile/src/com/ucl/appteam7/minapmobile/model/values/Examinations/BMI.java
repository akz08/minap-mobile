/** No field number - BMI
 * Must be checked (recalculated) when either Height (2.29) or Weight (2.30) are changed 
 * @param height, weight - must come from respective java classes
 * @author david
 */
package com.ucl.appteam7.minapmobile.model.values.Examinations;

import java.text.DecimalFormat;

public class BMI {
	
	private static double bmi;
	
	public static boolean setBMI(double height, double weight) {
		double heightCM = height / 100;
		bmi = (weight / heightCM) / heightCM;
		return true;
	}
	
	public static String getBMI() {
		DecimalFormat twoDecimals = new DecimalFormat("#.##");
		return twoDecimals.format(bmi);
	}
}
