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
	private static String caseNumber;
	private static String surname, forename, nhsNumber, postCode, hospitalID; 
	private static Date dob, admissionDate;
	
	/* Page 1: Initial Diagnosis */
	public static String interventionalCenter;
	public static boolean admissionAfterSTEMI = false;
	public static Date referringHospitalReturn;
	// long/short code fields
	private static String initialDiagnosis, hiRisknSTEMI, interventionalHospitalProcedure; 
	
	/* Page 2: Demographics */
	public static String gpCode, postalCode, nhsVerification;
	// long/short code fields
	private static String gender, ethnicity, admissionMethod, admissionWard, admissionConsultant,
	admissionStatus, firstECGPerformed;

	/* Page 3: Initial reperfusion */
	private static String invertentionalCentreCode;//no field no. given
	// long / short code fields
	private static byte initialReperfusion,/*3.39, options*/ reperfusionNotGiven, /*3.08, options*/ ecgDetermineTreatment,/*2.03, options*/ locationAtSTEMI,/*2.40, options*/
	ecgQRSComplex, /*2.37, options*/infarctionSite;/*2.36, options*/
	
	//setter start here!
	public static void setInvertentionalCentreCode (String iCentreCode){//set invertentionalCentreCode
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
	private static boolean angioPerformed = false,/*no field no. provided*/ patientReturnExpected = false;/*no field no. provided*/
	private static Date referralDate, /*4.15 date*/angioDate,/*4.18 date*/ localInterventionDate, /*4.19 date*/daycaseTransferDate,/*4.17 date*/ angioReferHospitalReturnDate;/*4.26 date*/
	private static String angioCentreCode;/*no field no. provided*/
	// long / short code fields
	private static byte angioDelay,/*4.30 options*/ coronaryIntervention;/*4.14 options*/
	 
	//setter start here!
	public static void setAngioPerformed (boolean aPerformed){//Was angio performed during the admission? Y/N
		aPerformed = angioPerformed;
		// if yes, field 4.15, 4.30 show, field 4.14 with options 1-4 show.
		// if no, field 4.14 with options 5-9 show
	}
	
	public static void setPatienReturnExpected (boolean pReturnExpected){//The patient expected to return return admission Y/N
		pReturnExpected = patientReturnExpected;
		//if yes, 4.17 and 4.26 show
		//if no, compications show(another box but not within Lucia's requirement)
	}
	
	public static void setReferralDate (Date rDate){//4.15, date, Date/time of referral for investigation/intervention
		rDate = referralDate;
	}
	
	public static void setAngioDate (Date aDate){//4.18, data, Angio date/time
		aDate = angioDate;
	}
	
	public static void setLocalInterventionDate (Date lInterventionDate){//4.19, date, Local intervention date
		lInterventionDate = localInterventionDate;
	}
	
	public static void setDaycaseTransferDate (Date dTransferDate){//4.17,date, Daycase transfer date
		dTransferDate = daycaseTransferDate;
	
	}
	
	public static void setAngioReferHospitalReturnDate (Date aReferHospitalReturnDate){//4.26, date, Date of return to referring hospital
		aReferHospitalReturnDate = angioReferHospitalReturnDate;
	}
	
	public static void setAngioCentreCode (String aCentreCode){//???
		aCentreCode = angioCentreCode;
	}
	
	public static void setAngioDelay (byte aDelay){//4.30, options, Delay to performance of angiogram 
		aDelay = angioDelay;
	}
	
	public static void setCoronaryIntervention (byte cIntervention){//4.14,options,Coronary intervention
		cIntervention = coronaryIntervention;
		//if options 1 or 2 was chosen, 4.14, 4.18, 4.19 show, and interventional centre show as well
		//if options 3 or 3 was chosen, 4.14 and interventional centre show, boolean patientReturnExpected show
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
	private static String previousAMI, hyperTension, cerebrovascularDisease, previousAngina,
	hyperCholesterolaemia, peripheralVascularDisease, ashtmaCOPD, chronicRenalFailure, heartFailure,
	smokingStatus, diabetes, previousPCI, previousCABG, familyCHD;
	// Sample setters
	
	/**
	 * setSurname takes in a String that is then set to Patient's surname variable
	 * @param lastName
	 */
	public static void setSurname(String lastName) {
		//check type first. Needs actual parameters
		if (Validation.typeCheck(lastName, lastName))
				surname = lastName;
				String surnameDone = "yes";
	}
	
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
	
	public static void setDOB(Date date) {
		//check type first.		
		if(Validation.dateCheck(Date oldDate, Date newDate, Date date)){
			/*
			 * if date taken in is between 20 and 120 years prior to Date.now()
			 * set dob to date
			 */
			String dobDone = "yes";
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
