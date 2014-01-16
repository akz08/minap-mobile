package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;

import com.ucl.appteam7.minapmobile.R;

public class InitialDiagnosisView extends ScrollView {
	
	private RadioGroup mWorkingDiagnosisRadioGroup;
	private RadioGroup mAstemiAdmissionRadioGroup;
	private RadioButton mAstemiAdmissionRadioNo;
	
	private ImageButton mAboutWorkingDiagnosisButton;
	private ImageButton mAboutAstemiAdmissionButton;
	
	private Button mNextPage;
	
	public static interface ViewListener {
		
		// hidden values
		public void showAdmissionHighRisk();
		public void hideAdmissionHighRisk();
		public void showAdmissionElsewhere();
		public void hideAdmissionElsewhere();
		
		// about buttons
		public void showAboutWorkingDiagnosis();
		public void showAboutAstemiAdmission();
		
		public void showAboutHighRiskNstemi();
		public void showAboutProcedureAtInterventionalHospital();
		public void showAboutInterventionalCentre();
		public void showAboutDateOfReturn();
		
		// navigation buttons
		public void nextPage();
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
		
		// Wire up visible 'about' information buttons
		mAboutWorkingDiagnosisButton = (ImageButton)findViewById(R.id.about_working_diagnosis);
		mAboutWorkingDiagnosisButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutWorkingDiagnosis();
			}
		});
		
		mAboutAstemiAdmissionButton = (ImageButton)findViewById(R.id.about_astemi_admission);
		mAboutAstemiAdmissionButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutAstemiAdmission();
			}
		});
		
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
		
		// set default to no for "admission after treatment for stemi elsewhere?"
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
		
		// wire up page navigation button
		mNextPage = (Button)findViewById(R.id.next_page_button);
		mNextPage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.nextPage();
				
			}
		});
	}
}
