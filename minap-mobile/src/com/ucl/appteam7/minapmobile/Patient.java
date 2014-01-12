/**
 * The Patient class encapsulates the 61 fields from the web application as they relate to one particular patient.
 * It is a singleton, there can only be one Patient instance at a time.
 * @author david
 */

package com.ucl.appteam7.minapmobile;

import com.ucl.appteam7.minapmobile.model.values.PatientInfo.*;
import com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis.*;
import com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission.*;

public class Patient {
	
	// Singleton set up
	private static Patient instance;
		
	private Patient() {}
	
	public static Patient get(){
		// Check if there is an existing instance
		if (instance == null)
		{
			instance = new Patient();
		}
		return instance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// Prevents a stray clone() method call
		throw new CloneNotSupportedException();
	}
	
	// Declare all fields to patient
	
	InterventionalCentreCode InterventionalCentreCode = new InterventionalCentreCode(); // used on Initial Diagnosis, Initial Reperfusion and Angiography
	// Patient Info
	HospitalIdentifier HospitalIdentifier = new HospitalIdentifier();
	PatientCaseRecordNumber RecordNumber = new PatientCaseRecordNumber();
	NHSNumber NHSNumber = new NHSNumber();
	PatientSurname Surname = new PatientSurname();
	PatientForename Forename = new PatientForename();
	DOB DOB = new DOB();
	AdmissionDate AdmissionDate = new AdmissionDate();
	
	// Initial Diagnosis
	InitialDiagnosis InitialDiagnosis = new InitialDiagnosis();
	AdmissionAfterNSTEMI AdmissionAfterNSTEMI = new AdmissionAfterNSTEMI();
	HiRisknSTEMI HighRisknSTEMI = new HiRisknSTEMI();
	InterventionalProcedure InterventionalProcedure = new InterventionalProcedure();
	ReferHospitalReturn ReferHospitalReturn = new ReferHospitalReturn();
	
	// Demographics and Admission
	Gender Gender = new Gender();
	PatientEthnicity Ethnicity = new PatientEthnicity();
	AdmissionMethod AdmissionMethod = new AdmissionMethod();
	AdmissionWard AdmissionWard = new AdmissionWard();
	GPCode GPCode = new GPCode();
	PatientPostcode PostCode = new PatientPostcode();
	AdmittingConsultant AdmitConsul = new AdmittingConsultant();
	AdminStatus AdminStatus = new AdminStatus();
	FirstECG FirstECG = new FirstECG();
	NHSVerification NHSVerification = new NHSVerification();
}
