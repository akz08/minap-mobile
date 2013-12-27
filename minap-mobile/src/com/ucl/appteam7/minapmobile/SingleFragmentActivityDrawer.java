/**
 * Some code in this class based on the book: 
 * "Android Programming: The Big Nerd Ranch Guide" (Publication Date: 28 Mar 2013)
 * by Bill Phillips and Brian Hardy 
 */

package com.ucl.appteam7.minapmobile;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;



public abstract class SingleFragmentActivityDrawer extends FragmentActivity {
	protected abstract Fragment createFragment();

	private static final int DRAWER_OPEN_DELAY = 600;
	
	 private String[] mNavigationTitles;
	 private DrawerLayout mDrawerLayout;
	 private ActionBarDrawerToggle mDrawerToggle;
	 private ListView mDrawerList;
	 private boolean mFirstLogin;
	 Button mEditPatientButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
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
             
             
             // link interactions of drawer and action bar icon
             mDrawerToggle = new ActionBarDrawerToggle(
             		this, 
             		mDrawerLayout,
             		R.drawable.ic_drawer, 
             		R.string.drawer_open, 
             		R.string.drawer_close) {
             	
             	// called when drawer completely closed
             	public void onDrawerClosed(View view) {
             		
             	}
             	// called when drawer completely opened
             	public void onDrawerOpened(View view) {
             		
             	}
             };
             
             // enable app icon to act as action to toggle nav drawer
             getActionBar().setDisplayHomeAsUpEnabled(true);
             getActionBar().setHomeButtonEnabled(true);
             getActionBar().setDisplayShowHomeEnabled(true);
             
             // set drawer toggle as the DrawerListener
             mDrawerLayout.setDrawerListener(mDrawerToggle);
             
             // add listener to edit button
             mEditPatientButton = (Button)findViewById(R.id.edit_patient_details_button);
//     		mEditPatientButton.setOnClickListener(new View.OnClickListener() {
//     			
//     			@Override
//     			public void onClick(View view) {
//     				Intent intent = new Intent(this, PatientDetailsActivity.class);
//     				startActivity(intent);
//     			}
//     		});
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
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
 	}
}
