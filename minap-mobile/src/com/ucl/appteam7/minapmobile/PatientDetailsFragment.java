package com.ucl.appteam7.minapmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PatientDetailsFragment extends Fragment {
	
	private static final String DIALOG_DATE = "date";
	private static final String DIALOG_TIME = "time";
	
	Spinner mHospitalSpinner;
	Button mConfirmButton;
	TextView mDateOfBirthTextView;
	TextView mAdmissionDateTextView;
	TextView mAdmissionTimeTextView;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_patient_details, parent, false);
		
		// Add on-click listeners to date and time TextViews
		mDateOfBirthTextView = (TextView)view.findViewById(R.id.date_of_birth);
		mDateOfBirthTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity()
						.getSupportFragmentManager();
				DatePickerFragment dialog = DatePickerFragment
						.newInstance(getString(R.string.value_date_picker_title_date_of_birth));
				dialog.show(fm, DIALOG_DATE);
				
			}
		});
		
		mAdmissionDateTextView = (TextView)view.findViewById(R.id.admission_date);
		mAdmissionDateTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity()
						.getSupportFragmentManager();
				DatePickerFragment dialog = DatePickerFragment
						.newInstance(getString(R.string.value_date_picker_title_admission_date));
				dialog.show(fm, DIALOG_DATE);
				
			}
		});
		
		mAdmissionTimeTextView = (TextView)view.findViewById(R.id.admission_time);
		mAdmissionTimeTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity()
						.getSupportFragmentManager();
				TimePickerFragment dialog = TimePickerFragment
						.newInstance(getString(R.string.value_time_picker_title_admission_time));
				dialog.show(fm, DIALOG_TIME);
				
			}
		});
		
		// Populate the hospital name spinner
		mHospitalSpinner = (Spinner)view.findViewById(R.id.hospitals_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.hospitals_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mHospitalSpinner.setAdapter(adapter);
		
		// TODO pass the username and patient identifier as an extra to NavigationMapActivity
		// Link the Confirm button to SIMPLY open NavigationMapActivity
		mConfirmButton = (Button)view.findViewById(R.id.confirm_button);
		mConfirmButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), NavigationMapActivity.class);
				// call the model to find out if this is the user's first use
				boolean firstTimeUser = true;
				intent.putExtra(NavigationMapActivity.EXTRA_FIRST_LOGIN, firstTimeUser);
				startActivity(intent);
			}
		});
		
		
		return view;
	}
}
