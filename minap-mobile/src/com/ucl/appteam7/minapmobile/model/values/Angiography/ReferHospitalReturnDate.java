 /** Field 4.26 - Angiography Date
 * Takes in a Date object that represents this patient's angiography date
 * rDate must be a valid date displayed in dd/mm/yyyy format.
 * @param rhrDate
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.Angiography;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ucl.appteam7.minapmobile.Value;

public class ReferHospitalReturnDate extends Value {

	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter
	private static String returnDate; // field 4.15
	private static final String DATE_FORMAT = "01/01/2000"; // set valid date format string (i.e. string version of VALID_SINCE
	private static String now = sd.format(new Date()); // to compare when setting a date in setDOB

	public ReferHospitalReturnDate() {	
		super("4.26", "Date of return to referring hospital."
				+ "Data value must fall between 1st Jan 2000 and today's date.");
	}

	public static boolean setReturnDate(Date rhrDate) throws ParseException {
		// additional logic goes here?
		final Date VALID_SINCE = sd.parse(DATE_FORMAT);
		final Date TWENTY_YEARS = sd.parse(now);
		if (rhrDate.after(VALID_SINCE) && rhrDate.before(TWENTY_YEARS)) {
			returnDate = sd.format(rhrDate);
			return true;
		}
		else
			return false;
	}
	
	public static String getReturnDate() {
		return returnDate;
	}
}