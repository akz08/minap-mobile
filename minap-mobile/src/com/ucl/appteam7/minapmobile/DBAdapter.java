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
	// Database schema: field names
	public static final String RECORD_NO = "RecordNum";
	public static final String PATIENT_SURNAME = "PatientSurname";
	public static final String PATIENT_DOB = "PatientDOB";
	public static final String TAG = "DBAdapter";
	
	// Database information
	private static final String DATABASE_NAME = "minap";
	private static final String TABLE_NAME = "patient";
	private static final int DATABASE_VERSION = 2;
	// Database creation SQL Statement
	private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
			RECORD_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			PATIENT_SURNAME + " TEXT NOT NULL, " +
			PATIENT_DOB + " DATE NOT NULL);";
	
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
