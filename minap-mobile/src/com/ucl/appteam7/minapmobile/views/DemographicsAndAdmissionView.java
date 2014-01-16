package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.ucl.appteam7.minapmobile.R;

public class DemographicsAndAdmissionView extends ScrollView {
	
	private Spinner mAdmissionMethodSpinner;
	
	private Button mPreviousPage;
	private Button mNextPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
		
		// hidden values
		public void showReferralHospital();
		public void hideReferralHospital();
		
		// about buttons
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
