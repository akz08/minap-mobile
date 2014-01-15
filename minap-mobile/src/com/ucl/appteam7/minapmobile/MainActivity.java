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
		// Template for adding values to Patient singleton - Adds value to field, toasts invalid length if validation not passed
		Patient patient = Patient.get();
		
		/** create a new patient - THESE FIELDs CANNOT BE NULL ON SCHEMA
		 *  Updating a field is not possible, it must be done on a page by page basis
		 *  If update methods are called when only one field has been changed, all other fields
		 *  on that page will be reset - Either filled with nulls or default values.
		 *  EACH CALL TO patient CALLS A NEW PATIENT OBJECT WHICH RESETS ALL FIELDS!
		 *  The Database remains untouched  though
		 *  This is why the Database still holds the original record's first page, but nulls on other pages as testing goes on.
		 *  Uncommenting all lines to Admission Date entry will enter a new patient record (magic parameters should be changed)
		 */
		// hospital id
//		if (patient.HospitalIdentifier.setHospitalIdentifier("AAA"))
//			Toast.makeText(this, patient.HospitalIdentifier.getHospitalIdentifier(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid Hospital ID", Toast.LENGTH_LONG).show();
		
		/** case number - DO NOT COMMENT OUT WHEN TESTING EDITING METHODS */
