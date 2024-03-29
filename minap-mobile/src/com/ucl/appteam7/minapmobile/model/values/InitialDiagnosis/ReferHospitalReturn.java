/** Field 4.26 - Date of Return to Referring Hospital
 * Takes in a Date object that represents the date a patients returns to a DGH after transfer to an interventional center.
 * This field becomes visible if Admission After STEMI is set to true
 * Must be displayed in dd/mm/yyyy format.
 * Must be checked when changed per sanity checks. Changed to blank if invalid.
 * @param returnDate
 * @author david
 */
	
package com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis;

import com.ucl.appteam7.minapmobile.model.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReferHospitalReturn extends Value {
	
	private static String rDate; // field admission date
	private static Date now = new Date(); // to compare when setting a date in setRDate
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter

	public ReferHospitalReturn() {	
		super("4.26", "For use when a patient is admitted to a DGH, transferred to an interventional centre and returns to the DGH.",
				"Date Of Return To Referring Hospital");
	}

	public static boolean setRDate(Date bDate) throws ParseException {
		// additional logic goes here?
		if (bDate.before(now)) {
			rDate = sd.format(bDate);
			return true;
		}
		else
			return false;
	}
	
	public static String getRDate() {
		return rDate;
	}
}
