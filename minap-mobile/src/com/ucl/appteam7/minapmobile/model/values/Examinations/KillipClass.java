/**
 * This field has no sanity checks associated with it
 */
package com.ucl.appteam7.minapmobile.model.values.Examinations;

import com.ucl.appteam7.minapmobile.model.Value;

public class KillipClass extends Value {
	private static byte killipClass;
	private static String killipClassLongCode;
	public KillipClass() {	
		super("2.41", "A part of the GRACE score.  "
				+ "The worst category developing during the admission should be used.",
				"Killip Class");
	}
	public static boolean setKillipClass(byte kClass) {
		// check if valid entry
		if (kClass == 1 || kClass == 2 || kClass == 3 || kClass == 4 || kClass == 8 || kClass == 9) {
			killipClass = kClass;
			switch (killipClass) {
			case 1 : killipClassLongCode = "No evidence of heart failure"; break; 
			case 2 : killipClassLongCode = "Basal crepitations and/or elevated venous pressure"; break; 
			case 3 : killipClassLongCode = "Pulmonary oedema"; break; //Extensive lung crepitations consistent with pulmonary oedema, or confirmatory X ray evidence.
			case 4 : killipClassLongCode = "Cardiogenic shock"; break;//Hypotension, poor tissue perfusion 
																		//and oliguria due to venticular dysfunction in the presence of raised filling pressures.
			case 8 : killipClassLongCode = "Not applicable"; break;//Where patient dies or is transferred early in the event.
			case 9 : killipClassLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
	}
	
	public static String getKillipClass() {
		return Byte.toString(killipClass) + " - " + killipClassLongCode;
	}
	
	public static String getLongCode() {
		return killipClassLongCode;
	}
}
