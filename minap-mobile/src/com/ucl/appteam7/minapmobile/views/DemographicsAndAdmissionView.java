package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.ucl.appteam7.minapmobile.R;

public class DemographicsAndAdmissionView extends ScrollView {
	
	private Spinner mAdmissionMethodSpinner;
	
	private ImageButton mAboutGenderButton;
	private ImageButton mAboutEthnicityButton;
	private ImageButton mAboutAdmissionMethodButton;
	private ImageButton mAboutAdmissionWardButton;
	private ImageButton mAboutAdmittingConsultantButton;	
	private ImageButton mAboutGpPctCodeButton;
	private ImageButton mAboutPostcodeButton;
	private ImageButton mAboutAdminStatusButton;
	private ImageButton mAboutPlaceEcgButton;
	
	private Button mPreviousPage;
	private Button mNextPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
		
		// hidden values
		public void showReferralHospital();
		public void hideReferralHospital();
		
		// about dialogs
		public void showAboutGender();
		public void showAboutEthnicity();
		public void showAboutAdmissionMethod();
		public void showAboutAdmissionWard();
		public void showAboutAdmittingConsultant();
		public void showAboutReferralHospital();
		public void showAboutGpPctCode();
		public void showAboutPostcode();
		public void showAboutAdminStatus();
		public void showAboutPlaceEcgPerformed();
		
		// navigation buttons
		public void previousPage();
		public void nextPage();
	}
	
	// Set up view listener
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public DemographicsAndAdmissionView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// Wire up layout elements to objects
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		// wire up admission method 4. to trigger display of referral hospital
		mAdmissionMethodSpinner =(Spinner)findViewById(R.id.admission_method_spinner);
		mAdmissionMethodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				if (pos == 4) {
					viewListener.showReferralHospital();
				} else {
					viewListener.hideReferralHospital();
				}
			}
			
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
		
		// Wire up visible 'about' information buttons
		mAboutGenderButton = (ImageButton)findViewById(R.id.about_gender);
		mAboutGenderButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutGender();
				
			}
		});
		
		mAboutEthnicityButton = (ImageButton)findViewById(R.id.about_patient_ethnicity);
		mAboutEthnicityButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutEthnicity();
				
			}
		});
		
		mAboutAdmissionMethodButton = (ImageButton)findViewById(R.id.about_admission_method);
		mAboutAdmissionMethodButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutAdmissionMethod();
				
			}
		});
		
		mAboutAdmissionWardButton = (ImageButton)findViewById(R.id.about_admission_ward);
		mAboutAdmissionWardButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutAdmissionWard();
				
			}
		});
		
		mAboutAdmittingConsultantButton = (ImageButton)findViewById(R.id.about_admitting_consultant);
		mAboutAdmittingConsultantButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutAdmittingConsultant();
				
			}
		});
		
		mAboutGpPctCodeButton = (ImageButton)findViewById(R.id.about_gp_pct_code);
		mAboutGpPctCodeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutGpPctCode();
				
			}
		});
		
		mAboutPostcodeButton = (ImageButton)findViewById(R.id.about_postcode);
		mAboutPostcodeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutPostcode();
				
			}
		});
		
		mAboutAdminStatusButton = (ImageButton)findViewById(R.id.about_admin_status);
		mAboutAdminStatusButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutAdminStatus();
				
			}
		});
		
		mAboutPlaceEcgButton = (ImageButton)findViewById(R.id.about_place_ecg_performed);
		mAboutPlaceEcgButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutPlaceEcgPerformed();
				
			}
		});
		
		// wire up page navigation buttons
		mPreviousPage = (Button)findViewById(R.id.previous_page_button);
		mPreviousPage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.previousPage();
				
			}
		});
		
		mNextPage = (Button)findViewById(R.id.next_page_button);
		mNextPage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.nextPage();
				
			}
		});
	}
}
