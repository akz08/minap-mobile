package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.InitialReperfusionFragment;

import android.support.v4.app.Fragment;

public class InitialReperfusionActivity extends SingleFragmentActivityDrawer {

	@Override
	protected Fragment createFragment() {
		return new InitialReperfusionFragment();
	}

}
