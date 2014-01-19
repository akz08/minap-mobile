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
		double kgs = (double)stones * 6.35029 + (double)pounds * 0.453592;
		return (int)kgs;
	}
	
	public static int feetToCms(int feet) {
		return feetAndInchesToCms(feet, 0);
	}
	
	public static int inchesToCms(int inches) {
		return feetAndInchesToCms(0, inches);
	}
	
	public static int feetAndInchesToCms(int feet, int inches) {
		double cms = (double)feet * 30.48 + (double)inches * 2.54;
		return (int)cms;
	}
}
