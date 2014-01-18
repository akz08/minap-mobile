package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.ExaminationsActivity;
import com.ucl.appteam7.minapmobile.activities.PrehospitalEventsActivity;
import com.ucl.appteam7.minapmobile.views.InitialReperfusionView;

public class InitialReperfusionFragment extends Fragment {
	
	private static final String DIALOG_ABOUT = "about";
	
	private Spinner mReasonTreatmentNotGivenSpinner;
	private Spinner mInterventionalCentreSpinner;
	private Spinner mEcgDeterminingSpinner;
	private Spinner mPatientLocationSpinner;
	private Spinner mSiteOfInfarctionSpinner;
	private Spinner mEcgQrsDurationSpinner;
	
	private ImageButton mAboutReasonTreatmentNotGivenButton;
	private ImageButton mAboutInterventionalCentreButton;
	private ImageButton mAboutEcgDeterminingButton;
	private ImageButton mAboutPatientLocationButton;
	private ImageButton mAboutSiteOfInfarctionButton;
	private ImageButton mAboutEcgQrsDurationButton;
	
	// ViewGroups to handle hidden fields
	private ViewGroup mContainerView;
	private ViewGroup mHiddenReasonTreatmentNotGiven;
	private ViewGroup mHiddenInterventionalCentre;
	private ViewGroup mHiddenGroupGeneralInitialReperfusion;
	private ViewGroup mHiddenSiteOfInfarction;
	
	private InitialReperfusionView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (InitialReperfusionView)View.inflate(getActivity(), R.layout.fragment_initial_reperfusion, null);
		view.setViewListener(viewListener);
		
		// Setup hidden views
		mContainerView = (ViewGroup) view.findViewById(R.id.container);
		mHiddenReasonTreatmentNotGiven = (ViewGroup) inflater.inflate(R.layout.hidden_reason_treatment_not_given, mContainerView, false);
		mHiddenInterventionalCentre = (ViewGroup) inflater.inflate(R.layout.hidden_interventional_centre, mContainerView, false);
		mHiddenGroupGeneralInitialReperfusion = (ViewGroup) inflater.inflate(R.layout.hidden_group_general_initial_reperfusion, mContainerView, false);
		mHiddenSiteOfInfarction = (ViewGroup) inflater.inflate(R.layout.hidden_site_of_infarction, mContainerView, false);
		
		// setup action bar 
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private InitialReperfusionView.ViewListener viewListener = new InitialReperfusionView.ViewListener() {
		
		@Override
		public void previousPage() {
			// simply go to the previous page
			Intent intent = new Intent(getActivity(), PrehospitalEventsActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void nextPage() {
			// simply go to the next page
			Intent intent = new Intent(getActivity(), ExaminationsActivity.class);
			startActivity(intent);
			
		}

		@Override
		public void showReasonTreatmentNotGiven() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_initial_reperfusion_treatment));
			mContainerView.addView(mHiddenReasonTreatmentNotGiven, viewIndex + 1);
			
			// Populate the Referral Hospital spinner
			mReasonTreatmentNotGivenSpinner = (Spinner)getView().findViewById(R.id.reason_treatment_not_given_spinner);
			ArrayAdapter<CharSequence> treatmentAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.reason_treatment_not_given_array, R.layout.multiline_spinner_item);
			treatmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mReasonTreatmentNotGivenSpinner.setAdapter(treatmentAdapter);
			
