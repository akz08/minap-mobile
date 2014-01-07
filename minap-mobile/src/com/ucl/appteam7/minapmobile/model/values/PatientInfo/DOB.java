 /** Field 1.06 - Date of Birth
 * Takes in a Date object that represents this patient's date of birth
 * bDate must be within current date and the year 1880; must be displayed in dd/mm/yyyy format.
 * This field is encrypted.
 * @param bDate
 */
	
package com.ucl.appteam7.minapmobile.model.values.PatientInfo;

import com.ucl.appteam7.minapmobile.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DOB extends Value {
	
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter
	private static String dob; // field 1.06
	private static final String DATE_FORMAT = "01/01/1900"; // set valid date format string (i.e. string version of VALID_SINCE
	private static String twentyYrsAgo = "01/01/1994"; // to compare when setting a date in setDOB

	public DOB() {	
		super("1.06", "Valid date>1880 and <=Today. ");
	}

	public static boolean setDOB(Date bDate) throws ParseException {
		// additional logic goes here?
		final Date VALID_SINCE = sd.parse(DATE_FORMAT);
		final Date TWENTY_YEARS = sd.parse(twentyYrsAgo);
		if (bDate.after(VALID_SINCE) && bDate.before(TWENTY_YEARS)) {
			dob = sd.format(bDate);
			return true;
		}
		else
			return false;
	}
	
	public static String getDOB() {
		return dob;
	}
}
// How to add and format a date
//String DateStr="12/12/1988";
//Date d = new Date();
//SimpleDateFormat sim=new SimpleDateFormat("mm/dd/yyyy");
//try {
//	d = new SimpleDateFormat("mm/dd/yyyy").parse(DateStr);
//} catch (ParseException e1) {
//	// TODO Auto-generated catch block
//	e1.printStackTrace();
//} 
//
//try {
//	if (patient.DOB.setDOB(d))
//		Toast.makeText(this, patient.DOB.getDOB(), Toast.LENGTH_LONG).show();
//	else
//		Toast.makeText(this, "Invalid length", Toast.LENGTH_LONG).show();
//} catch (ParseException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}

