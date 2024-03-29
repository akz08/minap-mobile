/**
 * The Patient class encapsulates the 61 fields from the web application as they relate to one particular patient.
 * It is a singleton, there can only be one Patient instance at a time.
 * @author david
 */

package com.ucl.appteam7.minapmobile.model;

import com.ucl.appteam7.minapmobile.model.values.PatientInfo.*;
import com.ucl.appteam7.minapmobile.model.values.InitialDiagnosis.*;
import com.ucl.appteam7.minapmobile.model.values.DemographicsAdmission.*;
import com.ucl.appteam7.minapmobile.model.values.InitialReperfusion.*;
import com.ucl.appteam7.minapmobile.model.values.Angiography.*;
import com.ucl.appteam7.minapmobile.model.values.Examinations.*;
import com.ucl.appteam7.minapmobile.model.values.MedicalHistory.*;

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
	public 	PatientCaseRecordNumber RecordNumber = new PatientCaseRecordNumber();
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
	public ReferralHospital ReferralHospital = new ReferralHospital();
	
	// Initial Reperfusion
	public InitialReperfusion InitialReperfusion = new InitialReperfusion();
	public ReperfusionNotGiven ReperfusionNotGiven = new ReperfusionNotGiven();
	public EcgDetermineTreatment ECGTreatment = new EcgDetermineTreatment();
	public EcgQRSComplex ECG_QRSComplex = new EcgQRSComplex();
	public LocationAtSTEMI LocationSTEMI = new LocationAtSTEMI();
	public InterventionalCentreCode ReperfusionCentreCode = new InterventionalCentreCode();
	public InfarctionSite InfarctionSite = new InfarctionSite();
	
	// Angiography
	public CoronaryAngiography CoronaryAngiography = new CoronaryAngiography();
	public ReferralDate ReferralDate = new ReferralDate();
	public AngioDelay AngioDelay = new AngioDelay();
	public AngioDate AngioDate = new AngioDate();
	public InterventionalCentreCode AngioCentreCode = new InterventionalCentreCode();
	public LocalInterventionDate InterventionDate = new LocalInterventionDate();
	public CoronaryIntervention CoronaryIntervention = new CoronaryIntervention();
	public ReturnExpected ReturnExpected = new ReturnExpected();
	public DaycaseTransferDate DaycaseTransfer = new DaycaseTransferDate();
	public ReferHospitalReturnDate ReferReturnDate = new ReferHospitalReturnDate();
	
	// Examinations
	public SystolicBP Systolic = new SystolicBP();
	public HeartRate HeartRate = new HeartRate();
	public KillipClass Killip = new KillipClass();
	public Height Height = new Height();
	public Weight Weight = new Weight();
	public BMI BMI = new BMI();
	
	// Medical History
	public PreviousAMI PreviousAMI = new PreviousAMI();
	public Hypertension Hypertension = new Hypertension();
	public CerebrovascularDisease Cerebrovascular = new CerebrovascularDisease();
	public PreviousPCI PreviousPCI = new PreviousPCI();
	public SmokingStatus Smoking = new SmokingStatus();
	public Diabetes Diabetes = new Diabetes();
	public PreviousAngina PreviousAngina = new PreviousAngina();
	public Hypercholesterolaemia HyperCholesterol = new Hypercholesterolaemia();
	public AsthmaOrCOPD AsthmaCOPD = new AsthmaOrCOPD();
	public PreviousCABG PreviousCABG = new PreviousCABG();
	public HeartFailure HeartFailure = new HeartFailure();
	public PeripheralVascularDisease PeripheralVascular = new PeripheralVascularDisease();
	public ChronicRenalFailure RenalFailure = new ChronicRenalFailure();
	public FamilyCHD FamilyCHD = new FamilyCHD();
}
