package com.ucl.appteam7.minapmobile.model.values.Angiography;

import com.ucl.appteam7.minapmobile.model.Value;

public class CoronaryAngiography extends Value {
	private static byte coronaryAngiography;
	private static String coronaryAngiographyLongCode;
	public CoronaryAngiography() {	
		super("4.13", "Coronary angiography performed or arranged, "
				+ "but not as part of the initial reperfusion strategy.",
				"Coronary Angiography");
	}
	public static boolean setCoronaryAngiography(byte cAngiography) {
		// check if valid entry
		if (cAngiography == 1 || cAngiography == 2 || cAngiography == 3 || cAngiography == 4 || cAngiography == 5 || cAngiography == 6 || cAngiography == 7 || cAngiography == 8 || cAngiography == 9) {
			coronaryAngiography = cAngiography;
			switch (coronaryAngiography) {
			case 1 : coronaryAngiographyLongCode = "Protocol driven investigation performed in this hospital"; break; //Angiography indicated on basis of risk factors.
			case 2 : coronaryAngiographyLongCode = "Symptom driven investigation performed in this hospital"; break; //Angiography performed for continuing symptoms.
			case 3 : coronaryAngiographyLongCode = "Protocol driven investigation performed at another hospital"; break;//Angiography indicated on the basis of risk factors. 
																														//The hospital may be within or outside your own Trust.
			case 4 : coronaryAngiographyLongCode = "Symptom driven investigation performed at another hospital"; break;//Angiography indicated for continuing symptoms. The hospital may be within or outside your own Trust.
			case 5 : coronaryAngiographyLongCode = "Planned after discharge"; break;//Only use this option when firm arrangements are in place before discharge.
			case 6 : coronaryAngiographyLongCode = "Not applicable"; break;//For use when there is advanced malignancy, dementia, 
																			//progressive neurological disease or other conditions having an immediate impact on prognosis. 
																			//Includes other clinical reasons identified by the clinician.
			case 7 : coronaryAngiographyLongCode = "Patient refused "; break;
			case 8 : coronaryAngiographyLongCode = "Not performed"; break;
			case 9 : coronaryAngiographyLongCode = "Unknown"; break;
			}
			return true;
		}
		else
			return false;
		// set additional fields to visible here
	}
	
	public static String getCoronaryAngiography() {
		return Byte.toString(coronaryAngiography) + " - " + coronaryAngiographyLongCode;
	}
	
	public static String getLongCode() {
		return coronaryAngiographyLongCode;
	}
}
