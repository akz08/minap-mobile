/**
 * The Patient class captures all 130 fields from the web application as they relate to one particular patient.
 * In theory, caseNumber should be a unique value
 * BMI and Grace Score are calculated values from something in validation package.
 * 
 * Java representation of Patient data.
 * It is a singleton, there can only be one Patient class.
 */

package com.team7.minap.datacollection;
import com.team7.minap.utils.Algorithms;

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
	private static String invertentionalCentreCode;//4.20
	// long / short code fields
	private static byte initialReperfusion,/*3.39, options*/ reperfusionNotGiven, /*3.08, options*/ ecgDetermineTreatment,/*2.03, options*/ locationAtSTEMI,/*2.40, options*/
	ecgQRSComplex, /*2.37, options*/infarctionSite;/*2.36, options*/
	
	//setter start here!
	public static void setInvertentionalCentreCode (String iCentreCode){//4.20 set invertentionalCentreCode
		iCentreCode = invertentionalCentreCode;
	}
	
	public static void setInitialReperfusion (byte iReperfusion){//3.39, options, Initial reperfusion treatment
		iReperfusion = initialReperfusion;
		//if initialReperfusion = 0, field 2.03 2.40 2.37 3.08 show
		//if initialReperfusion = 1, field 2.03 2.36 2.37 2.40 show
		//if initialReperfusion = 2, same with option 1
		//if initialReperfusion = 3, field 2.03 2.40 2.37 3.08 4.20 show
		//if initialReperfusion = 4, same with option 3
		//if initialReperfusion = 9, same with option 1
	}
	
	public static void setReperfusionNotGiven (byte rNotGiven){//3.08,options,Reason reperfusion treatment not given
		rNotGiven = reperfusionNotGiven;
	}
	
	public static void setEcgDetermineTreatment (byte eDetermineTreatment){//2.03,options,ECG determining treatment
		eDetermineTreatment = ecgDetermineTreatment;
	}
	
	public static void setLocationAtSTEMI (byte lAtSTEMI){//2.40,options,Patient location at time of STEMI
		lAtSTEMI = locationAtSTEMI;
	}
	
	public static void setEcgQRSComplex (byte eQRSComplex){//2.37,options,ECG QRS complex duration
		eQRSComplex = ecgQRSComplex;
	}
	
	public static void setInfarctionSite (byte iSite) {//2.36,options,Site of infarction
		iSite = infarctionSite;
	}
	//setter end here!
	
	/* Page 4: Angiography */
	// interventional centre field 4.20 also needed here, variable created in pervious page.
	private static boolean angioPerformed = false,/*no field no. provided*/ patientReturnExpected = false;/*no field no. provided*/
	private static Date referralDate, /*4.15 date*/angioDate,/*4.18 date*/ localInterventionDate, /*4.19 date*/daycaseTransferDate,/*4.17 date*/ angioReferHospitalReturnDate;/*4.26 date*/
	// long / short code fields
	private static byte angioDelay,/*4.30 options*/ coronaryIntervention,/*4.14 options*/ coronaryAngiography;/*4.13, options*/
	 
	//setter start here!
	public static void setAngioPerformed (boolean aPerformed){//Was angio performed during the admission? Y/N
		aPerformed = angioPerformed;
		// if yes, field 4.15, 4.30 show, field 4.13 with options 1-4 show.
		// if no, field 4.13 with options 5-9 show
	}
	
	public static void setCoronaryAngiography(byte cAngiography){// 4.13, options Coronary Angiography
		cAngiography = coronaryAngiography;
		//if options 1 or 2 was chosen, 4.14, 4.18, 4.19 show, and interventional centre show as well
		//if options 3 or 3 was chosen, 4.14 and interventional centre show, boolean patientReturnExpected show
	}
	
	public static void setPatienReturnExpected (boolean pReturnExpected){//The patient expected to return return admission Y/N
		pReturnExpected = patientReturnExpected;
		//if yes, 4.17 and 4.26 show
		//if no, compications show(another box but not within Lucia's requirement)
	}
	
	public static void setReferralDate (Date rDate){//4.15, date, Date/time of referral for investigation/intervention
													//Data value must fall between 1st Jan 2000 and today's date.
		rDate = referralDate;
	}
	
	public static void setAngioDate (Date aDate){//4.18, data, Angio date/time
												//Data value must fall between 1st Jan 2000 and today's date.
		aDate = angioDate;
	}
	
	public static void setLocalInterventionDate (Date lInterventionDate){//4.19, date, Local intervention date
																		//Data value must fall between 1st Jan 2000 and today's date.
		lInterventionDate = localInterventionDate;
	}
	
	public static void setDaycaseTransferDate (Date dTransferDate){//4.17,date, Daycase transfer date
																	//Data value must fall between 1st Jan 2000 and today's date.
		dTransferDate = daycaseTransferDate;
	
	}
	
	public static void setAngioReferHospitalReturnDate (Date aReferHospitalReturnDate){//4.26, date, Date of return to referring hospital
																						//Data value must fall between 1st Jan 2000 and today's date.
		aReferHospitalReturnDate = angioReferHospitalReturnDate;
	}
	
	public static void setAngioDelay (byte aDelay){//4.30, options, Delay to performance of angiogram 
		aDelay = angioDelay;
	}
	
	public static void setCoronaryIntervention (byte cIntervention){//4.14,options,Coronary intervention
		cIntervention = coronaryIntervention;
	}
	//setter end here!
	
	/* Page 5: Examinations */
	private static double systolicBP,/*2.20, n3 */ heartRate, /*2.21, n3 */height,/*2.29, n3 */ weight;/*2.30, n3.1 */
	// calculated fields
	private static double BMI, GRACE;
	// long / short code fields
	private static byte killipClass;/*2.41, options */
	
	//setters start here!
	public static void setSystolicBP (double sBP){//2.20, n3, systolic blood pressure
		sBP = systolicBP;
	}
	
	public static void setHeartRate (double hRate){//2.21, n3,Heart rate
		hRate = heartRate;
	}
	
	public static void setHeight (double h){//2.29, n3, Height in cms to derive BMI.
		h = height;
	}
	
	public static void setWeight(double w){//2.30, n3, Weight in cms to derive BMI.
		w = weight;
	}
	
	public static void setKillipClass (byte kClass){//2.41, options, Killip class 
		kClass = killipClass;
	}
	//setters end here!
	
	//getters start here!
	public static void getBMI (double h,double w){
		BMI = Algorithms.calculateBMI(h,w);
	}
	
