package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;

import com.ucl.appteam7.minapmobile.R;

public class InitialDiagnosisView extends ScrollView {
	
	private RadioGroup mWorkingDiagnosisRadioGroup;
	private RadioGroup mAstemiAdmissionRadioGroup;
	private RadioButton mAstemiAdmissionRadioNo;
	
	public static interface ViewListener {
		public void showAdmissionHighRisk();
		public void hideAdmissionHighRisk();
		public void showAdmissionElsewhere();
		public void hideAdmissionElsewhere();
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
					viewListener.hideAdmissionHighRisk();
					break;
				case R.id.radio_working_diagnosis_3:
					viewListener.showAdmissionHighRisk();
					break;
				case R.id.radio_working_diagnosis_4:
					viewListener.hideAdmissionHighRisk();
					break;
				case R.id.radio_working_diagnosis_5:
					viewListener.hideAdmissionHighRisk();
					break;
				}
				
			}
		});
		
		// set default to no
		mAstemiAdmissionRadioNo = (RadioButton)findViewById(R.id.radio_astemi_admission_no);
		mAstemiAdmissionRadioNo.setChecked(true);
		
		mAstemiAdmissionRadioGroup = (RadioGroup)findViewById(R.id.radio_group_astemi_admission);
		mAstemiAdmissionRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch(checkedId) {
				case R.id.radio_astemi_admission_yes:
					viewListener.showAdmissionElsewhere();
					break;
				case R.id.radio_astemi_admission_no:
					viewListener.hideAdmissionElsewhere();
					break;
				}
			}
		});
	}
}
