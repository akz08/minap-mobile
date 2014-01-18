package com.ucl.appteam7.minapmobile.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;

import com.ucl.appteam7.minapmobile.R;

public class InitialReperfusionView extends ScrollView {
	
	private RadioGroup mInitialReperfusionTreatmentRadioGroup;
	
	private ImageButton mAboutInitialReperfusionButton;
	
	private Button mPreviousPage;
	private Button mNextPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
		
		// hidden values
		public void showReasonTreatmentNotGiven();
		public void hideReasonTreatmentNotGiven();
		public void showGeneralReperfusion();
		public void hideGeneralReperfusion();
		public void showInterventionalCentre();
		public void hideInterventionalCentre();
		public void showSiteOfInfarction();
		public void hideSiteOfInfarction();
		
		// about dialogs
		public void showAboutInitialReperfusion();
		public void showAboutReasonTreatmentNotGiven();
		public void showAboutInterventionalCentre();
		public void showAboutEcgDeterminingTreatment();
		public void showAboutPatientLocation();
		public void showAboutEcgQrsDuration();
		public void showAboutSiteOfInfarction();
		
		// navigation buttons
		public void previousPage();
		public void nextPage();
	}
	
	// Set up view listener
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public InitialReperfusionView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// Wire up layout elements to objects
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		// Wire up Initial Reperfusion radio group
		mInitialReperfusionTreatmentRadioGroup = (RadioGroup)findViewById(R.id.radio_group_initial_reperfusion_treatment);
		mInitialReperfusionTreatmentRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// hide all layouts first to avoid exception from child already having a parent
				// ideally, this would be checked in more robust ways
				switch(checkedId) {
				case R.id.radio_initial_reperfusion_treatment_0:
					viewListener.hideReasonTreatmentNotGiven();
					viewListener.hideInterventionalCentre();
					viewListener.hideGeneralReperfusion();
					viewListener.hideSiteOfInfarction();
					
					viewListener.showGeneralReperfusion();
					viewListener.showReasonTreatmentNotGiven();
					break;
				case R.id.radio_initial_reperfusion_treatment_1:
					viewListener.hideReasonTreatmentNotGiven();
					viewListener.hideInterventionalCentre();
					viewListener.hideGeneralReperfusion();
					viewListener.hideSiteOfInfarction();
					
					viewListener.showSiteOfInfarction();
					viewListener.showGeneralReperfusion();
					break;
				case R.id.radio_initial_reperfusion_treatment_2:
					viewListener.hideReasonTreatmentNotGiven();
					viewListener.hideInterventionalCentre();
					viewListener.hideGeneralReperfusion();
					viewListener.hideSiteOfInfarction();
					
					viewListener.showSiteOfInfarction();
					viewListener.showGeneralReperfusion();

					break;
				case R.id.radio_initial_reperfusion_treatment_3:
					viewListener.hideReasonTreatmentNotGiven();
					viewListener.hideInterventionalCentre();
					viewListener.hideGeneralReperfusion();
					viewListener.hideSiteOfInfarction();
					
					viewListener.showSiteOfInfarction();
					viewListener.showGeneralReperfusion();
					viewListener.showInterventionalCentre();
					break;
				case R.id.radio_initial_reperfusion_treatment_4:
					viewListener.hideReasonTreatmentNotGiven();
					viewListener.hideInterventionalCentre();
					viewListener.hideGeneralReperfusion();
					viewListener.hideSiteOfInfarction();
					
					viewListener.showSiteOfInfarction();
					viewListener.showGeneralReperfusion();
					viewListener.showInterventionalCentre();
					break;
				case R.id.radio_initial_reperfusion_treatment_9:
					viewListener.hideReasonTreatmentNotGiven();
					viewListener.hideInterventionalCentre();
					viewListener.hideGeneralReperfusion();
					viewListener.hideSiteOfInfarction();
					
					viewListener.showSiteOfInfarction();
					viewListener.showGeneralReperfusion();
					break;
				}
				
			}
		});
		
		// wire up 'about' button
		mAboutInitialReperfusionButton = (ImageButton)findViewById(R.id.about_initial_reperfusion);
		mAboutInitialReperfusionButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutInitialReperfusion();
				
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
