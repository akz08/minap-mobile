/**
 * DBAdapter class will handle all SQL related reading, writing and updating
 * @author david
 */
package com.ucl.appteam7.minapmobile;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBAdapter {
	// Database schema : variable name, table column; (return type on separate class) field number
	// Page 0 : Patient Info - 7 fields
	public static final String HOSPITAL_IDENTIFIER = "HospitalID"; 		// (String) Field 1.01
	public static final String RECORD_NO = "RecordNum"; 				// (short) Field 1.02
	public static final String NHS_NUMBER = "NHSNumber"; 				// (string) Field 1.03
	public static final String PATIENT_SURNAME = "PatientSurname";  	// (String) Field 1.04
	public static final String PATIENT_FORENAME = "PatientForename"; 	// (string) Field 1.05
	public static final String PATIENT_DOB = "PatientDOB"; 				// (Date) Field 1.06
	public static final String ADMISSION_DATE = "AdminDate"; 			// (Date) No field number
	
	// Page 1 - Initial Diagnosis - 6 fields
	public static final String INITIAL_DIAGNOSIS = "InitialDiagosis"; 						// (byte) Field 2.01
	public static final String ADMISSION_AFTER_NSTEMI = "AdminStemi"; 						// (boolean) No field number
	public static final String HIGH_RISK_NSTEMI = "HiRisknSTEMI"; 							// (byte) Field 4.32
	public static final String INTERVENTIONAL_PROCEDURE = "InterventionalProcedure"; 		// (byte) Field 4.29
	public static final String RETURN_TO_REFERRING_HOSPITAL = "ReferHospitalReturn"; 		// (Date) Field 4.26
	public static final String INTERVENTIONAL_CENTRE_CODE_ID = "InterventionCentreCode";	/** (String) No Field number */
	
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
	
	// Page 3 - Initial Reperfusion - 7 fields
	public static final String INITIAL_REPERFUSION_TREATMENT = "InitialReperfusionTreat"; 	// (byte) field 3.39
	public static final String REPERFUSION_NOT_GIVEN = "ReperNotGiven"; 					// (byte) Field 3.08
	public static final String ECG_DETERMINING_TREATMENT = "ECGDetermineTreat"; 			// (byte) Field 2.03
	public static final String ECG_QRS_COMPLEX_DURATION = "ECG_QRSComplex"; 				// (byte) Field 2.37
	public static final String STEMI_LOCATION = "LocationSTEMI"; 							// (byte) Field 2.40
	public static final String INTERVENTIONAL_CENTRE_CODE = "InterventionCentreCode"; 		// (string) Field 4.20
	public static final String INFARCTION_SITE = "InfarctionSite"; 							// (byte) Field 2.36
	
	// Page 4 - Angiography - 10 fields
	public static final String CORONARY_ANGIO = "CoronaryAngio";							// (byte) Field 4.13
	public static final String REFERRAL_DATE = "ReferralDate";			 					// (Date) Field 4.15
	public static final String ANGIO_PERFORM_DELAY = "AngioDelay";							// (byte) Field 4.30
	public static final String ANGIO_DATE = "AngioDate";									// (Date) Field 4.18
	public static final String INTERVENTIONAL_CENTRE_CODE_AN = "InterventionCentreCode";	/** (String) No Field number */
	public static final String LOCAL_INTERVENTION = "LocalIntervention";					// (Date) Field 4.19
	public static final String CORONARY_INTERVENTION = "CoronaryIntervention";				// (byte) Field 4.14
	public static final String PATIENT_RETURN = "ReturnExpected";							/** (boolean) no field number */
	public static final String DAYCASE_TRANSFER = "DaycaseTransfer";						// (Date) Field 4.17
	public static final String REFERRING_RETURN = "ReferringHospitalReturn";				// (Date) Field 4.26
	
	// Page 5 - Examinations - 7 fields
	public static final String SYSTOLIC = "SystolicBP";				// (short) Field 2.20
	public static final String HEART_RATE = "HeartRate";			// (short) Field 2.21
	public static final String KILLIP_CLASS = "KillipClass";		// (byte) Field 2.41
	public static final String BMI = "BMI";							// (double) No field number
	public static final String HEIGHT = "Height";					// (short) Field 2.29
	public static final String WEIGHT = "Weight"; 					// (short) Field 2.30
	public static final String GRACE_SCORE = "GraceScore";			/** Missing algorithm */
	
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
	
	// Database information
	public static final String TAG = "DBAdapter";
	private static final String DATABASE_NAME = "minap";
	private static final String TABLE_NAME = "patient";
	private static final int DATABASE_VERSION = 3;
	// Database creation SQL Statement
	private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
			RECORD_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 	// 1.02
			PATIENT_FORENAME + " TEXT NOT NULL, " + 				// 1.05
			PATIENT_SURNAME + " TEXT NOT NULL, " + 					// 1.04
			PATIENT_DOB + " DATE NOT NULL);";						// 1.06
	
	// Context for this session
	private final Context context;
	
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBAdapter(Context ctx)
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db)
		{
			try {
				db.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
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
	public void close()
	{
		DBHelper.close();
	}
	
	// Insert patient info here
	public long insertPatient(String surname, Date dob)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put(PATIENT_SURNAME, surname);
		String dobtext = dob.toString();
		initialValues.put(PATIENT_DOB, dobtext);
		return db.insert(TABLE_NAME, null, initialValues);
	}
	
	// Delete patient by last name
	public boolean deletePatient(String surname)
	{
		return db.delete(TABLE_NAME, PATIENT_SURNAME + "=" + surname, null) > 0;
	}
	
	// Select * from table
	public Cursor allPatients()
	{
		return db.query(TABLE_NAME, new String[] {RECORD_NO, PATIENT_SURNAME, PATIENT_DOB}, null, null, null, null, null);
	}
	
	// Select * from table where surname = (parameter)
	public Cursor getPatient(String surname) throws SQLException
	{
		Cursor mCursor = db.query(true, DATABASE_NAME, new String[] {PATIENT_SURNAME, PATIENT_DOB}, 
				PATIENT_SURNAME + "=" + surname, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	// Update patient where surname = (parameter)
	public boolean updatePatient(String surname, Date dob)
	{
		ContentValues update = new ContentValues();
		update.put(PATIENT_SURNAME, surname);
		String dobtext = dob.toString();
		update.put(PATIENT_DOB, dobtext);
		return db.update(TABLE_NAME, update, PATIENT_SURNAME + "=" + surname, null) > 0;
	}
}
