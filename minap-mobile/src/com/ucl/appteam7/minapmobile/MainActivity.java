package com.ucl.appteam7.minapmobile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;
import android.database.Cursor;

public class MainActivity extends Activity {

	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DBAdapter db = new DBAdapter(this);
		// Template for adding values to Patient singleton - Adds value to field, toasts invalid if validation not passed
		Patient patient = Patient.get();
		
		/** 
		 * create a new patient - THESE FIELDs CANNOT BE NULL ON SCHEMA: RecordNumber, Admission Date, Hospital ID, Initial Diagnosis 
		 *  Updating a field is not possible, it must be done on a page by page basis
		 *  If update methods are called when only one field has been changed, all other fields
		 *  on that page will be reset - Either filled with nulls or default values.
		 *  EACH CALL TO patient CALLS A NEW PATIENT OBJECT WHICH RESETS ALL FIELDS!
		 *  The Database remains untouched  though
		 *  This is why the Database still holds the original record's first page, but nulls on other pages as testing goes on.
		 *  Uncommenting all lines to Admission Date entry will enter a new patient record (magic parameters should be changed)
		 */
		
		// hospital id
		if (!patient.HospitalIdentifier.setHospitalIdentifier("AAA"))
			Toast.makeText(this, "Invalid Hospital ID", Toast.LENGTH_LONG).show();
		
		/** case number - DO NOT COMMENT OUT WHEN TESTING EDITING METHODS */
		// String oldid = patient.RecordNumber.getOldCase(); // Uncomment when updating Patient Info page
		if (!patient.RecordNumber.setCaseNumber("YYYTEST"))
			Toast.makeText(this, "Invalid CaseNum", Toast.LENGTH_LONG).show();
		
		// nhs number
		if (!patient.NHSNumber.setNHSNum("1234567890"))
			Toast.makeText(this, "Invalid CaseNum", Toast.LENGTH_LONG).show();		
		
		// surname
		if (!patient.Surname.setSurname("Hopkins"))
			Toast.makeText(this, "Invalid surname", Toast.LENGTH_LONG).show();
		
		// forename
		if (!patient.Forename.setForename("John"))
			Toast.makeText(this, "Invalid Forename", Toast.LENGTH_LONG).show();
		
