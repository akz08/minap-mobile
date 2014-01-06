package com.ucl.appteam7.minapmobile;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;
import android.database.Cursor;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DBAdapter db = new DBAdapter(this);
		
		// add a test patient info
//		db.open();
//		db.insertPatient("1x3", "Jimmy", "Jackson", new Date(), "1234567890", "AAA", "1/12/2013");
//		db.close();
		
		// update a patient's info
		db.open();
//		if (db.updatePatientInfo("1x3", "forename", "surename", new Date(), "nhsnumber", "hospital", "admindate"))
//		if (db.updateInitialDiagnosis("1x3", "diagnosis", "admission", "nstemi", "procedure", "refer", "code"))
//		if (db.updateDemographics("1x3", "gender", "ethnicity", "method", "ward", "gpcode", "post", "consultant", "status", "ecg", "verif"))
//		if (db.updateInitialReperfusion("1x3", "treatment", "reperfusion", "ecgtreat", "ecgqrs", "location", "iccode", "infarction"))
//		if (db.updateAngiography("1x3", "angio", "drefer", "adelay", "adate", "acode", "inter", "coronary", "patret", "daycase", "refret"))
//		if (db.updateExaminations("1x3", "systolic", "heart", "killip", "bmi", "height", "weight", "grace"))
		if (db.updateMedicalHistory("1x3", "ami", "tension", "cerebro", "pci", "smoke", "diabetes", "angina", "choles", "asthma", "cabg", "heart", "vascular", "renal", "chd"))
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
//		String id = "1x3";
//		db.open();
//		if (db.deletePatient(id))
//			Toast.makeText(this, "Delete successful", Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Delete failed", Toast.LENGTH_LONG).show();
//		db.close();
		

	}
	
	// Display test patient 
	public void DisplayPatient(Cursor c) {
		Toast.makeText(this, "Record No: " + c.getString(0) + 
							"\nForename: " + c.getString(1) + 
							"\nSurname: " +	c.getString(2) + 
							"\nDOB: " + c.getString(3) + 
							"\nNHS: " + c.getString(4) + 
							"\nHospital: " + c.getString(5) + 
							"\nAdmission: " + c.getString(6) + 
							"\nDiagnosis: " + c.getString(7) +
							"\nAdmission: " + c.getString(8) +
							"\nnStemi: " + c.getString(9) +
							"\nProcedure: " + c.getString(10) +
							"\nReferring: " + c.getString(11) +
							"\nIntervention: " + c.getString(12) +
							"\nGender: " + c.getString(13) +
							"\nEthnicity: " + c.getString(14) +
							"\nMethod: " + c.getString(15) +
							"\nWard: " + c.getString(16) +
							"\nGP Code: " + c.getString(17) +
							"\nPostcode: " + c.getString(18) +
							"\nConsultant: " + c.getString(19) +
							"\nStatus: " + c.getString(20) +
							"\nECG: " + c.getString(21) +
							"\nVerification: " + c.getString(22) +
							"\nTreatment: " + c.getString(23) +
							"\nReperfusion: " + c.getString(24) +
							"\nECG Treatment: " + c.getString(25) +
							"\nECG QRS: " + c.getString(26) +
							"\nLocation: " + c.getString(27) +
							"\nIntervention Code: " + c.getString(28) +
							"\nInfarction: " + c.getString(29) +
							"\nAngiography: " + c.getString(30) +
							"\nRefer Date: " + c.getString(31) +
							"\nAngio Delay: " + c.getString(32) +
							"\nAngio Date: " + c.getString(33) +
							"\nAngio Code: " + c.getString(34) +
							"\nAngio Intervention: " + c.getString(35) +
							"\nCoronary: " + c.getString(36) +
							"\nPatient Return: " + c.getString(37) +
							"\nDaycase Transfer: " + c.getString(38) +
							"\nRefer Return: " + c.getString(39) +
							"\nSystolic: " + c.getString(40) +
							"\nHeart Rate: " + c.getString(41) +
							"\nKillip: " + c.getString(42) +
							"\nBMI: " + c.getString(43) +
							"\nHeight: " + c.getString(44) +
							"\nWeight: " + c.getString(45) +
							"\nGrace Score: " + c.getString(46) +
							"\nPrev AMI: " + c.getString(47) +
							"\nHypertension: " + c.getString(48) +
							"\nCerebro: " + c.getString(49) +
							"\nPrev PCI: " + c.getString(50) +
							"\nSmoking: " + c.getString(51) +
							"\nDiabetes: " + c.getString(52) +
							"\nPrev Angina: " + c.getString(53) +
							"\nHypercholesterol:" + c.getString(54) +
							"\nAsthma: " + c.getString(55) +
							"\nCABG: " + c.getString(56) +
							"\nHeart Failure: " + c.getString(57) +
							"\nVascular: " + c.getString(58) +
							"\nRenal Failure: " + c.getString(59) +
							"\nCHD: " + c.getString(60)
							, Toast.LENGTH_LONG).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
