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
		
		// add a test patient
		db.open();
		long id = db.insertPatient("Smith", new Date());
		id = db.insertPatient("Jones", new Date());
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
		
		// get a patient by last name - currently not working??
//		db.open();
//		Cursor c = db.getPatient("Smith");
//		if (c.moveToFirst())
//		{
//			DisplayPatient(c);
//		}
//		else 
//			Toast.makeText(this, "No Contact Found", Toast.LENGTH_LONG).show();
//		db.close();
		
		// update a patient
//		db.open();
//		if (db.updatePatient("Smith", new Date()))
//			Toast.makeText(this, "Update Successful", Toast.LENGTH_LONG).show();
//		else
//			Toast.makeText(this, "Update failed", Toast.LENGTH_LONG).show();
//		db.close();
	}
	
	// Display test patients 
	public void DisplayPatient(Cursor c)
	{
		Toast.makeText(this, "id: " + c.getString(0) + "\nSurname: " + c.getString(1) + "\n"
				+ "DOB: " + c.getString(2), Toast.LENGTH_LONG).show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
