package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.PatientDetailsFragment;

import android.support.v4.app.Fragment;

public class PatientDetailsActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new PatientDetailsFragment();
	}

}
