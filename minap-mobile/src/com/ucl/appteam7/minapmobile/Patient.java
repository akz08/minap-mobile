/**
 * The Patient class encapsulates the 61 fields from the web application as they relate to one particular patient.
 * It is a singleton, there can only be one Patient instance at a time.
 * @author david
 */

package com.ucl.appteam7.minapmobile;

import com.ucl.appteam7.minapmobile.model.values.PatientInfo.*;
import com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis.*;

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
}
