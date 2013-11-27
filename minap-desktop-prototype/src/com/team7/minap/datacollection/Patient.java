/**
 * The Patient class captures all 130 fields from the web application as they relate to one particular patient.
 * In theory, caseNumber should be a unique value
 * BMI and Grace Score are calculated values from something in validation package.
 * 
 * Java representation of Patient data.
 * It is a singleton, there can only be one Patient class.
 */

package com.team7.minap.datacollection;

import java.util.Date;
import java.lang.Double;
import com.team7.minap.validation.Validation;

public class Patient {
	/* Page 0: Patient Info */
	private static String caseNumber; // 1.02
	private static String surname, forename, hospitalID; // 1.04, 1.05, 1.01
	private static int nhsNumber; // 1.03
	private static Date dob, admissionDate; // 1.06, ad Date has no field code
	
	/** Field 1.02 - Patient Case Record Number
	 * Takes in an alphanumeric string that uniquely identifies this particular patient's data.
	 * cNumber must be 10 characters long. This field is encrypted.
	 * @param cNumber
	 */
	public static void setCaseNumber(String cNumber) {
		// additional logic goes here?
		caseNumber = cNumber;
	}
	
	/** Field 1.04 - Patient surname
	 * Takes in an alphanumeric string that represents a patient's surname(s).
	 * sName must be no more than 35 characters long. This field is encrypted
	 * @param sName
	 */
	public static void setSurname(String sName) {
		// additional logic goes here?
		surname = sName;
	}
	
	/** Field 1.05 Patient forename
	 * Takes in an alphanumeric string that represents a patient's forename(s).
	 * fName must be no more than 35 characters long. This field is encrypted.
	 * @param fName
	 */
	public static void setForename(String fName) {
		// additional logic goes here?
		forename = fName;
	}
	
	/** Field 1.01 - Hospital Identifier
	 * Takes in an alphabetic string that represents a hospital's identifier.
	 * hID must be 3 characters long.
	 * @param hID
	 */
	public static void setHospitalIdentifier(String hID) {
		// additional logic goes here?
		hospitalID = hID;
	}
	
	/** Field 1.03 - NHS Number
	 * Takes in a unique NHS number that represents this patient.
	 * nhsNum must be 10 characters long. This field is encrypted
	 * @param nhsNum
	 */
	public static void setNHSNumber(int nhsNum) {
		// additional logic goes here?
		nhsNumber = nhsNum;
	}
	
	/** Field 1.06 - Date of Birth
	 * Takes in a Date object that represents this patient's date of birth
	 * bDate must be within current date and the year 1880; must be displayed in dd/mm/yyyy format.
	 * This field is encrypted.
	 * @param bDate
	 */
	public static void setDOB(Date bDate) {
		// additional logic goes here?
		dob = bDate;
	}
	
	/** No Field Number - Admission Date
	 * Takes in a Date object that represents the date the patient was admitted to the hospital
	 * Must be displayed in dd/mm/yyyy format.
	 * @param aDate
	 */
	public static void setAdmissionDate(Date aDate) {
		// additional logic goes here?
		admissionDate = aDate;
	}
	
	/* Page 1: Initial Diagnosis */
	private static String interventionalCenter; // no field number
	private static boolean admissionAfterSTEMI = false; // no field number
	private static Date referringHospitalReturn; // 4.26
	// long/short code fields
	private static byte initialDiagnosis, hiRisknSTEMI, interventionalHospitalProcedure; // 2.01, 4.32, 4.29
	
	/** No Field Number - Interventional Center
	 * Takes in a String that represents the Interventional Center for this patient.
	 * This field becomes visible if Admission After STEMI is set to true
	 * @param intCenter
	 */
	public static void setInterventionCenter(String intCenter) {
		// additional logic goes here
		interventionalCenter = intCenter;
	}
	
	/** No Field Number - Admission After STEMI
	 * Takes in a boolean value to represent admission after STEMI for this patient
	 * If set to true, fields 4.29, 4.26 and Interventional Center become available
	 * @param admASTEMI
	 */
	public static void setAdmissionAfterSTEMI(boolean admASTEMI) {
		// additional logic goes here?
		admissionAfterSTEMI = admASTEMI;
		// set additional fields to visible here
	}
	
	/** Field 4.26 - Date of Return to Referring Hospital
	 * Takes in a Date object that represents the date a patients returns to a DGH after transfer to an interventional center.
	 * This field becomes visible if Admission After STEMI is set to true
	 * Must be displayed in dd/mm/yyyy format.
	 * @param returnDate
	 */
	public static void setHospitalReturn(Date returnDate) {
		// additional logic goes here?
		referringHospitalReturn = returnDate;
	}
	
