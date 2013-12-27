package com.ucl.appteam7.minapmobile;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

public class NavigationMapActivity extends SingleFragmentActivityDrawer {
	public static final String EXTRA_FIRST_LOGIN = "com.ucl.appteam7.minapmobile.EXTRA_FIRST_LOGIN";
	private static final int DRAWER_OPEN_DELAY = 600;
	
	 private boolean mFirstLogin;
	
	@Override
	protected Fragment createFragment() {
		return new NavigationMapFragment();
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set flag for drawer opening behaviour
		if (savedInstanceState != null) {
			mFirstLogin = savedInstanceState.getBoolean(EXTRA_FIRST_LOGIN);
		} else {
			mFirstLogin = (boolean)getIntent()
					.getBooleanExtra(NavigationMapActivity.EXTRA_FIRST_LOGIN, false);
		}
		
		// Wire up the navigation icon for the drawer
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
	}
	
	@Override
	public void onResume() {
	    super.onResume(); 
	    // syncing the state of the drawer toggle
	    mDrawerToggle.syncState();
	    
	    // if first session, animate the drawer in
	    if (mFirstLogin) {
		    mDrawerLayout.postDelayed(new Runnable() {
		        @Override
		        public void run() {
		            mDrawerLayout.openDrawer(Gravity.LEFT);
		        }
		    }, DRAWER_OPEN_DELAY);
		    
		    mFirstLogin = false;
	    }
	}
	
	// Handle the events on the action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    // Syncing the navigation drawer
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

}
