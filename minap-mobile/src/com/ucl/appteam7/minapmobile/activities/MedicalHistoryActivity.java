package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.MedicalHistoryFragment;

import android.support.v4.app.Fragment;

public class MedicalHistoryActivity extends SingleFragmentActivityDrawer {

	@Override
	protected Fragment createFragment() {
		return new MedicalHistoryFragment();
	}

}