	/** Field 2.01 - Initial Diagnosis
	 * Takes in a single number (as a byte) that represents the patient's initial diagnosis.
	 * This field's valid options are 
	 * 1 - Definite Myocardial Infarction
	 * 3 - Acute Coronary Syndrome
	 * 4 - Chest pain? cause
	 * 5 - Other Initial Diagnosis.
	 * If option 3 (Acute Coronary Syndrome) is chosen, field 4.32 (High Risk nSTEMI) becomes visible
	 * @param iniDiagnosis  
	 */
	public static void setInitialDiagnosis(byte iniDiagnosis) {
		// additional logic goes here?
		initialDiagnosis = iniDiagnosis;
		// set additional fields to visible here
	}
	
	/** Field 4.32 - High Risk nSTEMI
	 * Takes in a single number (as a byte) that represents the patient's risk for STEMI.
	 * This field becomes visible if option 3 (Acute Coronary Syndrome) is chosen for field 2.01 (Initial Diagnosis)
	 * This field's valid options are 
	 * 0 - No
	 * 1 - Yes
	 * 9 - Unknown. 
	 * @param hiNSTEMI
	 */
	public static void setHiRisknSTEMI(byte hiNSTEMI) {
		// additional logic goes here?
		hiRisknSTEMI = hiNSTEMI;
	}
	
	/** Field 4.29 - What Procedure was Performed at the Interventional Hospital 
	 * Takes in a single number (as a byte) that represents the patient's procedure at an interventional hospital
	 * This field becomes visible if Admission After STEMI is true
	 * This field has the following valid options:
	 * 0 - None
	 * 1 - Delay due to comorbid clinical condition / competing clinical issue
	 * 2 - Capacity issues
	 * 3 - Patient preference
	 * 8 - Other
	 * 9 - Unknown
	 * @ param interHosProcedure
	 */
	public static void setInterventionalProcedure(byte interHosProcedure) {
		// additional logic goes here?
		interventionalHospitalProcedure = interHosProcedure;
	}
	
	/* Page 2: Demographics */
	public static String gpCode, postalCode, nhsVerification; // 1.11, 1.10, no field number
	// long/short code fields
	private static byte gender, ethnicity, admissionMethod, admissionWard, admissionConsultant, // 1.07, 1.13, 2.39, 3.17, 2.22, 
	admissionStatus, firstECGPerformed; // 1.09, 2.23

	/** Field 1.11 - GP / PCT Code
	 * Takes a String that represents the patient's GP/PCT's code.
	 * gpctCode must be 6 characters long. This field is encrypted.
	 * @param gpctCode 
	 */
	public static void setGPCode(String gpctCode) {
		// additional logic goes here?
		gpCode = gpctCode;
	}
	
	/** Field 1.10 - Patient postcode
	 * Takes in an alphanumeric string that represents a patient's postcode.
	 * pCode must be 8 characters long. This field is encrypted.
	 * @param pCode
	 */
	public static void setPostCode(String pCode) {
		// additional logic goes here?
		postalCode = pCode;
	}
	
	/** No Field Number - NHS Verification
	 * Takes in a String that verifies the patient's NHS number
	 * @param nhsVerif
	 */
	public static void setNHSVerification(String nhsVerif) {
		// additional logic goes here?
		nhsVerification = nhsVerif;
	}
	
	/** Field 1.07 - Gender
	 * Takes a single number (as a byte) that represents the patient's gender.
	 * This field's valid options are 
	 * 0 - Not Known
	 * 1 - Male
	 * 2 - Female
	 * 9 - Not Specified.
	 * @param gen
	 */
	public static void setGender(byte gen) {
		// additional logic goes here?
		gender = gen;
	}
	
	/** Field 1.13 - Patient Ethnicity
	 * Takes in a single number (as a byte) that represents the patient's ethnicity
	 * This field's valid options are
	 * 1 - White
	 * 2 - Black
	 * 3 - Asian
	 * 5 - Mixed
	 * 6 - Not Stated
	 * 8 - Other
	 * 9 - Unknown
	 * @param ethnic
	 */
	public static void setEthnicity(byte ethnic) {
		// additional logic goes here?
		ethnicity = ethnic;
	}
	
	/** Field 2.39 - Admission Method
	 * Takes in a single number (as a byte) that represents the patient's admission method
	 * This field's valid options are
	 * 1 - Direct admission via emergency service
	 * 2 - Self presenter to this hospital
	 * 3 - Already in this hospital
	 * 4 - Inter-hospital transfer for specific treatment
	 * 5 - Repatriation after coronary intervention
	 * 6 - Other
	 * 9 - Unknown
	 * @param admMet
	 */
	public static void setAdmMethod(byte admMet) {
		// additional logic goes here?
		admissionMethod = admMet;
	}
	
