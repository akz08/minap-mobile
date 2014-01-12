 /** Field 4.15 - Referral Date
 * Takes in a Date object that represents this patient's date of referral for investigation
 * rDate must be a valid date displayed in dd/mm/yyyy format.
 * @param rDate
 * @author david
 */
package com.ucl.appteam7.minapmobile.model.values.Angiography;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ucl.appteam7.minapmobile.Value;

public class ReferralDate extends Value {
	
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter
	private static String referDate; // field 4.15
	private static final String DATE_FORMAT = "01/01/2000"; // set valid date format string (i.e. string version of VALID_SINCE
	private static String now = sd.format(new Date()); // to compare when setting a date in setDOB

	public ReferralDate() {	
		super("4.15", "Date/time of referral for investigation/intervention."
				+ "Data value must fall between 1st Jan 2000 and today's date.");
	}

	public static boolean setReferrralDate(Date rDate) throws ParseException {
		// additional logic goes here?
		final Date VALID_SINCE = sd.parse(DATE_FORMAT);
		final Date TWENTY_YEARS = sd.parse(now);
		if (rDate.after(VALID_SINCE) && rDate.before(TWENTY_YEARS)) {
			referDate = sd.format(rDate);
			return true;
		}
		else
			return false;
	}
	
	public static String getReferralDate() {
		return referDate;
	}
}