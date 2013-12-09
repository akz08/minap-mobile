 /** Field 1.06 - Date of Birth
 * Takes in a Date object that represents this patient's date of birth
 * bDate must be within current date and the year 1880; must be displayed in dd/mm/yyyy format.
 * This field is encrypted.
 * @param bDate
 */
	
package com.team7.minap.datacollection.values;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DOB extends Value {
	
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter
	private static Date dob; // field 1.06
	private static final String DATE_FORMAT = "01/01/1900"; // set valid date format string (i.e. string version of VALID_SINCE
	private static String twentyYrsAgo = "01/01/1993"; // to compare when setting a date in setDOB

	public DOB() {	
		super("1.06", "Valid date>1880 and <=Today. ");
	}

	public static void setDOB(Date bDate) throws ParseException {
		// additional logic goes here?
		final Date VALID_SINCE = sd.parse(DATE_FORMAT);
		final Date TWENTY_YEARS = sd.parse(twentyYrsAgo);
		if (bDate.after(VALID_SINCE) && bDate.before(TWENTY_YEARS))
			dob = bDate;
		else
			System.err.print("Invalid Date - Patient must be older than 20 years of age");
	}
	
	public static Date getDOB() {
		return dob;
	}
	
	public static void main(String[] args) throws ParseException {
		// Testing main method
		String entry;
		System.out.println("Enter a Patient's date of birth (format dd/mm/yyyy)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		Date date = sd.parse(entry);
		setDOB(date);
		System.out.println("Patient Case Record Number: " + sd.format(dob));
		sc.close();
	}
}
