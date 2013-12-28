package com.ucl.appteam7.minapmobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

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
