/**
 * First-run code based off the book:
 * "Android Cookbook: Problems and Solutions for Android Developers" (Publication Date: April 2012)
 * by Ian F. Darwin
 */

package com.ucl.appteam7.minapmobile;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

// Analytics
import com.testflightapp.lib.TestFlight;
import com.crashlytics.android.Crashlytics;

public class MinapMobile extends Application {
	private static final String FIRST_RUN = "firstRun";
	private static final String LEGAL_AGREED = "legalAgreed";
	
	SharedPreferences mPrefs;
	
	@Override
    public void onCreate() {
        super.onCreate();
        
        // Set up prefs for app first-run flag
        Context mContext = this.getApplicationContext();
        // '0' means only this app can read the prefs (mode private)
        mPrefs = mContext.getSharedPreferences("minapAppPrefs", 0);
        
        // Initialize TestFlight with the MINAP Mobile app token.
        TestFlight.takeOff(this, "58489a02-ee35-4ca4-881e-c25687252e1a");
        
        // Initialise Crashlytics
        Crashlytics.start(this);
    }
	
	public boolean getFirstRun() {
		return mPrefs.getBoolean(FIRST_RUN, true);
	}
	
	public void setRunned() {
		SharedPreferences.Editor edit = mPrefs.edit();
		edit.putBoolean(FIRST_RUN,  false);
		edit.commit();
	}
	
	public boolean hasAgreed() {
		return mPrefs.getBoolean(LEGAL_AGREED, false);
	}
	
	public void setAgreed() {
		SharedPreferences.Editor edit = mPrefs.edit();
		edit.putBoolean(LEGAL_AGREED, true);
		edit.commit();
	}
}
