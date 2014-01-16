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
import android.widget.Spinner;
import android.widget.Toast;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.DemographicsAndAdmissionActivity;
import com.ucl.appteam7.minapmobile.activities.InitialReperfusionActivity;
import com.ucl.appteam7.minapmobile.views.PrehospitalEventsView;

public class PrehospitalEventsFragment extends Fragment {
	
	private static final String DIALOG_ABOUT = "about";
	private static final String DIALOG_DATE = "date";
	private static final String DIALOG_TIME = "time";
	
	private Spinner mAmbulanceTrustCodeSpinner;
	
	private PrehospitalEventsView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (PrehospitalEventsView)View.inflate(getActivity(), R.layout.fragment_prehospital_events, null);
		view.setViewListener(viewListener);
		
		// Populate the Trust Code spinner
		mAmbulanceTrustCodeSpinner = (Spinner)view.findViewById(R.id.ambulance_trust_code_spinner);
		ArrayAdapter<CharSequence> codeAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.ambulance_trust_code_array, R.layout.multiline_spinner_item);
		codeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mAmbulanceTrustCodeSpinner.setAdapter(codeAdapter);
		
		// setup action bar 
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private PrehospitalEventsView.ViewListener viewListener = new PrehospitalEventsView.ViewListener() {

		@Override
		public void showAboutOnsetOfSymptoms() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);		
			
		}

		@Override
		public void showAboutCallForHelpButton() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);		
			
		}

		@Override
		public void showAboutArrivalFirstResponderButton() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);		
			
		}

		@Override
		public void showAboutArrivalAmbulanceButton() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);		
			
		}

		@Override
		public void showAboutAmbulanceTrustCodeButton() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);		
			
		}

		@Override
		public void showAboutAmbulancePrfCadNumberButton() {
			// TODO: Replace title and content with calls to the model
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance("Dummy Title", "dummy content");
			dialog.show(fm, DIALOG_ABOUT);		
			
		}

		@Override
		public void onOnsetDate() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_onset_of_symptoms));
			dialog.show(fm, DIALOG_DATE);
			
		}

		@Override
		public void onOnsetTime() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			TimePickerFragment dialog = TimePickerFragment
					.newInstance(getString(R.string.value_time_picker_title_onset_of_symptoms));
			dialog.show(fm, DIALOG_TIME);
			
		}

		@Override
		public void onCallDate() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_call_for_help));
			dialog.show(fm, DIALOG_DATE);
			
		}

		@Override
		public void onCallTime() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			TimePickerFragment dialog = TimePickerFragment
					.newInstance(getString(R.string.value_time_picker_title_call_for_help));
			dialog.show(fm, DIALOG_TIME);
			
		}

		@Override
		public void onArrivalResponderDate() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_arrival_first_responder));
			dialog.show(fm, DIALOG_DATE);
			
		}

		@Override
		public void onArrivalResponderTime() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			TimePickerFragment dialog = TimePickerFragment
					.newInstance(getString(R.string.value_time_picker_title_arrival_first_responder));
			dialog.show(fm, DIALOG_TIME);
			
		}

		@Override
		public void onArrivalAmbulanceDate() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_arrival_ambulance));
			dialog.show(fm, DIALOG_DATE);
			
		}

		@Override
		public void onArrivalAmbulanceTime() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			TimePickerFragment dialog = TimePickerFragment
					.newInstance(getString(R.string.value_time_picker_title_arrival_ambulance));
			dialog.show(fm, DIALOG_TIME);
			
		}
			
		@Override
		public void previousPage() {
			// simply go to the previous page
			Intent intent = new Intent(getActivity(), DemographicsAndAdmissionActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void nextPage() {
			// simply go to the next page
			Intent intent = new Intent(getActivity(), InitialReperfusionActivity.class);
			startActivity(intent);
			
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
