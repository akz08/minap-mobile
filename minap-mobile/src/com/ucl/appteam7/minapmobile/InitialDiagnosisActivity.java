package com.ucl.appteam7.minapmobile;

import android.support.v4.app.Fragment;
import android.view.Gravity;

public class InitialDiagnosisActivity extends SingleFragmentActivityDrawer {

	@Override
	protected Fragment createFragment() {
		return new InitialDiagnosisFragment();
	}

}