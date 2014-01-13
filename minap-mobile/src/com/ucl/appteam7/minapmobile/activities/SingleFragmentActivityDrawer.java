/**
 * Some code in this class based on the book: 
 * "Android Programming: The Big Nerd Ranch Guide" (Publication Date: 28 Mar 2013)
 * by Bill Phillips and Brian Hardy 
 */

package com.ucl.appteam7.minapmobile.activities;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.fragments.PatientDetailsFragment;



public abstract class SingleFragmentActivityDrawer extends FragmentActivity {
	
	public static final String TAG = "com.ucl.appteam7.minapmobile.activitydrawer";
	protected abstract Fragment createFragment();
	
	 private String[] mNavigationTitles;
	 protected DrawerLayout mDrawerLayout;
	 protected ActionBarDrawerToggle mDrawerToggle;
	 protected ListView mDrawerList;
	 Button mEditPatientButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        // Fragment code here
        setContentView(R.layout.activity_fragment_drawer);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainerDrawer);

        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction()
                .add(R.id.fragmentContainerDrawer, fragment)
                .commit();
        }
        
        // Navigation drawer code here
        // setup navigation drawer
     	mNavigationTitles = getResources().getStringArray(R.array.navigation_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
        R.layout.drawer_list_item, mNavigationTitles));
             
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
             
        // add listener to edit button
        mEditPatientButton = (Button)findViewById(R.id.edit_patient_details_button);
        mEditPatientButton.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View view) {
        		// open patient details with focus on hospital number field
        		Intent intent = new Intent(SingleFragmentActivityDrawer.this, PatientDetailsActivity.class);
        		intent.putExtra(PatientDetailsFragment.EXTRA_FOCUS_HOSPITAL_NUMBER, true);
     			startActivity(intent);
     		}
        });
        
    }
    
 	private class DrawerItemClickListener implements ListView.OnItemClickListener {
 		@Override
 		public void onItemClick(AdapterView parent, View view, int position, long id) {
 			selectItem(position);
 		}
 	}
 	
 	/**
 	 * Called by DrawerItemClickListener when drawer item is clicked
 	 * 
 	 * @param position position of item in drawer's list
 	 */
 	private void selectItem(int position) {
 		// just close the drawer for now
// 		mDrawerLayout.closeDrawer(Gravity.LEFT);
 		
 		// get the title of the selected page
 		String navigationTitle = getResources().getStringArray(R.array.navigation_array)[position];
 		// wrangling it to get the fragment class (full) name
 		String navigationActivityClass = wrangleStringToClass(navigationTitle);
 		Log.d(TAG, navigationActivityClass);
 		try {
 			Intent intent = new Intent(SingleFragmentActivityDrawer.this, Class.forName(navigationActivityClass));
 			startActivity(intent);
 			Log.d(TAG, "tried calling the activity intent");
 		}
 		catch (ClassNotFoundException e) {
 			e.printStackTrace();
 		}
 		

 	}

 	/**
 	 * Modify page titles defined in strings.cml navigation_array to convention used for activity class naming
 	 * 
 	 * @param input string containing the identifying words of the corresponding activity class
 	 * @return activity class name of the given page title
 	 */
 	private String wrangleStringToClass(String input) {
 		// TODO: make this class path not so hard-coded
 		String output = "com.ucl.appteam7.minapmobile.activities.";

		String[] inputStringArray = input.split(" ");

		for(int i = 0; i < inputStringArray.length; i++) {
			char capsChar = Character.toUpperCase(inputStringArray[i].charAt(0));
			inputStringArray[i] = Character.toString(capsChar).concat(inputStringArray[i].substring(1));
			// System.out.println(a);
			output = output.concat(inputStringArray[i]);
		}
		output = output.concat("Activity");
		return output;
 	}
 	
 	
 	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.fragment_general, menu);
		return true;
		
	}
 	
 // setup action bar
 	@Override
 	public boolean onOptionsItemSelected(MenuItem item) {
 		Intent intent;
 		
 		switch (item.getItemId()) {
 			case R.id.menu_item_log_out:
 				// Simple link to login page
 				intent = new Intent(this, LoginActivity.class);
 				startActivity(intent);
 				Toast.makeText(this, R.string.logging_out, Toast.LENGTH_SHORT).show();
 				return true;
 			case R.id.menu_item_help:
 				// search code taken from Google's Navigation Drawer Example
 	            intent = new Intent(Intent.ACTION_WEB_SEARCH);
 	            intent.putExtra(SearchManager.QUERY, "how to use an android app");
 	            // catch event that there's no activity to handle intent
 	            if (intent.resolveActivity(getPackageManager()) != null) {
 	                startActivity(intent);
 	            } else {
 	                Toast.makeText(this, R.string.browser_not_available, Toast.LENGTH_LONG).show();
 	            }
 				return true;
 			default:
 				return super.onOptionsItemSelected(item);
 		}
 	}
}