		// How to add and format a date
		// DOB
		String DateStr="12/12/1988";
		Date d = new Date();
		try {
			d = new SimpleDateFormat("mm/dd/yyyy").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); } 
		
		try {
			if (!patient.DOB.setDOB(d))
				Toast.makeText(this, "Invalid dob", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }

		// Admin Date
		DateStr = "14/1/2014";
		try {
			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); } 
		
		try {
			if (!patient.AdmissionDate.setADate(d))
				Toast.makeText(this, "Invalid admin date", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// Admin Time
		DateStr = "5:33 PM";
		try {
			d = new SimpleDateFormat("hh:mm a").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); }
		
		try {
			if (!patient.AdmissionDate.setATime(d))
				Toast.makeText(this, "Invalid admin time", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// Set date time
		if (!patient.AdmissionDate.setDateTime()) 
			Toast.makeText(this, "invalid time", Toast.LENGTH_LONG).show();
		
		db.open();
		if (db.insertPatient(patient.RecordNumber.getCaseNumber(), patient.Forename.getForename(), patient.Surname.getSurname(), 
				patient.DOB.getDOB(), patient.NHSNumber.getNHSNum(), patient.HospitalIdentifier.getHospitalIdentifier(), patient.AdmissionDate.getDateTime()))
			Toast.makeText(this, "Insert successful", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Insert unsuccessful", Toast.LENGTH_LONG).show();
		
		/**
		 * Patient info creation ends here
		 * Initial Diagnosis starts here
		 */
		
		// initial diagnosis
		if (!patient.InitialDiagnosis.setInitialDiagnosis((byte)1))
			Toast.makeText(this, "Invalid Initial Diagnosis", Toast.LENGTH_LONG).show();

		// admission after nSTEMI
		patient.AdmissionAfterNSTEMI.setAdmissionAfterSTEMI(true);

		// high risk nSTEMI
		if (!patient.HighRisknSTEMI.setHiRisknSTEMI((byte)1))
			Toast.makeText(this, "Invalid Hi Risk nSTEMI", Toast.LENGTH_LONG).show();
		
		// high risk nSTEMI
		if (!patient.InterventionalProcedure.setInterventionalProcedure((byte)1))
			Toast.makeText(this, "Invalid Interventional Procedure", Toast.LENGTH_LONG).show();
		
		// Refer Hospital Return
		DateStr = "1/5/2014";
		try {
			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace();	} 
		
		try {
			if (!patient.ReferHospitalReturn.setRDate(d))
				Toast.makeText(this, "Invalid admin date", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// Interventional centre code
		if (!patient.InterventionalCentreCode.setInterventionalCentre("MMM"))
			Toast.makeText(this, "Invalid Interventional Procedure", Toast.LENGTH_LONG).show();
		
		db.open();
		if (db.updateInitialDiagnosis(patient.RecordNumber.getCaseNumber(), patient.InitialDiagnosis.getInitialDiagnosis(), 
				patient.AdmissionAfterNSTEMI.getAdmissionAfterSTEMI(), patient.HighRisknSTEMI.getHiRisknSTEMI(), 
				patient.InterventionalProcedure.getInterventionalProcedure(), patient.ReferHospitalReturn.getRDate(), 
				patient.InterventionalCentreCode.getInterventionalCentre()))
			Toast.makeText(this, "Diagnosis Update Successful", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Diagnosis Update failed", Toast.LENGTH_LONG).show();
		db.close();
		
		/**
		 * Demographics and Admission Starts here
		 */
		
		// gender
		if (!patient.Gender.setPatientGender((byte)1))
			Toast.makeText(this, "Invalid gender", Toast.LENGTH_LONG).show();
		
		// ethnicity
		if (!patient.Ethnicity.setEthnicity((byte)1))
			Toast.makeText(this, "Invalid ethnicity", Toast.LENGTH_LONG).show();
		
		// admission method
		if (!patient.AdmissionMethod.setAdmissionMethod((byte)1))
			Toast.makeText(this, "Invalid Interventional Procedure", Toast.LENGTH_LONG).show();
		
		// admission ward
		if (!patient.AdmissionWard.setAdmissionWard((byte)1))
			Toast.makeText(this, "Invalid ward", Toast.LENGTH_LONG).show();
		
		// gp pct code
		if (!patient.GPCode.setGPCode("123456"))
			Toast.makeText(this, "Invalid GP code", Toast.LENGTH_LONG).show();
		
		// post code
		if (!patient.PostCode.setPostcode("wc1x 9en"))
			Toast.makeText(this, "Invalid post code", Toast.LENGTH_LONG).show();
		
		// admitting consultant
		if (!patient.AdmitConsul.setAdmittingConsultant((byte)1))
			Toast.makeText(this, "Invalid admitting consultant", Toast.LENGTH_LONG).show();
		
		// admission status
		if (!patient.AdminStatus.setAdminStatus((byte)1))
			Toast.makeText(this, "Invalid Admission status", Toast.LENGTH_LONG).show();
		
		// First ECG
		if (!patient.FirstECG.setFirstECG((byte)1))
			Toast.makeText(this, "Invalid First ecg", Toast.LENGTH_LONG).show();
		
		// nhs verification
		if (!patient.NHSVerification.setVerification((byte)1))
			Toast.makeText(this, "Invalid verification", Toast.LENGTH_LONG).show();
		
		db.open();
		if (db.updateDemographics(patient.RecordNumber.getCaseNumber(), patient.Gender.getPatientGender(), 
				patient.Ethnicity.getEthnicity(), patient.AdmissionMethod.getAdmissionMethod(), 
				patient.AdmissionWard.getAdmissionWard(), patient.GPCode.getGPCode(), patient.PostCode.getPostcode(), 
				patient.AdmitConsul.getAdmittingConsultant(), patient.AdminStatus.getAdminStatus(), patient.FirstECG.getFirstECG(), 
				patient.NHSVerification.getVerification()))
			Toast.makeText(this, "Demographics Update successful", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Demographics Update failed", Toast.LENGTH_LONG).show();

		/**
		 * Initial reperfusion starts here
		 */
		
		// initial reperfusion treatment
		if (!patient.InitialReperfusion.setInitialReperfusion((byte)1))
			Toast.makeText(this, "invalid reperfusion treatment", Toast.LENGTH_LONG).show();
		
		// reperfusion not given
		if (!patient.ReperfusionNotGiven.setReperfusionNotGiven((byte)1))
			Toast.makeText(this, "invalid reperfusion not given", Toast.LENGTH_LONG).show();
		
		// ECG determining treatment
		if (!patient.ECGTreatment.setECGTreatment((byte)1))
			Toast.makeText(this, "invalid ecg treatment", Toast.LENGTH_LONG).show();
		
		// ECG QRS complex
		if (!patient.ECG_QRSComplex.setECGQRSComplex((byte)1))
			Toast.makeText(this, "invalid ecg qrs complex", Toast.LENGTH_LONG).show();
		
		// location at STEMI
		if (!patient.LocationSTEMI.setSTEMILocation((byte)1))
			Toast.makeText(this, "invalid STEMI location", Toast.LENGTH_LONG).show();
		
		// reperfusion intervention centre
		if (!patient.ReperfusionCentreCode.setInterventionalCentre("VVV"))
			Toast.makeText(this, "invalid reperfusion centre code", Toast.LENGTH_LONG).show();
		
		// infarction site
		if (!patient.InfarctionSite.setInfarctionSite((byte)1))
			Toast.makeText(this, "invalid infarction site", Toast.LENGTH_LONG).show();
		
		db.open();
		if (db.updateInitialReperfusion(patient.RecordNumber.getCaseNumber(), patient.InitialReperfusion.getInitialReperfusion(), 
				patient.ReperfusionNotGiven.getReperfusionNotGiven(), patient.ECGTreatment.getECGTreatment(), 
				patient.ECG_QRSComplex.getECGQRSComplex(), patient.LocationSTEMI.getSTEMILocation(), 
				patient.ReperfusionCentreCode.getInterventionalCentre(), patient.InfarctionSite.getInfarctionSite()))
			Toast.makeText(this, "Reperfusion Update Successful", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Reperfusion Update Failed", Toast.LENGTH_LONG).show();
		db.close();
		
		/**
		 * Angiography starts here
		 */
		
		// coronary angio
		if (!patient.CoronaryAngiography.setCoronaryAngiography((byte)1))
			Toast.makeText(this, "invalid coronary angio", Toast.LENGTH_LONG).show();
		
		// referral date
		DateStr = "14/1/2014";
		try {
			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); } 
		
		try {
			if (!patient.ReferralDate.setReferralDate(d))
				Toast.makeText(this, "Invalid referral date", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// referral Time
		DateStr = "5:33 PM";
		try {
			d = new SimpleDateFormat("hh:mm a").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); }
		
		// set referral date time
		try {
			if (!patient.ReferralDate.setReferralTime(d))
				Toast.makeText(this, "Invalid referral time", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// referral date time
		if (!patient.ReferralDate.setDateTime()) 
			Toast.makeText(this, "invalid referral time", Toast.LENGTH_LONG).show();
		
		// angio delay
		if (!patient.AngioDelay.setAngioDelay((byte)1))
			Toast.makeText(this, "invalid angio delay", Toast.LENGTH_LONG).show();
		
		// angio date
		DateStr = "14/1/2014";
		try {
			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); } 
		
		try {
			if (!patient.AngioDate.setAngioDate(d))
				Toast.makeText(this, "Invalid referral date", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// angio Time
		DateStr = "5:33 PM";
		try {
			d = new SimpleDateFormat("hh:mm a").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); }
		
		try {
			if (!patient.AngioDate.setAngioTime(d))
				Toast.makeText(this, "Invalid referral time", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// referral date time
		if (!patient.AngioDate.setDateTime()) 
			Toast.makeText(this, "invalid referral time", Toast.LENGTH_LONG).show();
		
		// angio interventional centre
		if (!patient.AngioCentreCode.setInterventionalCentre("HHH"))
			Toast.makeText(this, "invalid angio intervention centre", Toast.LENGTH_LONG).show();
		
		// local intervention date
		DateStr = "14/1/2014";
		try {
			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); } 
		
		try {
			if (!patient.InterventionDate.setInterventionDate(d))
				Toast.makeText(this, "Invalid local intervention date", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// coronary intervention
		if (!patient.CoronaryIntervention.setCoronaryIntervention((byte)1))
			Toast.makeText(this, "invalid coronary intervention", Toast.LENGTH_LONG).show();
		
		// return expected 
		patient.ReturnExpected.setReturnExpected(true);
		
		// daycase transfer
		DateStr = "14/1/2014";
		try {
			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); } 
		
		try {
			if (!patient.DaycaseTransfer.setDaycaseDate(d))
				Toast.makeText(this, "Invalid local intervention date", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		// referring hospital return
		DateStr = "14/1/2014";
		try {
			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
		} catch (ParseException e1) { e1.printStackTrace(); } 
		
		try {
			if (!patient.ReferReturnDate.setReturnDate(d))
				Toast.makeText(this, "Invalid local intervention date", Toast.LENGTH_LONG).show();
		} catch (ParseException e) { e.printStackTrace(); }
		
		db.open();
		if (db.updateAngiography(patient.RecordNumber.getCaseNumber(), patient.CoronaryAngiography.getCoronaryAngiography(), 
				patient.ReferralDate.getDateTime(), patient.AngioDelay.getAngioDelay(), patient.AngioDate.getDateTime(), 
				patient.AngioCentreCode.getInterventionalCentre(), patient.InterventionDate.getInterventionDate(), 
				patient.CoronaryIntervention.getCoronaryIntervention(), patient.ReturnExpected.getReturnExpected(), 
				patient.DaycaseTransfer.getDaycaseDate(), patient.ReferReturnDate.getReturnDate()))
			Toast.makeText(this, "Angio Update Successful", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Angio Update Failed", Toast.LENGTH_LONG).show();
		db.close();
		
		/**
		 * Examinations start here
		 */
		
		// Systolic BP
		if (!patient.Systolic.setSystolicBP(123))
			Toast.makeText(this, "Invalid systolic", Toast.LENGTH_LONG).show();
		
		// Heart Rate
		if (!patient.HeartRate.setHeartRate(123))
			Toast.makeText(this, "Invalid heart rate", Toast.LENGTH_LONG).show();
		
		// Killip Class
		if (!patient.Killip.setKillipClass((byte)1))
			Toast.makeText(this, "invalid killip", Toast.LENGTH_LONG).show();
		
		// Height
		if (!patient.Height.setHeight(183))
			Toast.makeText(this, "Invalid systolic", Toast.LENGTH_LONG).show();
		
		// Weight
		if (!patient.Weight.setWeight(83))
			Toast.makeText(this, "Invalid heart rate", Toast.LENGTH_LONG).show();
		
		// BMI
		if (!patient.BMI.setBMI(Double.valueOf(patient.Height.getHeight()), Double.valueOf(patient.Weight.getWeight())))
			Toast.makeText(this, "invalid bmi", Toast.LENGTH_LONG).show();
		
		// Previous AMI Class
		if (!patient.PreviousAMI.setPreviousAMI((byte)1))
			Toast.makeText(this, "invalid prevAMI", Toast.LENGTH_LONG).show();
		
		// Hypertension
		if (!patient.Hypertension.setHyperTension((byte)1))
			Toast.makeText(this, "invalid hypertension", Toast.LENGTH_LONG).show();
		
		// Cerebrovascular disease
		if (!patient.Cerebrovascular.setCerebrovascular((byte)1))
			Toast.makeText(this, "invalid cerebrovascular", Toast.LENGTH_LONG).show();
		
		// Previous PCI
		if (!patient.PreviousPCI.setPreviousPCI((byte)1))
			Toast.makeText(this, "invalid prevPCI", Toast.LENGTH_LONG).show();
		
		// Smoking status
		if (!patient.Smoking.setSmokingStatus((byte)1))
			Toast.makeText(this, "invalid smoking", Toast.LENGTH_LONG).show();

		// dibetes
		if (!patient.Diabetes.setDiabetes((byte)1))
			Toast.makeText(this, "invalid diabetes", Toast.LENGTH_LONG).show();
		
		// previous angina
		if (!patient.PreviousAngina.setPreviousAngina((byte)1))
			Toast.makeText(this, "invalid angina", Toast.LENGTH_LONG).show();
		
		// hypercholes
		if (!patient.HyperCholesterol.setHyperCholesterol((byte)1))
			Toast.makeText(this, "invalid choles", Toast.LENGTH_LONG).show();

		// asthma
		if (!patient.AshtmaCOPD.setAsthmaCOPD((byte)1))
			Toast.makeText(this, "invalid asthma", Toast.LENGTH_LONG).show();
		
		// cabg
		if (!patient.PreviousCABG.setPreviousCABG((byte)1))
			Toast.makeText(this, "invalid asthma", Toast.LENGTH_LONG).show();
		
		// heart failure
		if (!patient.HeartFailure.setHeartFailure((byte)1))
			Toast.makeText(this, "invalid heartfailure", Toast.LENGTH_LONG).show();
		
		// peripheral vascular
		if (!patient.PeripheralVascular.setPeripheralVascularDisease((byte)1))
			Toast.makeText(this, "invalid peripheral", Toast.LENGTH_LONG).show();
		
		// renal failure
		if (!patient.RenalFailure.setRenalFailure((byte)1))
			Toast.makeText(this, "invalid renal", Toast.LENGTH_LONG).show();
		
		// chd
		if (!patient.FamilyCHD.setFamilyCHD((byte)1))
			Toast.makeText(this, "invalid renal", Toast.LENGTH_LONG).show();

		db.open();
		if (db.updateExaminations(patient.RecordNumber.getCaseNumber(), patient.Systolic.getSystolicBP(), 
				patient.HeartRate.getHeartRate(), patient.Killip.getKillipClass(), patient.BMI.getBMI(), 
				patient.Height.getHeight(), patient.Weight.getWeight()))
			Toast.makeText(this, "Examinations update successful", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Examinations update failed", Toast.LENGTH_LONG).show();
		db.close();
		
		/**
		 * Medical History starts here
		 */
		
		// previous ami
		if (!patient.PreviousAMI.setPreviousAMI((byte)1))
			Toast.makeText(this, "invalid prevAMI", Toast.LENGTH_LONG).show();
		
		// hypertension
		if (!patient.Hypertension.setHyperTension((byte)1))
			Toast.makeText(this, "invalid hypertension", Toast.LENGTH_LONG).show();
		
		// cerebrovascular disease
		if (!patient.Cerebrovascular.setCerebrovascular((byte)1))
			Toast.makeText(this, "invalid cerebrovascular", Toast.LENGTH_LONG).show();
		
		// previous pci
		if (!patient.PreviousPCI.setPreviousPCI((byte)1))
			Toast.makeText(this, "invalid previous pci", Toast.LENGTH_LONG).show();
		
		// smoking
		if (!patient.Smoking.setSmokingStatus((byte)1))
			Toast.makeText(this, "invalid smoking", Toast.LENGTH_LONG).show();
		
		// diabetes
		if (!patient.Diabetes.setDiabetes((byte)1))
			Toast.makeText(this, "invalid diabetes", Toast.LENGTH_LONG).show();
		
		// previous angina
		if (!patient.PreviousAngina.setPreviousAngina((byte)1))
			Toast.makeText(this, "invalid previous angina", Toast.LENGTH_LONG).show();
		
		// hypercholesterolaemia
		if (!patient.HyperCholesterol.setHyperCholesterol((byte)1))
			Toast.makeText(this, "invalid hypercholesterol", Toast.LENGTH_LONG).show();
		
		// asthma copd
		if (!patient.AshtmaCOPD.setAsthmaCOPD((byte)1))
			Toast.makeText(this, "invalid asthma", Toast.LENGTH_LONG).show();
		
		// previous cabg
		if (!patient.PreviousCABG.setPreviousCABG((byte)1))
			Toast.makeText(this, "invalid previous cabg", Toast.LENGTH_LONG).show();
		
		// previous heart failure
		if (!patient.HeartFailure.setHeartFailure((byte)1))
			Toast.makeText(this, "invalid heart failure", Toast.LENGTH_LONG).show();
		
		// previous peripherovascular
		if (!patient.PeripheralVascular.setPeripheralVascularDisease((byte)1))
			Toast.makeText(this, "invalid peripheral disease", Toast.LENGTH_LONG).show();
		
		// renal failure
		if (!patient.RenalFailure.setRenalFailure((byte)1))
			Toast.makeText(this, "invalid renal failure", Toast.LENGTH_LONG).show();
		
		// family chd
		if (!patient.FamilyCHD.setFamilyCHD((byte)1))
			Toast.makeText(this, "invalid family chd", Toast.LENGTH_LONG).show();
		
		db.open();
		if (db.updateMedicalHistory(patient.RecordNumber.getCaseNumber(), patient.PreviousAMI.getPreviousAMI(), 
				patient.Hypertension.getHyperTension(), patient.Cerebrovascular.getCerebrovascular(), 
				patient.PreviousPCI.getPreviousPCI(), patient.Smoking.getSmokingStatus(), patient.Diabetes.getDiabetes(), 
				patient.PreviousAngina.getPreviousAngina(), patient.HyperCholesterol.getHyperCholesterol(), patient.AshtmaCOPD.getAsthmaCOPD(), 
				patient.PreviousCABG.getPreviousCABG(), patient.HeartFailure.getHeartFailure(), patient.PeripheralVascular.getPeripheralVascularDisease(), 
				patient.RenalFailure.getRenalFailure(), patient.FamilyCHD.getFamilyCHD()))
			Toast.makeText(this, "Medical History Update Successful", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Medical History Update failed", Toast.LENGTH_LONG).show();
		db.close();
		
		// get all patients
		db.open();
		Cursor c = db.allPatients();
		if (c.moveToFirst())
		{
			do {
				DisplayPatient(c);
			} while (c.moveToNext());
		}
		db.close();
		
		// delete a patient by ID or last name
//		String id = "YYYTEST";
//		db.open();
//		if (db.deletePatient(id))
//			Toast.makeText(this, "Delete successful", Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Delete failed", Toast.LENGTH_LONG).show();
//		db.close();
		

	}
	
	// Display test patient - each toast represents a page
	public void DisplayPatient(Cursor c) {
		Toast.makeText(this, "Record No: " + c.getString(1) + 
							"\nForename: " + c.getString(4) + 
							"\nSurname: " +	c.getString(3) + 
							"\nDOB: " + c.getString(5) + 
							"\nNHS: " + c.getString(2) + 
							"\nHospital: " + c.getString(0) + 
							"\nAdmission: " + c.getString(6), Toast.LENGTH_LONG).show(); 
		
		Toast.makeText(this, "\nDiagnosis: " + c.getString(7) +
							"\nAdmission: " + c.getString(8) +
							"\nnStemi: " + c.getString(9) +
							"\nProcedure: " + c.getString(10) +
							"\nReferring: " + c.getString(11) +
							"\nIntervention: " + c.getString(12), Toast.LENGTH_LONG).show();
		
		Toast.makeText(this, "\nGender: " + c.getString(13) +
							"\nEthnicity: " + c.getString(14) +
							"\nMethod: " + c.getString(15) +
							"\nWard: " + c.getString(16) +
							"\nGP Code: " + c.getString(17) +
							"\nPostcode: " + c.getString(18) +
							"\nConsultant: " + c.getString(19) +
							"\nStatus: " + c.getString(20) +
							"\nECG: " + c.getString(21) +
							"\nVerification: " + c.getString(22), Toast.LENGTH_LONG).show();
		
		Toast.makeText(this, "\nTreatment: " + c.getString(23) +
							"\nReperfusion: " + c.getString(24) +
							"\nECG Treatment: " + c.getString(25) +
							"\nECG QRS: " + c.getString(26) +
							"\nLocation: " + c.getString(27) +
							"\nIntervention Code: " + c.getString(28) +
							"\nInfarction: " + c.getString(29), Toast.LENGTH_LONG).show();
		
		Toast.makeText(this, "\nAngiography: " + c.getString(30) +
							"\nRefer Date: " + c.getString(31) +
							"\nAngio Delay: " + c.getString(32) +
							"\nAngio Date: " + c.getString(33) +
							"\nAngio Code: " + c.getString(34) +
							"\nAngio Intervention: " + c.getString(35) +
							"\nCoronary: " + c.getString(36) +
							"\nPatient Return: " + c.getString(37) +
							"\nDaycase Transfer: " + c.getString(38) +
							"\nRefer Return: " + c.getString(39), Toast.LENGTH_LONG).show();
		
		Toast.makeText(this, "\nSystolic: " + c.getString(40) +
							"\nHeart Rate: " + c.getString(41) +
							"\nKillip: " + c.getString(42) +
							"\nBMI: " + c.getString(43) +
							"\nHeight: " + c.getString(44) +
							"\nWeight: " + c.getString(45), Toast.LENGTH_LONG).show();
							
		Toast.makeText(this, "\nPrev AMI: " + c.getString(46) +
							"\nHypertension: " + c.getString(47) +
							"\nCerebro: " + c.getString(48) +
							"\nPrev PCI: " + c.getString(49) +
							"\nSmoking: " + c.getString(50) +
							"\nDiabetes: " + c.getString(51) +
							"\nPrev Angina: " + c.getString(52) +
							"\nHypercholesterol:" + c.getString(53) +
							"\nAsthma: " + c.getString(54) +
							"\nCABG: " + c.getString(55) +
							"\nHeart Failure: " + c.getString(56) +
							"\nVascular: " + c.getString(57) +
							"\nRenal Failure: " + c.getString(58) +
							"\nCHD: " + c.getString(59), Toast.LENGTH_LONG).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