//		String oldid = patient.RecordNumber.getOldCase(); // Uncomment when updating Patient Info page
		if (patient.RecordNumber.setCaseNumber("YYYTEST"))
			Toast.makeText(this, patient.RecordNumber.getCaseNumber(), Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Invalid CaseNum", Toast.LENGTH_LONG).show();
		
		// nhs number
//		if (patient.NHSNumber.setNHSNum("1234567890"))
//			Toast.makeText(this, patient.NHSNumber.getNHSNum(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid CaseNum", Toast.LENGTH_LONG).show();		
//		
//		// surname
//		if (patient.Surname.setSurname("Hopkins"))
//			Toast.makeText(this, patient.Surname.getSurname(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid surname", Toast.LENGTH_LONG).show();
//		
//		// forename
//		if (patient.Forename.setForename("John"))
//			Toast.makeText(this, patient.Forename.getForename(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid Forename", Toast.LENGTH_LONG).show();
//		
//		// How to add and format a date
//		// DOB
//		String DateStr="12/12/1988";
//		Date d = new Date();
//		try {
//			d = new SimpleDateFormat("mm/dd/yyyy").parse(DateStr);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
//		
//		try {
//			if (patient.DOB.setDOB(d))
//				Toast.makeText(this, patient.DOB.getDOB(), Toast.LENGTH_LONG).show();
//			else
//				Toast.makeText(this, "Invalid dob", Toast.LENGTH_LONG).show();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////
////		// Admin Date
//		DateStr = "1/5/2014";
//		try {
//			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
//		try {
//			if (patient.AdmissionDate.setADate(d))
//				Toast.makeText(this, patient.AdmissionDate.getADate(), Toast.LENGTH_LONG).show();
//			else
//				Toast.makeText(this, "Invalid admin date", Toast.LENGTH_LONG).show();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// initial diagnosis
//		if (patient.InitialDiagnosis.setInitialDiagnosis((byte)1))
//			Toast.makeText(this, patient.InitialDiagnosis.getInitialDiagnosis(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid Initial Diagnosis", Toast.LENGTH_LONG).show();
//
//		// admission after nSTEMI
//		patient.AdmissionAfterNSTEMI.setAdmissionAfterSTEMI(true);
//
//		// high risk nSTEMI
//		if (patient.HighRisknSTEMI.setHiRisknSTEMI((byte)1))
//			Toast.makeText(this, patient.HighRisknSTEMI.getHiRisknSTEMI(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid Hi Risk nSTEMI", Toast.LENGTH_LONG).show();
//		
//		// high risk nSTEMI
//		if (patient.InterventionalProcedure.setInterventionalProcedure((byte)1))
//			Toast.makeText(this, patient.InterventionalProcedure.getInterventionalProcedure(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid Interventional Procedure", Toast.LENGTH_LONG).show();
//		
//		// Refer Hospital Return
//		DateStr = "1/5/2014";
//		try {
//			d = new SimpleDateFormat("dd/mm/yyyy").parse(DateStr);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
//		try {
//			if (patient.ReferHospitalReturn.setRDate(d))
//				Toast.makeText(this, patient.ReferHospitalReturn.getRDate(), Toast.LENGTH_LONG).show();
//			else
//				Toast.makeText(this, "Invalid admin date", Toast.LENGTH_LONG).show();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// Interventional centre code
//		if (patient.InterventionalCentreCode.setInterventionalCentre("MMM"))
//			Toast.makeText(this, patient.InterventionalCentreCode.getInterventionalCentre(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid Interventional Procedure", Toast.LENGTH_LONG).show();
//
//		// Systolic BP
//		if (patient.Systolic.setSystolicBP(123))
//			Toast.makeText(this, patient.Systolic.getSystolicBP(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid systolic", Toast.LENGTH_LONG).show();
//		
//		// Heart Rate
//		if (patient.HeartRate.setHeartRate(123))
//			Toast.makeText(this, patient.HeartRate.getHeartRate(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid heart rate", Toast.LENGTH_LONG).show();
//		
//		// Killip Class
//		if (patient.Killip.setKillipClass((byte)1))
//			Toast.makeText(this, patient.Killip.getKillipClass(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "invalid killip", Toast.LENGTH_LONG).show();
//		
//		// Height
//		if (patient.Height.setHeight(183))
//			Toast.makeText(this, patient.Height.getHeight(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid systolic", Toast.LENGTH_LONG).show();
//		
//		// Weight
//		if (patient.Weight.setWeight(83))
//			Toast.makeText(this, patient.Weight.getWeight(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Invalid heart rate", Toast.LENGTH_LONG).show();
//		
//		// BMI
//		if (patient.BMI.setBMI(Double.valueOf(patient.Height.getHeight()), Double.valueOf(patient.Weight.getWeight())))
//			Toast.makeText(this, patient.BMI.getBMI(), Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "invalid bmi", Toast.LENGTH_LONG).show();
		
		// add a test patient info, update with first page
//		db.open();
//		db.insertPatient(patient.RecordNumber.getCaseNumber(), patient.Forename.getForename(), patient.Surname.getSurname(), patient.DOB.getDOB(), patient.NHSNumber.getNHSNum(), patient.HospitalIdentifier.getHospitalIdentifier(), patient.AdmissionDate.getADate());
//		if (db.updateInitialDiagnosis(patient.RecordNumber.getCaseNumber(), patient.InitialDiagnosis.getInitialDiagnosis(), patient.AdmissionAfterNSTEMI.getAdmissionAfterSTEMI(), patient.HighRisknSTEMI.getHiRisknSTEMI(), patient.InterventionalProcedure.getInterventionalProcedure(), patient.ReferHospitalReturn.getRDate(), patient.InterventionalCentreCode.getInterventionalCentre()))
//			Toast.makeText(this, "Update Successful", Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Update failed", Toast.LENGTH_LONG).show();
//		db.close();
		
		// update a patient's info - Uncomment an update line and the bottom four lines
		db.open();
//		if (db.updatePatientInfo(patient.RecordNumber.getOldCase(), patient.RecordNumber.getCaseNumber(), patient.Forename.getForename(), patient.Surname.getSurname(), patient.DOB.getDOB(), patient.NHSNumber.getNHSNum(), patient.HospitalIdentifier.getHospitalIdentifier(), patient.AdmissionDate.getADate()))
//		if (db.updateInitialDiagnosis(patient.RecordNumber.getCaseNumber(), patient.InitialDiagnosis.getInitialDiagnosis(), patient.AdmissionAfterNSTEMI.getAdmissionAfterSTEMI(), patient.HighRisknSTEMI.getHiRisknSTEMI(), patient.InterventionalProcedure.getInterventionalProcedure(), patient.ReferHospitalReturn.getRDate(), patient.InterventionalCentreCode.getInterventionalCentre()))
//		if (db.updateDemographics(patient.RecordNumber.getCaseNumber(), patient.Gender.getPatientGender(), patient.Ethnicity.getEthnicity(), patient.AdmissionMethod.getAdmissionMethod(), patient.AdmissionWard.getAdmissionWard(), patient.GPCode.getGPCode(), patient.PostCode.getPostcode(), patient.AdmitConsul.getAdmittingConsultant(), patient.AdminStatus.getAdminStatus(), patient.FirstECG.getFirstECG(), patient.NHSVerification.getVerification()))
//		if (db.updateInitialReperfusion(patient.RecordNumber.getCaseNumber(), patient.InitialReperfusion.getInitialReperfusion(), patient.ReperfusionNotGiven.getReperfusionNotGiven(), patient.ECGTreatment.getECGTreatment(), patient.ECG_QRSComplex.getECGQRSComplex(), patient.LocationSTEMI.getSTEMILocation(), patient.ReperfusionCentreCode.getInterventionalCentre(), patient.InfarctionSite.getInfarctionSite()))
//		if (db.updateAngiography(patient.RecordNumber.getCaseNumber(), patient.CoronaryAngiography.getCoronaryAngiography(), patient.ReferralDate.getReferralDate(), patient.AngioDelay.getAngioDelay(), patient.AngioDate.getAngioDate(), patient.AngioCentreCode.getInterventionalCentre(), patient.InterventionDate.getInterventionDate(), patient.CoronaryIntervention.getCoronaryIntervention(), patient.ReturnExpected.getReturnExpected(), patient.DaycaseTransfer.getDaycaseDate(), patient.ReferReturnDate.getReturnDate()))
//		if (db.updateExaminations(patient.RecordNumber.getCaseNumber(), patient.Systolic.getSystolicBP(), patient.HeartRate.getHeartRate(), patient.Killip.getKillipClass(), patient.BMI.getBMI(), patient.Height.getHeight(), patient.Weight.getWeight(), "grace"))
		if (db.updateMedicalHistory(patient.RecordNumber.getCaseNumber(), "ami", "tension", "cerebro", "pci", "smoke", "diabetes", "angina", "choles", "asthma", "cabg", "heart", "vascular", "renal", "chd"))
			Toast.makeText(this, "Update Successful", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Update failed", Toast.LENGTH_LONG).show();
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
		
		// get a patient by ID
//		String id = "1x3";
//		db.open();
//		Cursor c = db.getDiagnosis(id);
//		if (c.moveToFirst())
//		{
//			DisplayPatient(c);
//		}
//		else 
//			Toast.makeText(this, "No Contact Found", Toast.LENGTH_LONG).show();
//		db.close();
		
		// delete a patient by ID or last name
//		String id = "YYYTEST";
//		db.open();
//		if (db.deletePatient(id))
//			Toast.makeText(this, "Delete successful", Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Delete failed", Toast.LENGTH_LONG).show();
//		db.close();
		

	}
	
	// Display test patient 
	public void DisplayPatient(Cursor c) {
		Toast.makeText(this, "Record No: " + c.getString(1) + 
							"\nForename: " + c.getString(4) + 
							"\nSurname: " +	c.getString(3) + 
							"\nDOB: " + c.getString(5) + 
							"\nNHS: " + c.getString(2) + 
							"\nHospital: " + c.getString(0) + 
							"\nAdmission: " + c.getString(6), Toast.LENGTH_LONG).show(); 
		
//		Toast.makeText(this, "\nDiagnosis: " + c.getString(7) +
//							"\nAdmission: " + c.getString(8) +
//							"\nnStemi: " + c.getString(9) +
//							"\nProcedure: " + c.getString(10) +
//							"\nReferring: " + c.getString(11) +
//							"\nIntervention: " + c.getString(12), Toast.LENGTH_LONG).show();
//		
//		Toast.makeText(this, "\nGender: " + c.getString(13) +
//							"\nEthnicity: " + c.getString(14) +
//							"\nMethod: " + c.getString(15) +
//							"\nWard: " + c.getString(16) +
//							"\nGP Code: " + c.getString(17) +
//							"\nPostcode: " + c.getString(18) +
//							"\nConsultant: " + c.getString(19) +
//							"\nStatus: " + c.getString(20) +
//							"\nECG: " + c.getString(21) +
//							"\nVerification: " + c.getString(22), Toast.LENGTH_LONG).show();
//		
//		Toast.makeText(this, "\nTreatment: " + c.getString(23) +
//							"\nReperfusion: " + c.getString(24) +
//							"\nECG Treatment: " + c.getString(25) +
//							"\nECG QRS: " + c.getString(26) +
//							"\nLocation: " + c.getString(27) +
//							"\nIntervention Code: " + c.getString(28) +
//							"\nInfarction: " + c.getString(29), Toast.LENGTH_LONG).show();
//		
//		Toast.makeText(this, "\nAngiography: " + c.getString(30) +
//							"\nRefer Date: " + c.getString(31) +
//							"\nAngio Delay: " + c.getString(32) +
//							"\nAngio Date: " + c.getString(33) +
//							"\nAngio Code: " + c.getString(34) +
//							"\nAngio Intervention: " + c.getString(35) +
//							"\nCoronary: " + c.getString(36) +
//							"\nPatient Return: " + c.getString(37) +
//							"\nDaycase Transfer: " + c.getString(38) +
//							"\nRefer Return: " + c.getString(39), Toast.LENGTH_LONG).show();
//		
		Toast.makeText(this, "\nSystolic: " + c.getString(40) +
							"\nHeart Rate: " + c.getString(41) +
							"\nKillip: " + c.getString(42) +
							"\nBMI: " + c.getString(43) +
							"\nHeight: " + c.getString(44) +
							"\nWeight: " + c.getString(45) +
							"\nGrace Score: " + c.getString(46), Toast.LENGTH_LONG).show();
//		
//		Toast.makeText(this, "\nPrev AMI: " + c.getString(47) +
//							"\nHypertension: " + c.getString(48) +
//							"\nCerebro: " + c.getString(49) +
//							"\nPrev PCI: " + c.getString(50) +
//							"\nSmoking: " + c.getString(51) +
//							"\nDiabetes: " + c.getString(52) +
//							"\nPrev Angina: " + c.getString(53) +
//							"\nHypercholesterol:" + c.getString(54) +
//							"\nAsthma: " + c.getString(55) +
//							"\nCABG: " + c.getString(56) +
//							"\nHeart Failure: " + c.getString(57) +
//							"\nVascular: " + c.getString(58) +
//							"\nRenal Failure: " + c.getString(59) +
//							"\nCHD: " + c.getString(60), Toast.LENGTH_LONG).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
