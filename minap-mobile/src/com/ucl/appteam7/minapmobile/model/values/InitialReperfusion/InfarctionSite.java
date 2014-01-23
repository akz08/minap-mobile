/**
 * This field has no sanity checks associated with it
 */
package com.ucl.appteam7.minapmobile.model.values.InitialReperfusion;

import com.ucl.appteam7.minapmobile.model.Value;

public class InfarctionSite extends Value {
	private static byte infarctionSite;
	private static String infarctionSiteLongCode;
	public InfarctionSite() {	
		super("2.36", "Enter the area having the most extensive ST segment changes. ",
				"Site Of Infarction");
	}
	public static boolean setInfarctionSite(byte iSite) {
		// check if valid entry
		if (iSite == 1 || iSite == 2 || iSite == 3 || iSite == 4 || iSite == 5 || iSite == 9) {
			infarctionSite = iSite;
			switch (infarctionSite) {
			case 1 : infarctionSiteLongCode = "Anterior"; break; 
			case 2 : infarctionSiteLongCode = "Inferior"; break; 
			case 3 : infarctionSiteLongCode = "Posterior"; break;
			case 4 : infarctionSiteLongCode = "Lateral"; break;
			case 5 : infarctionSiteLongCode = "Indeterminate"; break;//Use in presence of very extensive changes.
			case 9 : infarctionSiteLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getInfarctionSite() {
		return Byte.toString(infarctionSite) + " - " + infarctionSiteLongCode;
	}
	
	public static String getLongCode() {
		return infarctionSiteLongCode;
	}
}
