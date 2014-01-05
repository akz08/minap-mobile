package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.PrehospitalEventsFragment;

import android.support.v4.app.Fragment;

public class PrehospitalEventsActivity extends SingleFragmentActivityDrawer {

	@Override
	protected Fragment createFragment() {
		return new PrehospitalEventsFragment();
	}

}
