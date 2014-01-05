package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.ExaminationsFragment;

import android.support.v4.app.Fragment;

public class ExaminationsActivity extends SingleFragmentActivityDrawer {

	@Override
	protected Fragment createFragment() {
		return new ExaminationsFragment();
	}

}
