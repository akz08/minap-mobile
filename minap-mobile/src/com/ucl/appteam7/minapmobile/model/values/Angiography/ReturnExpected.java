/** No Field Number - Admission After STEMI
 * Takes in a boolean value to represent admission after STEMI for this patient
 * If set to true, fields 4.29, 4.26 and Interventional Center become available
 * @param rExpected
 * @author david
 */
	
package com.ucl.appteam7.minapmobile.model.values.Angiography;

import com.ucl.appteam7.minapmobile.Value;

public class ReturnExpected extends Value {
	
	private static boolean returnExpected = false;
	
	public ReturnExpected() {
		super("Null", "If set to true, show fields 4.29, 4.26 and Interventional Centre");
	}
	
	public static boolean setReturnExpected(boolean rExpected) {
		// additional logic goes here?
		returnExpected = rExpected;
		// set additional fields to visible here
		return returnExpected;
	}
	
	public static String getReturnExpected() {
		return Boolean.toString(returnExpected);
	}
}