//	public static void getGRACE (){
//		
//	}
	
	//getters end here!
	
	/* Page 6: Medical History */
	// long / short code fields
	private static byte previousAMI,/*2.05 options*/ hyperTension,/*2.07 options*/ cerebrovascularDisease,/*2.10 options*/ previousAngina,/*2.06 options*/
	hyperCholesterolaemia,/*2.08 options*/ peripheralVascularDisease,/*2.09 options*/ ashtmaCOPD,/*2.11 options*/ chronicRenalFailure,/*2.12 options*/ heartFailure,/*2.13 options*/
	smokingStatus,/*2.16 options*/ diabetes,/*2.17 options*/ previousPCI,/*2.18 options*/ previousCABG,/*2.19 options*/ familyCHD;/*2.32 options*/
	
	// Setters start here!
	public static void setPreviousAMI(byte pAMI){//2.05, options, Previous AMI
		pAMI = previousAMI;
	}
	
	public static void setHyperTension (byte hTension){//2.07, options, Hypertension
		hTension = hyperTension;
	}
	
	public static void setCerebrovascularDisease (byte cDisease){//2.10, options, Cerebrovascular disease
		cDisease = cerebrovascularDisease;
	}
	
	public static void setPreviousAngina (byte pAngina){//2.06, option, Previous angina
		pAngina = previousAngina;
	}
	
	public static void setHyperCholesterolaemia (byte hCholesterolaemia){//2.08, options, Hypercholesterolaemia
		hCholesterolaemia = hyperCholesterolaemia;
	}
	
	public static void setPeripheralVascularDisease (byte pVascularDisease){//2.09, options, Peripheral vascular disease
		pVascularDisease = peripheralVascularDisease;
	}
	
	public static void setAshtmaCOPD (byte aCOPD){//2.11, options, Asthma or COPD
		aCOPD = ashtmaCOPD;
	}
	
	public static void setChronicRenalFailure (byte cRenalFailure){//2.12,options, Chronic renal failure
		cRenalFailure = chronicRenalFailure;
	}
	
	public static void setHeartFailure (byte hFailure){//2.13, options, Heart failure
		hFailure = heartFailure;
	}
	
	public static void setSmokingStatus (byte sStatus){//2.16, options, Smoking status
		sStatus = smokingStatus;
	}
	
	public static void setDiabetes (byte diabete){//2.17, options, Diabetes
		diabete = diabetes;
	}
	
	public static void setPreviousPCI (byte pPCI){//2.18, options, PreviousPCI
		pPCI = previousPCI;
	}
	
	public static void setPreviousCABG (byte pCABG){//2.19, options, PreviousCABG
		pCABG = previousCABG;
	}
	
	public static void setFamilyCHD (byte fCHD){//2.32, options, FamilyCHD
		fCHD = familyCHD;
	}
	
	
	
//==================================================================	
	
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
