/** Field 1.09 - Patient Admin Status
 * Takes in a single number (as a byte) that represents the patient's administration status
 * This field's valid options are
 * 1 - NHS
 * 2 - Private
 * 3 - Amenity
 * 9 - Unknown
 * @param admStatus
 * @author david
 */

package com.team7.minap.datacollection.values;
import java.util.Scanner;

public class AdminStatus extends Value {

	private static byte adminStatus = 1; // Field 1.09 - Defaults to 1: NHS
	private static String statusLongCode = "NHS"; // to set field's long code value
	
	public AdminStatus() {
		super("1.09", " ");
	}
	
	public static void setAdminStatus(byte admStatus) {
		// check if valid entry
		if (admStatus == 1 || admStatus == 2 || admStatus == 3 || admStatus == 9) {
			adminStatus = admStatus;
			switch (admStatus) {
			case 1 : statusLongCode = "NHS"; break;
			case 2 : statusLongCode = "Private"; break;
			case 3 : statusLongCode = "Amenity"; break;
			case 9 : statusLongCode = "Unknown"; break;
			}
		}
		else
			System.err.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	public static byte getAdminStatus() {
		return adminStatus;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte entry;
		System.out.println("Enter an Admin Status (Valid Entries: 1, 2, 3, 9)");
		Scanner sc = new Scanner(System.in);
		entry = sc.nextByte();
		setAdminStatus(entry);
		System.out.println("Admin Status: " + adminStatus + " - " + statusLongCode);
		sc.close();
	}
}
