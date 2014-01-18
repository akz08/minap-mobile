package com.ucl.appteam7.minapmobile.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;

import com.ucl.appteam7.minapmobile.fragments.InitialDiagnosisFragment;

public class InitialDiagnosisActivity extends SingleFragmentActivityDrawer {
	// temporary variables
//	
	
	@Override
	protected Fragment createFragment() {
		return new InitialDiagnosisFragment();
	}

}
