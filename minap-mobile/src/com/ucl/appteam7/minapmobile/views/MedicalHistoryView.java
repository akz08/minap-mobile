package com.ucl.appteam7.minapmobile.views;

import com.ucl.appteam7.minapmobile.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class MedicalHistoryView extends ScrollView {

	private ImageButton mAboutPreviousAmiButton;
	private ImageButton mAboutHypertensionButton;
	private ImageButton mAboutCerebroDiseaseButton;
	private ImageButton mAboutPreviousPCIButton;
	private ImageButton mAboutSmokingStatusButton;
	private ImageButton mAboutDiabetesButton;
	
	private ImageButton mAboutPreviousAnginaButton;
	private ImageButton mAboutHypercholButton;
	private ImageButton mAboutAsthmaCopdButton;
	private ImageButton mAboutPreviousCabgButton;
	
	private ImageButton mAboutHeartFailureButton;
	private ImageButton mAboutPeripheralVascularDiseaseButton;
	private ImageButton mAboutChronicRenalFailureButton;
	private ImageButton mAboutFamilyHistoryOfChdButton;
	
	private Button mPreviousPage;
	private Button mNextPage;
	
	// Define methods that the fragment needs to implement
	public static interface ViewListener {
		
		// about dialogs
		public void showAboutPreviousAmi();
		public void showAboutHypertension();
		public void showAboutCerebroDisease();
		public void showAboutPreviousPCI();
		public void showAboutSmokingStatus();
		public void showAboutDiabetes();
		
		public void showAboutPreviousAngina();
		public void showAboutHyperchol();
		public void showAboutAsthmaCopd();
		public void showAboutPreviousCabg();
		
		public void showAboutHeartFailure();
		public void showAboutPeripheralVascularDisease();
		public void showAboutChronicRenalFailure();
		public void showAboutFamilyHistoryOfChd();
		
		// navigation buttons
		public void previousPage();
		public void nextPage();
	}
	
	// Set up view listener
	private ViewListener viewListener;
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public MedicalHistoryView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	// Wire up layout elements to objects
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		// wire up 'about' information buttons
		mAboutPreviousAmiButton = (ImageButton)findViewById(R.id.about_previous_ami);
		mAboutPreviousAmiButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutPreviousAmi();
				
			}
		});
		
		mAboutHypertensionButton = (ImageButton)findViewById(R.id.about_hypertension);
		mAboutHypertensionButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutHypertension();
				
			}
		});
		
		mAboutCerebroDiseaseButton = (ImageButton)findViewById(R.id.about_cerebrovascular_disease);
		mAboutCerebroDiseaseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutCerebroDisease();
				
			}
		});
		
		mAboutPreviousPCIButton = (ImageButton)findViewById(R.id.about_previous_pci);
		mAboutPreviousPCIButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutPreviousPCI();
				
			}
		});
		
		mAboutSmokingStatusButton = (ImageButton)findViewById(R.id.about_smoking_status);
		mAboutSmokingStatusButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutSmokingStatus();
				
			}
		});
		
		mAboutDiabetesButton = (ImageButton)findViewById(R.id.about_diabetes);
		mAboutDiabetesButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutDiabetes();
				
			}
		});
		
		mAboutPreviousAnginaButton = (ImageButton)findViewById(R.id.about_previous_angina);
		mAboutPreviousAnginaButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutPreviousAngina();
				
			}
		});
		
		mAboutHypercholButton = (ImageButton)findViewById(R.id.about_hypercholesterolaemia);
		mAboutHypercholButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutHyperchol();
				
			}
		});
		
		mAboutAsthmaCopdButton = (ImageButton)findViewById(R.id.about_asthma_copd);
		mAboutAsthmaCopdButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutAsthmaCopd();
				
			}
		});
		
		mAboutPreviousCabgButton = (ImageButton)findViewById(R.id.about_previous_cabg);
		mAboutPreviousCabgButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutPreviousCabg();
				
			}
		});
		
		mAboutHeartFailureButton = (ImageButton)findViewById(R.id.about_heart_failure);
		mAboutHeartFailureButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutHeartFailure();
				
			}
		});
		
		mAboutPeripheralVascularDiseaseButton = (ImageButton)findViewById(R.id.about_peripheral_vascular_disease);
		mAboutPeripheralVascularDiseaseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutPeripheralVascularDisease();
				
			}
		});
		
		mAboutChronicRenalFailureButton = (ImageButton)findViewById(R.id.about_chronic_renal_failure);
		mAboutChronicRenalFailureButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutChronicRenalFailure();
				
			}
		});
		
		mAboutFamilyHistoryOfChdButton = (ImageButton)findViewById(R.id.about_family_history_of_chd);
		mAboutFamilyHistoryOfChdButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListener.showAboutFamilyHistoryOfChd();
				
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
