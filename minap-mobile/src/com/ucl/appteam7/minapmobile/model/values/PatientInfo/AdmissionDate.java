/** Field 3.06 - Admission Date
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
	
	private static String adminDate; // field admission date
	private static String adminTime; // field admission time
	private static String adminDateTime; // field admission date/time
	private static Date now = new Date(); // to compare when setting a date in setADate / setATime
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter
	static SimpleDateFormat st = new SimpleDateFormat("HH:mm"); // time formatter
	static SimpleDateFormat sdt = new SimpleDateFormat("dd/mm/yyy HH:mm"); // date - time formatter

	public AdmissionDate() {	
		super("Null", "Valid date<=Today. ");
	}

	public static boolean setDateTime() {
		adminDateTime = adminDate + " " + adminTime;
		Date formatDateTime = null;
		try {
			formatDateTime = sdt.parse(adminDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (formatDateTime.before(now))
			return true;
		else
			return false;
	}
	
	public static boolean setADate(Date aDate) throws ParseException {
		// additional logic goes here?
		if (aDate.before(now)) {
			adminDate = sd.format(aDate);
			return true;
		}
		else
			return false;
	}
	
	public static boolean setATime(Date aTime) throws ParseException {
		if (aTime.before(now)) {
			adminTime = st.format(aTime);
			return true;
		}
		else
			return false;
	}

	public static String getDateTime() {
		return adminDateTime;
	}
	public static String getADate() {
		return adminDate;
	}
	
	public static String getATime() {
		return adminTime;
	}
}
