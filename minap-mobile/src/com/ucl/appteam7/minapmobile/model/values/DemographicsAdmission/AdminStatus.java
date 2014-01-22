/** Field 1.09 - Patient Admin Status
 * Takes in a single number (as a byte) that represents the patient's administration status
 * This field's valid options are
 * 1 - NHS
 * 2 - Private
 * 3 - Amenity
 * 9 - Unknown
 * This field has no sanity checks associated with it, save for the default value
 * @param admStatus
 * @author david
 */

package com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission;

import com.ucl.appteam7.minapmobile.model.Value;

public class AdminStatus extends Value {

	private static byte adminStatus = 1; // Field 1.09 - Defaults to 1: NHS
	private static String statusLongCode = "NHS"; // to set field's long code value
	
	public AdminStatus() {
		super("1.09", " ",
				"Patient Admin Status");
	}
	
	public static boolean setAdminStatus(byte admStatus) {
		// check if valid entry
		if (admStatus == 1 || admStatus == 2 || admStatus == 3 || admStatus == 9) {
			adminStatus = admStatus;
			switch (admStatus) {
			case 1 : statusLongCode = "NHS"; break;
			case 2 : statusLongCode = "Private"; break;
			case 3 : statusLongCode = "Amenity"; break;
			case 9 : statusLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getAdminStatus() {
		return Byte.toString(adminStatus) + " - " + statusLongCode;
	}
	
	public static String getLongCode() {
		return statusLongCode;
	}
}
