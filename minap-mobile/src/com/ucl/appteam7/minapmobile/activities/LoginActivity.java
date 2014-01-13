package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.LoginFragment;

import android.support.v4.app.Fragment;
import android.view.Menu;

public class LoginActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new LoginFragment();
	}
	
	// Override the creation of options menu to disable it
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}
}
