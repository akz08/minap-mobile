package com.ucl.appteam7.minapmobile;

import android.app.Application;

import com.testflightapp.lib.TestFlight;

public class MinapMobile extends Application {
	@Override
    public void onCreate() {
        super.onCreate();
        //Initialize TestFlight with your app token.
        TestFlight.takeOff(this, "58489a02-ee35-4ca4-881e-c25687252e1a");
        
    }
}
