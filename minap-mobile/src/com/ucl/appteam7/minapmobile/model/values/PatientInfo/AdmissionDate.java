/** No Field Number - Admission Date
 * Takes in a Date object that represents this patient's date of admission
 * aDate must be before or on the current date. Date format must be dd/mm/yyyy
 * @param bDate
 * @author david
 */
	
package com.ucl.appteam7.minapmobile.model.values.PatientInfo;

import com.ucl.appteam7.minapmobile.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdmissionDate extends Value {
	
	private static String aDate; // field admission date
	private static Date now = new Date(); // to compare when setting a date in setADate
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter

	public AdmissionDate() {	
		super("Null", "Valid date<=Today. ");
	}

	public static boolean setADate(Date bDate) throws ParseException {
		// additional logic goes here?
		if (bDate.before(now)) {
			aDate = sd.format(bDate);
			return true;
		}
		else
			return false;
	}
	
	public static String getADate() {
		return aDate;
	}
}
