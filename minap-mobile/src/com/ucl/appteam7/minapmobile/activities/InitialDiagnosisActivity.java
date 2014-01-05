package com.ucl.appteam7.minapmobile.activities;

import com.ucl.appteam7.minapmobile.fragments.InitialDiagnosisFragment;

import android.support.v4.app.Fragment;

public class InitialDiagnosisActivity extends SingleFragmentActivityDrawer {
	// temporary variables
//	
	
	@Override
	protected Fragment createFragment() {
		return new InitialDiagnosisFragment();
	}
	
	//temporary
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		mContainerView = (ViewGroup) findViewById(R.id.nstemi_label);
//	}
	

}