			// Wire up 'about' buttons
			mAboutReasonTreatmentNotGivenButton = (ImageButton) view.findViewById(R.id.about_reason_treatment_not_given);
			mAboutReasonTreatmentNotGivenButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutReasonTreatmentNotGiven();
				}
			});
			
		}

		@Override
		public void hideReasonTreatmentNotGiven() {
			mContainerView.removeView(mHiddenReasonTreatmentNotGiven);
			
		}

		@Override
		public void showGeneralReperfusion() {
			// add the hidden view
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_initial_reperfusion_treatment));
			mContainerView.addView(mHiddenGroupGeneralInitialReperfusion, viewIndex + 1);
			
			// Populate the ECG Determining Treatment spinner
			mEcgDeterminingSpinner = (Spinner)getView().findViewById(R.id.ecg_determining_treatment_spinner);
			ArrayAdapter<CharSequence> determiningAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.ecg_determining_treatment_array, R.layout.multiline_spinner_item);
			determiningAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mEcgDeterminingSpinner.setAdapter(determiningAdapter);
			
			// Populate the Patient Location spinner
			mPatientLocationSpinner = (Spinner)getView().findViewById(R.id.patient_location_time_stemi_onset_spinner);
			ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.patient_location_time_stemi_onset_array, R.layout.multiline_spinner_item);
			locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mPatientLocationSpinner.setAdapter(locationAdapter);
			
			// Populate the ECG QRS Duration spinner
			mEcgQrsDurationSpinner = (Spinner)getView().findViewById(R.id.ecg_qrs_duration_spinner);
			ArrayAdapter<CharSequence> qrsAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.ecg_qrs_duration_array, R.layout.multiline_spinner_item);
			qrsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mEcgQrsDurationSpinner.setAdapter(qrsAdapter);
			
			// Wire up 'about' buttons
			mAboutEcgDeterminingButton = (ImageButton) view.findViewById(R.id.about_ecg_determining_treatment);
			mAboutEcgDeterminingButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutEcgDeterminingTreatment();
				}
			});
			
			mAboutPatientLocationButton = (ImageButton) view.findViewById(R.id.about_patient_location_time_stemi_onset);
			mAboutPatientLocationButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutPatientLocation();
				}
			});
			
			mAboutEcgQrsDurationButton = (ImageButton) view.findViewById(R.id.about_ecg_qrs_duration);
			mAboutEcgQrsDurationButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutEcgQrsDuration();
				}
			});
		}

		@Override
		public void hideGeneralReperfusion() {
			mContainerView.removeView(mHiddenGroupGeneralInitialReperfusion);
			
		}

		@Override
		public void showInterventionalCentre() {
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_initial_reperfusion_treatment));
			mContainerView.addView(mHiddenInterventionalCentre, viewIndex + 1);
			
			// Populate the Interventional Centre spinner
			mInterventionalCentreSpinner = (Spinner)getView().findViewById(R.id.interventional_centre_spinner);
			ArrayAdapter<CharSequence> centreAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hospitals_array, R.layout.multiline_spinner_item);
			centreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mInterventionalCentreSpinner.setAdapter(centreAdapter);
			
			// Wire up 'about' buttons
			mAboutInterventionalCentreButton = (ImageButton) view.findViewById(R.id.about_interventional_centre);
			mAboutInterventionalCentreButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutInterventionalCentre();
				}
			});
		}

		@Override
		public void hideInterventionalCentre() {
			mContainerView.removeView(mHiddenInterventionalCentre);
			
		}

		@Override
		public void showSiteOfInfarction() {
			int viewIndex = mContainerView.indexOfChild(getView().findViewById(R.id.radio_group_initial_reperfusion_treatment));
			mContainerView.addView(mHiddenSiteOfInfarction, viewIndex + 1);
			
			// Populate the Site of Infarction spinner
			mSiteOfInfarctionSpinner = (Spinner)getView().findViewById(R.id.site_of_infarction_spinner);
			ArrayAdapter<CharSequence> siteAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.site_of_infarction_array, R.layout.multiline_spinner_item);
			siteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mSiteOfInfarctionSpinner.setAdapter(siteAdapter);
			
			// Wire up 'about' buttons
			mAboutSiteOfInfarctionButton = (ImageButton) view.findViewById(R.id.about_site_of_infarction);
			mAboutSiteOfInfarctionButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showAboutSiteOfInfarction();
				}
			});
		}

		@Override
		public void hideSiteOfInfarction() {
			mContainerView.removeView(mHiddenSiteOfInfarction);
			
		}

		@Override
		public void showAboutReasonTreatmentNotGiven() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutInterventionalCentre() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutEcgDeterminingTreatment() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutPatientLocation() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutEcgQrsDuration() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}

		@Override
		public void showAboutSiteOfInfarction() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);			
			
		}
	};
	
	// inflate save button in action menu
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_value, menu);
		
	}
	
	// setup options menu save action
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_item_save:
				//TODO: save items on page to server
				Toast.makeText(getActivity(), R.string.saving, Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}
