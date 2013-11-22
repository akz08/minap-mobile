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
	private static String caseNumber;
	private static String surname, forename, nhsNumber, postCode, gpCode, ambulanceJobNumber, interventionalCode, 
	referringHospital;
	private static Date dob, symptomOnset, callHelp, firstArrival, ambulanceArrival, hospitalArrival, 
	reperfusionTreatment, cardiacArrest, nonInterventionArrival, insulinStart, dischargeDate, 
	investigationReferral, daycaseTransfer, angio, localIntervention, dateReturnReferringHospital;
	private static double serumCholesterol, bpSystolic, heartRate, serumGlucose, height, weight, 
	creatinine, haemoglobin, peakTroponin;
	
	// temporary constants
	private static double MIN_CHOLES = 2.5;
	private static double MAX_CHOLES = 25;
	/**
	 * Start of long code fields
	 */
	private static String gender, adminStatus, ethnicity, initialDiagnosis, ecgTreatment, aspirinGiven,
	prevAMI, prevAngina, hypertension, hyperCholes, perVascularDisease, cerebroVascular, asthmaCOPD, 
	renalFailure, heartFailure, cardiacRaised, smoking, diabetes, prevPCI, prevCABG, admitConsultant, 
	ecgPerformed, betaBlocker, aceiARBUse, statin, leftVEF, familyCHD, cardioCare, infarctionSite, ecgqrsDuration, 
	thienopyridineUse, admissionMethod, locationSTEMI, killip, stressEcho, iReperfusionNotGiven, treatmentDelay, 
	iReperfusionGiven, arrestLocation, presentingRhythm, arrestOutcome, admissionWard,unfractionedHeparin, 
	lmwHeparin, thienopyridineInhibitor, ivAgent, ivBetaBlocker, calciumBlocker, 
	ivNitrate, oralNitrate, potassiumModulator, warfarin, aceiARB, thiazideDiuretic, loopDiuretic, thromboDrug, 
	troponinAssay, fondaparinux, initialReperfusion, hyperglycemiaManagement, diabeticTherapyDischarge, 
	oralBetaBlocker, aldosAntagonist, bivalirudin, nonInterventionAssessment, interventionAssessment, 
	intendedProcedure, procedurePerformed, noAngio, noIntervention, dischargeDiagnosis, bleedingComplication, 
	deathInHospital, dischargeBetaBlocker, dischageACEARB, dischargeStatin, dischageAspirin, cardiacRehab, 
	exerciseTest, echoCardio, radioNuclideStudy, coronaryAngio, coronaryIntervention, dischargeDestination, 
	followedUpBy, reInfarction, dischargeThienopyridine, dischargeAldosterone, procedurePerformedAt, angioDelay,
	dischargeTicagrelor, highRiskSTEMI, smokingCessation, dietaryAdvice; 
	
	private static double bmiScore; // double might be int CHECK
	private static int graceScore;
	
	// Sample setters
	
	/**
	 * setSurname takes in a String that is then set to Patient's surname variable
	 * @param lastName
	 */
	public static void setSurname(String lastName) {
		//check type first. Needs actual parameters
		if (Validation.typeCheck(lastName, lastName))
				surname = lastName;
	}
	
	/**
	 * Model all range check fields after setSerumCholesterol method. Validation is done.	
	 * @param cholesterol
	 */
	public static void setSerumCholesterol(double cholesterol) {
		//check type first 
		// use Double.valueOf(var) instanceof Double on validation
//		String targetType = "Double", varType;
		double value1 = cholesterol;
		if (Validation.typeCheck(String varType, String targetType)) {
			if(Validation.rangeCheck(MIN_CHOLES, MAX_CHOLES, cholesterol));	
				serumCholesterol = cholesterol;
		}
		
	}
	
	public static void setDOB(Date date) {
		//check type first.
		/*
		 * if date taken in is between 20 and 120 years prior to Date.now()
		 * set dob to date
		 * else 
		 * call Validation.dobCheck.
		 */
		if(Validation.dateCheck(Date oldDate, Date newDate, Date date)){
			
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
