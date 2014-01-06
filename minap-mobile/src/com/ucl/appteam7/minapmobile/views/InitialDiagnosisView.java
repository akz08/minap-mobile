package com.ucl.appteam7.minapmobile.views;

import com.ucl.appteam7.minapmobile.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class InitialDiagnosisView extends ScrollView {
	
	private RadioGroup mWorkingDiagnosisRadioGroup;
	
	public static interface ViewListener {
		public void hideAdmissionStemi();
		public void showAdmissionStemi();
	}
	
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public InitialDiagnosisView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		// Wire up radio buttons for nSTEMI
		mWorkingDiagnosisRadioGroup = (RadioGroup)findViewById(R.id.radio_group_working_diagnosis);
		mWorkingDiagnosisRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch(checkedId) {
				case R.id.radio_working_diagnosis_1:
					viewListener.hideAdmissionStemi();
					break;
				case R.id.radio_working_diagnosis_3:
					viewListener.showAdmissionStemi();
					break;
				case R.id.radio_working_diagnosis_4:
					viewListener.hideAdmissionStemi();
					break;
				case R.id.radio_working_diagnosis_5:
					viewListener.hideAdmissionStemi();
					break;
				}
				
			}
		});
	}
}
