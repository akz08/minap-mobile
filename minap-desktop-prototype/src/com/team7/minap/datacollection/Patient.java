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
