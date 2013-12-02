/** Field 4.26 - Date of Return to Referring Hospital
 * Takes in a Date object that represents the date a patients returns to a DGH after transfer to an interventional center.
 * This field becomes visible if Admission After STEMI is set to true
 * Must be displayed in dd/mm/yyyy format.
 * @param returnDate
 * @author david
 */
	
package com.team7.minap.datacollection.values;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReferHospitalReturn extends Value {
	
	private static Date rDate; // field admission date
	private static Date now = new Date(); // to compare when setting a date in setRDate
	static SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy"); // date formatter

	public ReferHospitalReturn() {	
		super("4.26", "For use when a patient is admitted to a DGH, transferred to an interventional centre and returns to the DGH.");
	}

	public static void setRDate(Date bDate) throws ParseException {
		// additional logic goes here?
		if (bDate.before(now))
			rDate = bDate;
		else
			System.err.print("Invalid Date");
	}
	
	public static void main(String[] args) throws ParseException {
		// Testing main method
		String entry;
		System.out.println("Enter a Patient's date of return to referring hospital (format dd/mm/yyyy)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextLine();
		Date date = sd.parse(entry);
		setRDate(date);
		System.out.println("Patient Case Record Number: " + sd.format(rDate));
		sc.close();
	}
}
