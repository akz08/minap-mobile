/** Field 4.17 - Daycase Transfer
 * Takes in a Date object that represents this patient's date of daycase transfer
 * rDate must be a valid date displayed in dd/mm/yyyy format.
 * @param dDate
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.Angiography;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ucl.appteam7.minapmobile.model.Value;

public class DaycaseTransferDate extends Value {
	
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter
	private static String daycaseDate; // field 4.15
	private static final String DATE_FORMAT = "01/01/2000"; // set valid date format string (i.e. string version of VALID_SINCE
	private static String now = sd.format(new Date()); // to compare when setting a date in setDOB
	
	public DaycaseTransferDate() {	
		super("4.17", "Daycase transfer date"
				+ "Data value must fall between 1st Jan 2000 and today's date.");
	}

	public static boolean setDaycaseDate(Date dDate) throws ParseException {
		// additional logic goes here?
		final Date VALID_SINCE = sd.parse(DATE_FORMAT);
		final Date TWENTY_YEARS = sd.parse(now);
		if (dDate.after(VALID_SINCE) && dDate.before(TWENTY_YEARS)) {
			daycaseDate = sd.format(dDate);
			return true;
		}
		else
			return false;
	}
	
	public static String getDaycaseDate() {
		return daycaseDate;
	}
}