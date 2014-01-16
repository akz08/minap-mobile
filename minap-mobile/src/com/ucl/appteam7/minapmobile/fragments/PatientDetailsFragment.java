package com.ucl.appteam7.minapmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.NavigationMapActivity;
import com.ucl.appteam7.minapmobile.views.PatientDetailsView;

public class PatientDetailsFragment extends Fragment {
	public static final String EXTRA_FOCUS_HOSPITAL_NUMBER = "com.ucl.appteam7.minapmobile.EXTRA_FOCUS_HOSPITAL_NUMBER";

	private static final String DIALOG_DATE = "date";
	private static final String DIALOG_TIME = "time";
	
	private PatientDetailsView view;
	
	private Spinner mHospitalSpinner;

	public static PatientDetailsFragment newInstance(boolean focusHospitalNumber) {
		// get the extra from the bundle
		Bundle args = new Bundle();
		args.putBoolean(EXTRA_FOCUS_HOSPITAL_NUMBER, focusHospitalNumber);
		
		PatientDetailsFragment fragment = new PatientDetailsFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);		
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (PatientDetailsView)View.inflate(getActivity(), R.layout.fragment_patient_details, null);
		view.setViewListener(viewListener);
		
		// Populate the Hospital Name spinner
		mHospitalSpinner = (Spinner)view.findViewById(R.id.hospitals_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.hospitals_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mHospitalSpinner.setAdapter(adapter);
		
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		// retrieve flag from bundle if hospital number should be focused
		boolean focusHospitalNumber = (boolean)getArguments().getBoolean(EXTRA_FOCUS_HOSPITAL_NUMBER);
		if (focusHospitalNumber) {
			view.setFocusHospitalCRN();
		}	
	}
	
	// receive events from view
	private PatientDetailsView.ViewListener viewListener = new PatientDetailsView.ViewListener() {
		
		@Override
		public void onConfirm() {
			// TODO pass the username and patient identifier as an extra to NavigationMapActivity
			// Link the Confirm button to SIMPLY open NavigationMapActivity
			Intent intent = new Intent(getActivity(), NavigationMapActivity.class);
			// call the model to find out if this is the user's first use
			boolean firstTimeUser = true;
			intent.putExtra(NavigationMapActivity.EXTRA_OPEN_NAV_DRAWER, firstTimeUser);
			startActivity(intent);
		}
		
		@Override
		public void onBirthDate() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_date_of_birth));
			dialog.show(fm, DIALOG_DATE);

		}
		
		@Override
		public void onAdmissionTime() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			TimePickerFragment dialog = TimePickerFragment
					.newInstance(getString(R.string.value_time_picker_title_admission_time));
			dialog.show(fm, DIALOG_TIME);
			
		}
		
		@Override
		public void onAdmissionDate() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			DatePickerFragment dialog = DatePickerFragment
					.newInstance(getString(R.string.value_date_picker_title_admission_date));
			dialog.show(fm, DIALOG_DATE);
			
		}
	};
	

	
	// hook up options menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_item_save:
				
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