	/** Field 3.17 - Admission Ward
	 * Takes in a single number (as a byte) that represents the patient's admission ward
	 * This field's valid options are
	 * 1 - Cardiac Care Unit
	 * 2 - Acute Admissions Unite
	 * 3 - General Medical Ward
	 * 4 - Intensive Therapy Unit
	 * 5 - Other
	 * 6 - Died in A & E
	 * 7 - Cardiac Ward (non CCU)
	 * 8 - Stepdown Ward
	 * 9 - Unknown
	 * @param admWard
	 */
	public static void setAdmissionWard(byte admWard) {
		// additional logic goes here?
		admissionWard = admWard;
	}
	
	/** Field 2.22 - Admitting Consultant
	 * Takes in a single number (as a byte) that represents the patient's admitting consultant
	 * This field's valid options are
	 * 0 - Cardiologist
	 * 1 - Other General Physician
	 * 9 - Other
	 * 99 - Unknown
	 * @param admConsul
	 */
	public static void setAdmittingConsultant(byte admConsul) {
		// additional logic goes here?
		admissionConsultant = admConsul;
	}
	
	/** Field 1.09 - Patient Admin Status
	 * Takes in a single number (as a byte) that represents the patient's administration status
	 * This field's valid options are
	 * 1 - NHS
	 * 2 - Private
	 * 3 - Amenity
	 * 9 - Unknown
	 * @param admStatus
	 */
	public static void setAdminStatus(byte admStatus) {
		admissionStatus = admStatus;
	}
	
	/** Field 2.23 - Place First 12 Lead ECG Performed
	 * Takes in a single number (as a byte) that represents the place the patient's first ECG was performed
	 * This field's valid options are 
	 * 1 - Ambulance
	 * 2 - In Hospital
	 * 3 - Other Healthcare Facility
	 * 9 - Unknown
	 * @param fECG
	 */
	public static void setFirstECG(byte fECG) {
		// additional logic goes here?
		firstECGPerformed = fECG;
	}
	
	
	/* Page 3: Initial reperfusion */
	public static String invertentionalCentreCode;
	// long / short code fields
	public static String initialReperfusion, reperfusionNotGiven, ecgDetermineTreatment, locationAtSTEMI,
	ecgQRSComplex, infarctionSite;
	
	/* Page 4: Angiography */
	public static boolean angioPerformed = false, patientReturnExpected = false;
	public static Date referralDate, angioDate, localIntervention, daycaseTransfer, angioReferHospitalReturn;
	public static String angioCentreCode;
	// long / short code fields
	public static String angioDelay, coronaryIntervention;
	
	/* Page 5: Examinations */
	public static double systolicBP, heartRate, height, weight;
	// calculated fields
	public static double BMI, GRACE;
	// long / short code fields
	public static String killipClass;
	
	/* Page 6: Medical History */
	// long / short code fields
	public static String previousAMI, hyperTension, cerebrovascularDisease, previousAngina,
	hyperCholesterolaemia, peripheralVascularDisease, ashtmaCOPD, chronicRenalFailure, heartFailure,
	smokingStatus, diabetes, previousPCI, previousCABG, familyCHD;
	// Sample setters
	/**
	 * Model all range check fields after setSerumCholesterol method. Validation is done.	
	 * @param cholesterol
	 */
	public static void setSerumCholesterol(double cholesterol) {
		//check type first 
		// use Double.valueOf(var) instanceof Double on validation
//		String targetType = "Double", varType;
		String targetType = "double";
		double value1 = cholesterol;
		if (Validation.typeCheck(String varType, String targetType)) {
			if(Validation.rangeCheck(MIN_CHOLES, MAX_CHOLES, cholesterol));	
				serumCholesterol = cholesterol;
				// then set some boolean to true preparing for submission.
				String serumCholesterolDone = "yes";
		}
		
	}
	
	//Sample getters
	
	public static String getSurname() {
		//getting surname
		return surname;
	}
	
	public static double getSerumCholesterol(){
		//getting SerumCholesterol
		return serumCholesterol;
	}
	
	public static Date getDOB(){
		//getting DOB
		return dob;
	}
	
	// calculated methods
	public static void calcBMI() {
		// assume calculators are valid
		// once last calculator is entered, bmiScore should be pushed to appropriate field
		// if (calculators are filled or not empty		
		//bmiScore = height(cm) / weight(kg); // <- temporary placeholder calculation
		// set bmi field to bmiScore
	}
}
