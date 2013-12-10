package com.team7.minap.datacollection.values.page3;

import com.team7.minap.datacollection.values.Value;

public class InfarctionSite extends Value {
	private static byte infarctionSite;
	private static String infarctionSiteLongCode;
	public InfarctionSite() {	
		super("2.36", "Enter the area having the most extensive ST segment changes. ");
	}
	public static void setAngioDelay(byte iSite) {
		// check if valid entry
		if (iSite == 1 || iSite == 2 || iSite == 3 || iSite == 4 || iSite == 5 || iSite == 9) {
			iSite = infarctionSite;
			switch (infarctionSite) {
			case 1 : infarctionSiteLongCode = "Anterior"; break; 
			case 2 : infarctionSiteLongCode = "Inferior"; break; 
			case 3 : infarctionSiteLongCode = "Posterior"; break;
			case 4 : infarctionSiteLongCode = "Lateral"; break;
			case 5 : infarctionSiteLongCode = "Indeterminate"; break;//Use in presence of very extensive changes.
			case 9 : infarctionSiteLongCode = "Unknown"; break;
			}
		}
		else
			System.out.println("Invalid Entry");
		// set additional fields to visible here
	}
	
	
}
