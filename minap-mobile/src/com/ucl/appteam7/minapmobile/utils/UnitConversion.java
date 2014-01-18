/**
 * A unit conversion class to be used primarily for unit conversion in the Examinations section for BMI
 * 
 */

package com.ucl.appteam7.minapmobile.utils;

public class UnitConversion {

	public static int stonesToKg(int stones) {
		return stonesAndPoundsToKg(stones, 0);
	}
	
	public static int poundsToKg(int pounds) {
		return stonesAndPoundsToKg(0, pounds);
	}
	
	public static int stonesAndPoundsToKg(int stones, int pounds) {
		// TODO: add in conversion logic
		return 0;
	}
	
	public static int feetToCms(int feet) {
		return feetAndInchesToCms(feet, 0);
	}
	
	public static int inchesToCms(int inches) {
		return feetAndInchesToCms(0, inches);
	}
	
	public static int feetAndInchesToCms(int feet, int inches) {
		// TODO: add in conversion logic
		return 0;
	}
}
