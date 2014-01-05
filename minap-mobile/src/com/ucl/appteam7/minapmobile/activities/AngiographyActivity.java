package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.AngiographyFragment;

import android.support.v4.app.Fragment;

public class AngiographyActivity extends SingleFragmentActivityDrawer {

	@Override
	protected Fragment createFragment() {
		return new AngiographyFragment();
	}

}
