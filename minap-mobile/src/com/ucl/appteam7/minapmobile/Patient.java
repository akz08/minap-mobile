/**
 * The Patient class encapsulates the 61 fields from the web application as they relate to one particular patient.
 * It is a singleton, there can only be one Patient instance at a time.
 * @author david
 */

package com.ucl.appteam7.minapmobile;

import com.ucl.appteam7.minapmobile.model.values.PatientInfo.*;
import com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis.*;
import com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission.*;
import com.ucl.appteam7.minapmobile.model.values.InitialReperfusion.*;

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
	public HospitalIdentifier HospitalIdentifier = new HospitalIdentifier();
	public PatientCaseRecordNumber RecordNumber = new PatientCaseRecordNumber();
	public NHSNumber NHSNumber = new NHSNumber();
	public PatientSurname Surname = new PatientSurname();
	public PatientForename Forename = new PatientForename();
	public DOB DOB = new DOB();
	public AdmissionDate AdmissionDate = new AdmissionDate();
	
	// Initial Diagnosis
	public InitialDiagnosis InitialDiagnosis = new InitialDiagnosis();
	public AdmissionAfterNSTEMI AdmissionAfterNSTEMI = new AdmissionAfterNSTEMI();
	public HiRisknSTEMI HighRisknSTEMI = new HiRisknSTEMI();
	public InterventionalProcedure InterventionalProcedure = new InterventionalProcedure();
	public ReferHospitalReturn ReferHospitalReturn = new ReferHospitalReturn();
	public InterventionalCentreCode InterventionalCentreCode = new InterventionalCentreCode(); // used on Initial Diagnosis, Initial Reperfusion and Angiography
	
	// Demographics and Admission
	public Gender Gender = new Gender();
	public PatientEthnicity Ethnicity = new PatientEthnicity();
	public AdmissionMethod AdmissionMethod = new AdmissionMethod();
	public AdmissionWard AdmissionWard = new AdmissionWard();
	public GPCode GPCode = new GPCode();
	public PatientPostcode PostCode = new PatientPostcode();
	public AdmittingConsultant AdmitConsul = new AdmittingConsultant();
	public AdminStatus AdminStatus = new AdminStatus();
	public FirstECG FirstECG = new FirstECG();
	public NHSVerification NHSVerification = new NHSVerification();
	
	// Initial Reperfusion
	public InitialReperfusion InitialReperfusion = new InitialReperfusion();
	public ReperfusionNotGiven ReperfusionNotGiven = new ReperfusionNotGiven();
	public EcgDetermineTreatment ECGTreatment = new EcgDetermineTreatment();
	public EcgQRSComplex ECG_QRSComplex = new EcgQRSComplex();
	public LocationAtSTEMI LocationSTEMI = new LocationAtSTEMI();
	public InterventionalCentreCode ReperfusionCentreCode = new InterventionalCentreCode();
	public InfarctionSite InfarctionSite = new InfarctionSite();
}
