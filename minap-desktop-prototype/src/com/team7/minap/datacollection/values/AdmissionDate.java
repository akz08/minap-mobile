/** No Field Number - Admission Date
 * Takes in a Date object that represents this patient's date of admission
 * aDate must be before or on the current date. Date format must be dd/mm/yyyy
 * @param bDate
 * @author david
 */
	
package com.team7.minap.datacollection.values;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdmissionDate extends Value {
	
	private static Date aDate; // field admission date
	private static Date now = new Date(); // to compare when setting a date in setADate
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter

	public AdmissionDate() {	
		super("Null", "Valid date<=Today. ");
	}

	public static void setADate(Date bDate) throws ParseException {
		// additional logic goes here?
		if (bDate.before(now))
			aDate = bDate;
		else
			System.err.print("Invalid Date");
	}
	
	public static void main(String[] args) throws ParseException {
		// Testing main method
		String entry;
		System.out.println("Enter a Patient's date of admission (format dd/mm/yyyy)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		Date date = sd.parse(entry);
		setADate(date);
		System.out.println("Patient Case Record Number: " + sd.format(aDate));
		sc.close();
	}
}
