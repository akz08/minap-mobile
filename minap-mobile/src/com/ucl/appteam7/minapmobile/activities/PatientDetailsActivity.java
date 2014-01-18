package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.PatientDetailsFragment;

import android.support.v4.app.Fragment;

public class PatientDetailsActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// pass along the intent to the fragment
		boolean focusHospitalNumber = (Boolean)getIntent()
				.getBooleanExtra(PatientDetailsFragment.EXTRA_FOCUS_HOSPITAL_NUMBER, false);
		return PatientDetailsFragment.newInstance(focusHospitalNumber);
	}

}
