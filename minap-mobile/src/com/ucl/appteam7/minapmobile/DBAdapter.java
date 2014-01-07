/**
 * DBAdapter class will handle all SQL related reading, writing and updating
 * @author david
 */
package com.ucl.appteam7.minapmobile;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBAdapter {
	// Database schema : variable name = table column; (return type on separate class) field number
	// Page 0 : Patient Info - 7 fields
	public static final String HOSPITAL_IDENTIFIER = "HospitalID"; 		// (String) Field 1.01
	public static final String RECORD_NO = "RecordNum"; 				// (short) Field 1.02
	public static final String NHS_NUMBER = "NHSNumber"; 				// (string) Field 1.03
	public static final String PATIENT_SURNAME = "PatientSurname";  	// (String) Field 1.04
	public static final String PATIENT_FORENAME = "PatientForename"; 	// (string) Field 1.05
	public static final String PATIENT_DOB = "PatientDOB"; 				// (Date) Field 1.06
	public static final String ADMISSION_DATE = "AdminDate"; 			// (Date) No field number
	public static final String [] PATIENT_INFO = {HOSPITAL_IDENTIFIER, RECORD_NO, NHS_NUMBER, PATIENT_SURNAME, PATIENT_FORENAME, PATIENT_DOB, ADMISSION_DATE};
	
	// Page 1 - Initial Diagnosis - 6 fields
	public static final String INITIAL_DIAGNOSIS = "InitialDiagosis"; 						// (byte) Field 2.01
	public static final String ADMISSION_AFTER_NSTEMI = "AdminStemi"; 						// (boolean) No field number
	public static final String HIGH_RISK_NSTEMI = "HiRisknSTEMI"; 							// (byte) Field 4.32
	public static final String INTERVENTIONAL_PROCEDURE = "InterventionalProcedure"; 		// (byte) Field 4.29
	public static final String RETURN_TO_REFERRING_HOSPITAL = "ReferHospitalReturn"; 		// (Date) Field 4.26
	public static final String INTERVENTIONAL_CENTRE_CODE_ID = "InterventionCentreCode";	/** (String) No Field number */
	public static final String [] DIAGNOSIS = {INITIAL_DIAGNOSIS, ADMISSION_AFTER_NSTEMI, HIGH_RISK_NSTEMI, INTERVENTIONAL_PROCEDURE, 
		RETURN_TO_REFERRING_HOSPITAL, INTERVENTIONAL_CENTRE_CODE_ID};
	
	// Page 2 - Demographics and admission - 10 fields
	public static final String PATIENT_GENDER = "Gender"; 						// (byte) Field 1.07
	public static final String PATIENT_ETHNICITY = "Ethnicity"; 				// (byte) Field 1.13
	public static final String ADMISSION_METHOD = "AdminMethod"; 				// (byte) Field 2.39
	public static final String ADMISSION_WARD = "AdminWard";					// (byte) Field 3.17
	public static final String GP_PCT_CODE = "GPCode"; 							// (string) Field 1.11
	public static final String PATIENT_POST_CODE = "PostCode"; 					// (string) Field 1.10
	public static final String ADMITTING_CONSULTANT = "AdminConsul"; 			// (byte) Field 2.22
	public static final String ADMISSION_STATUS = "AdminStatus"; 				// (byte) Field 1.09
	public static final String PLACE_FIRST_12_LEAD_ECG_PERFORMED = "FirstECG"; 	// (byte) : Field 2.22
	public static final String NHS_VERIFICATION = "NHSVerif";					/** (string) no field number */	
	public static final String [] ADMISSION = {PATIENT_GENDER, PATIENT_ETHNICITY, ADMISSION_METHOD, ADMISSION_WARD, GP_PCT_CODE,
		PATIENT_POST_CODE, ADMITTING_CONSULTANT, ADMISSION_STATUS, PLACE_FIRST_12_LEAD_ECG_PERFORMED, NHS_VERIFICATION};
	
	// Page 3 - Initial Reperfusion - 7 fields
	public static final String INITIAL_REPERFUSION_TREATMENT = "InitialReperfusionTreat"; 	// (byte) field 3.39
	public static final String REPERFUSION_NOT_GIVEN = "ReperNotGiven"; 					// (byte) Field 3.08
	public static final String ECG_DETERMINING_TREATMENT = "ECGDetermineTreat"; 			// (byte) Field 2.03
	public static final String ECG_QRS_COMPLEX_DURATION = "ECG_QRSComplex"; 				// (byte) Field 2.37
	public static final String STEMI_LOCATION = "LocationSTEMI"; 							// (byte) Field 2.40
	public static final String INTERVENTIONAL_CENTRE_CODE = "ReperInterventionCentre"; 		// (string) Field 4.20
	public static final String INFARCTION_SITE = "InfarctionSite"; 							// (byte) Field 2.36
	public static final String [] REPERFUSION = {INITIAL_REPERFUSION_TREATMENT, REPERFUSION_NOT_GIVEN, ECG_DETERMINING_TREATMENT, 
		ECG_QRS_COMPLEX_DURATION, STEMI_LOCATION, INTERVENTIONAL_CENTRE_CODE, INFARCTION_SITE};
	
	// Page 4 - Angiography - 10 fields
	public static final String CORONARY_ANGIO = "CoronaryAngio";							// (byte) Field 4.13
	public static final String REFERRAL_DATE = "ReferralDate";			 					// (Date) Field 4.15
	public static final String ANGIO_PERFORM_DELAY = "AngioDelay";							// (byte) Field 4.30
	public static final String ANGIO_DATE = "AngioDate";									// (Date) Field 4.18
	public static final String INTERVENTIONAL_CENTRE_CODE_AN = "AngioInterventionCentre";	/** (String) No Field number */
	public static final String LOCAL_INTERVENTION = "LocalIntervention";					// (Date) Field 4.19
	public static final String CORONARY_INTERVENTION = "CoronaryIntervention";				// (byte) Field 4.14
	public static final String PATIENT_RETURN = "ReturnExpected";							/** (boolean) no field number */
	public static final String DAYCASE_TRANSFER = "DaycaseTransfer";						// (Date) Field 4.17
	public static final String REFERRING_RETURN = "ReferringHospitalReturn";				// (Date) Field 4.26
	public static final String [] ANGIOGRAPHY = {CORONARY_ANGIO, REFERRAL_DATE, ANGIO_PERFORM_DELAY, ANGIO_DATE, 
		INTERVENTIONAL_CENTRE_CODE_AN, LOCAL_INTERVENTION, CORONARY_INTERVENTION, PATIENT_RETURN, DAYCASE_TRANSFER, REFERRING_RETURN};
	
	// Page 5 - Examinations - 7 fields
	public static final String SYSTOLIC = "SystolicBP";				// (short) Field 2.20
	public static final String HEART_RATE = "HeartRate";			// (short) Field 2.21
	public static final String KILLIP_CLASS = "KillipClass";		// (byte) Field 2.41
	public static final String BMI = "BMI";							// (double) No field number
	public static final String HEIGHT = "Height";					// (short) Field 2.29
	public static final String WEIGHT = "Weight"; 					// (short) Field 2.30
	public static final String GRACE_SCORE = "GraceScore";			/** Missing algorithm */
	public static final String [] EXAMINATIONS = {SYSTOLIC, HEART_RATE, KILLIP_CLASS, BMI, HEIGHT, WEIGHT, GRACE_SCORE};
	
	// Page 6 - Medical History - 14 fields
	public static final String PREVIOUS_AMI = "PrevAMI";				// (byte) Field 2.05
	public static final String HYPERTENSION = "Hypertension";			// (byte) Field 2.07
	public static final String CEREBROVASCULAR = "CerebroDisease";		// (byte) Field 2.10
	public static final String PREVIOUS_PCI = "PrevPCI";				// (byte) Field 2.18
	public static final String SMOKING = "Smoking";						// (byte) Field 2.16
	public static final String DIABETES = "Diabetes";					// (byte) Field 2.17
	public static final String PREVIOUS_ANGINA = "PrevAngina";			// (byte) Field 2.06
	public static final String HYPERCHOLESTEROL = "Hypercholesterol";	// (byte) Field 2.08
	public static final String ASTHMA_COPD = "AsthmaCOPD";				// (byte) Field 2.11
	public static final String PREVIOUS_CABG = "PrevCABG";				// (byte) Field 2.19 
	public static final String HEART_FAILURE = "HeartFailure";			// (byte) Field 2.13
	public static final String PV_DISEASE = "PeriphVascularDisease";	// (byte) Field 2.09
	public static final String RENAL_FAILURE = "RenalFailure";			// (byte) Field 2.12
	public static final String FAMILY_CHD = "FamilyCHD";				// (byte) Field 2.32
	public static final String [] MEDICAL_HISTORY = {PREVIOUS_AMI, HYPERTENSION, CEREBROVASCULAR, PREVIOUS_PCI, SMOKING, DIABETES, 
		PREVIOUS_ANGINA, HYPERCHOLESTEROL, ASTHMA_COPD, PREVIOUS_CABG, HEART_FAILURE, PV_DISEASE, RENAL_FAILURE, FAMILY_CHD};
	
	private String [] concatenateArrays(String [] page0, String [] page1, String [] page2, String [] page3, String [] page4, String [] page5, String [] page6) {
	    List<String> allCols = new ArrayList<String>(page0.length + page1.length + page2.length + page3.length + page4.length + page5.length + page6.length);
	    Collections.addAll(allCols, page0);
	    Collections.addAll(allCols, page1);
	    Collections.addAll(allCols, page2);
	    Collections.addAll(allCols, page3);
	    Collections.addAll(allCols, page4);
	    Collections.addAll(allCols, page5);
	    Collections.addAll(allCols, page6);
	    return allCols.toArray(new String[allCols.size()]);
	}
	
	// Database information
	public static final String TAG = "DBAdapter";
	private static final String DATABASE_NAME = "minap";
	private static final String TABLE_NAME = "patient";
	private static final int DATABASE_VERSION = 8; // MUST BE INCREASED IF THERE'S A CHANGE IN DATABASE_CREATE SQL STATEMENT
	
	// Database creation SQL Statement
	private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
			RECORD_NO + 							" TEXT PRIMARY KEY, " + 	// 1.02 - START PATIENT INFO PAGE
			PATIENT_FORENAME + 						" TEXT NOT NULL, " + 						// 1.05
			PATIENT_SURNAME + 						" TEXT NOT NULL, " + 						// 1.04
			PATIENT_DOB + 							" TEXT NOT NULL, " +						// 1.06
			NHS_NUMBER + 							" TEXT NOT NULL, " +		 				// 1.03
			HOSPITAL_IDENTIFIER + 					" TEXT NOT NULL, " +						// 1.01
			ADMISSION_DATE  + 						" TEXT NOT NULL, " +						/** NO FIELD NUMBER */
			
			INITIAL_DIAGNOSIS + 					" TEXT, " + 								// 2.01 - START INITIAL DIAGNOSIS PAGE
			ADMISSION_AFTER_NSTEMI + 				" TEXT, " + 								// No field number
			HIGH_RISK_NSTEMI + 						" TEXT, " + 								// 4.32
			INTERVENTIONAL_PROCEDURE + 				" TEXT, " + 								// 4.29
			RETURN_TO_REFERRING_HOSPITAL + 			" TEXT, " + 								// 4.26
			INTERVENTIONAL_CENTRE_CODE_ID + 		" TEXT, " +									/** (String) No Field number */

			PATIENT_GENDER + 						" TEXT, " + 								// 1.07 - START DEMOGRAPHICS AND ADMISSION PAGE
			PATIENT_ETHNICITY + 					" TEXT, " + 								// 1.13
			ADMISSION_METHOD + 						" TEXT, " + 								// 2.39
			ADMISSION_WARD + 						" TEXT, " +									// 3.17
			GP_PCT_CODE + 							" TEXT, " + 								// 1.11
			PATIENT_POST_CODE + 					" TEXT, " + 								// 1.10
			ADMITTING_CONSULTANT + 					" TEXT, " + 								// 2.22
			ADMISSION_STATUS + 						" TEXT, " + 								// 1.09
			PLACE_FIRST_12_LEAD_ECG_PERFORMED + 	" TEXT, " + 								// 2.22
			NHS_VERIFICATION + 						" TEXT, " +									/** (string) no field number */	

			INITIAL_REPERFUSION_TREATMENT + 		" TEXT, " +								 	// 3.39 - START INITIAL REPERFUSION PAGE
			REPERFUSION_NOT_GIVEN + 				" TEXT, " + 								// 3.08
			ECG_DETERMINING_TREATMENT + 			" TEXT, " + 								// 2.03
			ECG_QRS_COMPLEX_DURATION + 				" TEXT, " + 								// 2.37
			STEMI_LOCATION + 						" TEXT, " + 								// 2.40
			INTERVENTIONAL_CENTRE_CODE + 			" TEXT, " + 								// 4.20
			INFARCTION_SITE + 						" TEXT, " +									// 2.36
			
			CORONARY_ANGIO + 						" TEXT, " +									// 4.13 - START ANGIOGRAPHY PAGE
			REFERRAL_DATE + 						" TEXT, " +				 					// 4.15
			ANGIO_PERFORM_DELAY + 					" TEXT, " +									// 4.30
			ANGIO_DATE + 							" TEXT, " +									// 4.18
			INTERVENTIONAL_CENTRE_CODE_AN + 		" TEXT, " +									/** No Field number */
			LOCAL_INTERVENTION + 					" TEXT, " +									// 4.19
			CORONARY_INTERVENTION+ 					" TEXT, " +									// 4.14
			PATIENT_RETURN + 						" TEXT, " +									/** No field number */
			DAYCASE_TRANSFER + 						" TEXT, " +									// 4.17
			REFERRING_RETURN + 						" TEXT, " +									// 4.26

 			SYSTOLIC + 								" TEXT, " +									// 2.20 - START EXAMINATIONS PAGE
			HEART_RATE + 							" TEXT, " +									// 2.21
			KILLIP_CLASS + 							" TEXT, " +									// 2.41
			BMI + 									" TEXT, " +									// No field number
			HEIGHT + 								" TEXT, " +									// 2.29
			WEIGHT + 								" TEXT, " + 								// 2.30
			GRACE_SCORE + 							" TEXT, " +									/** Missing algorithm */
			
			PREVIOUS_AMI + 							" TEXT, " +									// (byte) Field 2.05
			HYPERTENSION + 							" TEXT, " +									// (byte) Field 2.07
			CEREBROVASCULAR + 						" TEXT, " +									// (byte) Field 2.10
			PREVIOUS_PCI + 							" TEXT, " +									// (byte) Field 2.18
			SMOKING + 								" TEXT, " +									// (byte) Field 2.16
			DIABETES + 								" TEXT, " +									// (byte) Field 2.17
			PREVIOUS_ANGINA + 						" TEXT, " +									// (byte) Field 2.06
			HYPERCHOLESTEROL + 						" TEXT, " +									// (byte) Field 2.08
			ASTHMA_COPD  + 							" TEXT, " +									// (byte) Field 2.11
			PREVIOUS_CABG + 						" TEXT, " +									// (byte) Field 2.19 
			HEART_FAILURE + 						" TEXT, " +									// (byte) Field 2.13
			PV_DISEASE + 							" TEXT, " +									// (byte) Field 2.09
			RENAL_FAILURE+ 							" TEXT, " +									// (byte) Field 2.12
			FAMILY_CHD + 							" TEXT); ";									// (byte) Field 2.32

			
	// Context for this session
	private final Context context;
	
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper {
		// Set up a DatabaseHelper object for DBAdapter
		DatabaseHelper(Context context)	{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		@Override
		// Try to create a DB, throw SQLException if not successful
		public void onCreate(SQLiteDatabase db)	{
			try {
				db.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// forces a change to TAG variable if Schema is changed. Old table is dropped, new is created.
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + 
					" which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}
	}
	
	// Opens the DB
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}
	
	// Closes the DB
	public void close() {
		DBHelper.close();
	}
	
	/** Database helper methods */
	
	// Create a new Patient record returns boolean flag - WILL ALWAYS HAPPEN ON PATIENT INFORMATION PAGE
	public boolean insertPatient(String id, String forename, String surname, String dob, String nhs, String hId, String admDate) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(RECORD_NO, id);
		initialValues.put(PATIENT_FORENAME, forename);
		initialValues.put(PATIENT_SURNAME, surname);
		initialValues.put(PATIENT_DOB, dob);
		initialValues.put(NHS_NUMBER, nhs);
		initialValues.put(HOSPITAL_IDENTIFIER, hId);
		initialValues.put(ADMISSION_DATE, admDate);
		return db.insert(TABLE_NAME, null, initialValues) > 0;
	}
	
	// Update Patient Info Page by id returns boolean flag - WILL UPDATE ALL FIELDS ON PAGE
	public boolean updatePatientInfo(String oldid, String newid, String forename, String surname, String dob, String nhs, String hId, String admDate) {
		ContentValues updateInfo = new ContentValues();
		updateInfo.put(RECORD_NO, newid);
		updateInfo.put(PATIENT_FORENAME, forename);
		updateInfo.put(PATIENT_SURNAME, surname);
		updateInfo.put(PATIENT_DOB, dob);
		updateInfo.put(NHS_NUMBER, nhs);
		updateInfo.put(HOSPITAL_IDENTIFIER, hId);
		updateInfo.put(ADMISSION_DATE, admDate);
		return db.update(TABLE_NAME, updateInfo, RECORD_NO + "= '" + oldid + "'", null) > 0;
	}
	
	// Select * from Patient Info Page by id returns cursor containing selected record
	public Cursor getPatientInfo(String id) throws SQLException
	{
		Cursor mCursor = db.query(true, TABLE_NAME,	PATIENT_INFO, RECORD_NO + "= '" + id + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	// Update Initial Diagnosis Page by id returns boolean flag - MUST BE CALLED TO POPULATE PAGE (i.e. there is no CREATE INITIAL DIAGNOSIS)
	public boolean updateInitialDiagnosis(String id, String diagnosis, String admission, String nstemi, String procedure, String refer, String code) {
		ContentValues updateDiagnosis = new ContentValues();
		updateDiagnosis.put(INITIAL_DIAGNOSIS, diagnosis);
		updateDiagnosis.put(ADMISSION_AFTER_NSTEMI, admission);
		updateDiagnosis.put(HIGH_RISK_NSTEMI, nstemi);
		updateDiagnosis.put(INTERVENTIONAL_PROCEDURE, procedure);
		updateDiagnosis.put(RETURN_TO_REFERRING_HOSPITAL, refer);
		updateDiagnosis.put(INTERVENTIONAL_CENTRE_CODE_ID, code);
		return db.update(TABLE_NAME, updateDiagnosis, RECORD_NO + "= '" + id + "'", null) > 0;
	}	
	
	// Select * from Initial Diagnosis Page by id returns cursor containing selected record
	public Cursor getDiagnosis(String id) throws SQLException {
		Cursor mCursor = db.query(true, TABLE_NAME,	DIAGNOSIS, RECORD_NO + "= '" + id + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
		
	// Update Demographics and Admission by id returns boolean flag - MUST BE CALLED TO POPULATE PAGE
	public boolean updateDemographics(String id, String gender, String ethnicity, String method, String ward, String gpcode, String post, String consultant, String status, String ecg, String verif) {
		ContentValues updateDemographics = new ContentValues();
		updateDemographics.put(PATIENT_GENDER, gender);
		updateDemographics.put(PATIENT_ETHNICITY, ethnicity);
		updateDemographics.put(ADMISSION_METHOD, method);
		updateDemographics.put(ADMISSION_WARD, ward);
		updateDemographics.put(GP_PCT_CODE, gpcode);
		updateDemographics.put(PATIENT_POST_CODE, post);
		updateDemographics.put(ADMITTING_CONSULTANT, consultant);
		updateDemographics.put(ADMISSION_STATUS, status);
		updateDemographics.put(PLACE_FIRST_12_LEAD_ECG_PERFORMED, ecg);
		updateDemographics.put(NHS_VERIFICATION, verif);
		return db.update(TABLE_NAME, updateDemographics, RECORD_NO + "= '" + id + "'", null) > 0;
	}
		
	// Select * from Demographics Page by id returns cursor containing selected record
	public Cursor getDemographics(String id) throws SQLException {
		Cursor mCursor = db.query(true, TABLE_NAME,	ADMISSION, RECORD_NO + "= '" + id + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	// Update Initial Reperfusion by id returns boolean flag - MUST BE CALLED TO POPULATE PAGE
	public boolean updateInitialReperfusion(String id, String treatment, String reperfusion, String ecgtreat, String ecgqrs, String location, String iccode, String infarction) {
		ContentValues updateReperfusion = new ContentValues();
		updateReperfusion.put(INITIAL_REPERFUSION_TREATMENT, treatment);
		updateReperfusion.put(REPERFUSION_NOT_GIVEN, reperfusion);
		updateReperfusion.put(ECG_DETERMINING_TREATMENT, ecgtreat);
		updateReperfusion.put(ECG_QRS_COMPLEX_DURATION, ecgqrs);
		updateReperfusion.put(STEMI_LOCATION, location);
		updateReperfusion.put(INTERVENTIONAL_CENTRE_CODE, iccode);
		updateReperfusion.put(INFARCTION_SITE, infarction);
		return db.update(TABLE_NAME, updateReperfusion, RECORD_NO + "= '" + id + "'", null) > 0;
	}

	// Select * from Initial Reperfusion Page by id returns cursor containing selected record
	public Cursor getReperfusion(String id) throws SQLException {
		Cursor mCursor = db.query(true, TABLE_NAME,	REPERFUSION, RECORD_NO + "= '" + id + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	// Update Angiography by id returns boolean flag - MUST BE CALLED TO POPULATE PAGE
	public boolean updateAngiography(String id, String angio, String drefer, String adelay, String adate, String acode, String inter, String coronary, String patret, String daycase, String refret) {
		ContentValues updateAngiography = new ContentValues();
		updateAngiography.put(CORONARY_ANGIO, angio);
		updateAngiography.put(REFERRAL_DATE, drefer);
		updateAngiography.put(ANGIO_PERFORM_DELAY, adelay);
		updateAngiography.put(ANGIO_DATE, adate);
		updateAngiography.put(INTERVENTIONAL_CENTRE_CODE_AN, acode);
		updateAngiography.put(LOCAL_INTERVENTION, inter);
		updateAngiography.put(CORONARY_INTERVENTION, coronary);
		updateAngiography.put(PATIENT_RETURN, patret);
		updateAngiography.put(DAYCASE_TRANSFER, daycase);
		updateAngiography.put(REFERRING_RETURN, refret);
		return db.update(TABLE_NAME, updateAngiography, RECORD_NO + "= '" + id + "'", null) > 0;
	}

	// Select * from Angiography Page by id returns cursor containing selected record
	public Cursor getAngiography(String id) throws SQLException {
		Cursor mCursor = db.query(true, TABLE_NAME,	ANGIOGRAPHY, RECORD_NO + "= '" + id + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	// Update Examinations by id returns boolean flag - MUST BE CALLED TO POPULATE PAGE
	public boolean updateExaminations(String id, String systolic, String heart, String killip, String bmi, String height, String weight, String grace) {
		ContentValues updateAngiography = new ContentValues();
		updateAngiography.put(SYSTOLIC, systolic);
		updateAngiography.put(HEART_RATE, heart);
		updateAngiography.put(KILLIP_CLASS, killip);
		updateAngiography.put(BMI, bmi);
		updateAngiography.put(HEIGHT, height);
		updateAngiography.put(WEIGHT, weight);
		updateAngiography.put(GRACE_SCORE, grace);
		return db.update(TABLE_NAME, updateAngiography, RECORD_NO + "= '" + id + "'", null) > 0;
	}

	// Select * from Examinations Page by id returns cursor containing selected record
	public Cursor getExaminations(String id) throws SQLException {
		Cursor mCursor = db.query(true, TABLE_NAME,	EXAMINATIONS, RECORD_NO + "= '" + id + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	// Update Medical History by id returns boolean flag - MUST BE CALLED TO POPULATE PAGE
	public boolean updateMedicalHistory(String id, String ami, String tension, String cerebro, String pci, String smoke, String diabetes, String angina, String choles, String asthma, String cabg, String heart, String vascular, String renal, String chd) {
		ContentValues updateHistory = new ContentValues();
		updateHistory.put(PREVIOUS_AMI, ami);
		updateHistory.put(HYPERTENSION, tension);
		updateHistory.put(CEREBROVASCULAR, cerebro);
		updateHistory.put(PREVIOUS_PCI, pci);
		updateHistory.put(SMOKING, smoke);
		updateHistory.put(DIABETES, diabetes);
		updateHistory.put(PREVIOUS_ANGINA, angina);
		updateHistory.put(HYPERCHOLESTEROL, choles);
		updateHistory.put(ASTHMA_COPD, asthma);
		updateHistory.put(PREVIOUS_CABG, cabg);
		updateHistory.put(HEART_FAILURE, heart);
		updateHistory.put(PV_DISEASE, vascular);
		updateHistory.put(RENAL_FAILURE, renal);
		updateHistory.put(FAMILY_CHD, chd);
		return db.update(TABLE_NAME, updateHistory, RECORD_NO + "= '" + id + "'", null) > 0;
	}

	// Select * from Medical History Page by id returns cursor containing selected record
	public Cursor getMedicalHistory(String id) throws SQLException {
		Cursor mCursor = db.query(true, TABLE_NAME,	MEDICAL_HISTORY, RECORD_NO + "= '" + id + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	// Delete patient by id returns boolean flag
	public boolean deletePatient(String id)
	{
		return db.delete(TABLE_NAME, RECORD_NO + "= '" + id + "'", null) > 0;
	}
	
	// Select * from table returns cursor containing all records
	public Cursor allPatients()	{
		String [] ALL_COLUMNS = concatenateArrays(PATIENT_INFO, DIAGNOSIS, ADMISSION, REPERFUSION, ANGIOGRAPHY, EXAMINATIONS, MEDICAL_HISTORY);
		return db.query(TABLE_NAME, ALL_COLUMNS, null, null, null, null, null);
	}
}
