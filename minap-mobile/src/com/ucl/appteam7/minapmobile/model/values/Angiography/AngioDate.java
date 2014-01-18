 /** Field 4.18 - Angiography Date
 * Takes in a Date object that represents this patient's angiography date
 * rDate must be a valid date displayed in dd/mm/yyyy format.
 * @param aDate
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.Angiography;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ucl.appteam7.minapmobile.Value;

public class AngioDate extends Value {
	
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter
	static SimpleDateFormat st = new SimpleDateFormat("HH:mm"); // time format
	static SimpleDateFormat sdt = new SimpleDateFormat("dd/mm/yyy HH:mm"); // date - time format
	private static String angioDate; // field 4.15
	private static String angioTime;
	private static String angioDateTime;
	private static final String DATE_FORMAT = "01/01/2000"; // set valid date format string (i.e. string version of VALID_SINCE
	private static Date now = new Date(); // to compare when setting a date in setDOB

	public AngioDate() {	
		super("4.18", "Angio date/time."
				+ "Data value must fall between 1st Jan 2000 and today's date.");
	}

	public static boolean setDateTime() {
		angioDateTime = angioDate + " " + angioTime;
		Date formatDateTime = null;
		try {
			formatDateTime = sdt.parse(angioDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (formatDateTime.before(now))
			return true;
		else
			return false;
	}
	
	public static boolean setAngioDate(Date aDate) throws ParseException {
		// additional logic goes here?
		final Date VALID_SINCE = sd.parse(DATE_FORMAT);
		if (aDate.after(VALID_SINCE) && aDate.before(now)) {
			angioDate = sd.format(aDate);
			return true;
		}
		else
			return false;
	}
	
	public static boolean setAngioTime(Date aTime) throws ParseException {
		if (aTime.before(now)) {
			angioTime = st.format(aTime);
			return true;
		}
		else
			return false;
	}
	
	public static String getDateTime(){
		return angioDateTime;
	}
	
	public static String getAngioDate() {
		return angioDate;
	}
	
	public static String getAngioTime() {
		return angioTime;
	}
}