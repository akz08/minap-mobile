/** Field 1.06 - Date of Birth
 * Takes in a Date object that represents this patient's date of birth
 * bDate must be within current date and the year 1880; must be displayed in dd/mm/yyyy format.
 * This field is encrypted.
 * @param bDate
 */
	
package com.team7.minap.datacollection.values;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DOB extends Value {
	
	private static Date dob; // field 1.06
	private static final String DATE_FORMAT = "01/01/1880"; // set valid date format string (i.e. string version of VALID_SINCE
	private static Date now = new Date(); // to compare when setting a date in setDOB
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter

	public DOB() {	
		super("1.06", "Valid date>1880 and <=Today. ");
	}

	public static void setDOB(Date bDate) throws ParseException {
		// additional logic goes here?
		final Date VALID_SINCE = sd.parse(DATE_FORMAT);
		if (bDate.after(VALID_SINCE) && bDate.before(now))
			dob = bDate;
		else
			System.err.print("Invalid Date");
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
