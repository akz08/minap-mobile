package com.ucl.appteam7.minapmobile;

import android.support.v4.app.Fragment;

public class NavigationMapActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		boolean firstLogin = (boolean)getIntent()
				.getBooleanExtra(NavigationMapFragment.EXTRA_FIRST_LOGIN, false);
		return NavigationMapFragment.newInstance(firstLogin);
	}

}
