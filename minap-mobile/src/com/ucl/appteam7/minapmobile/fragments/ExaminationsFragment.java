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

import com.testflightapp.lib.TestFlight;
import com.ucl.appteam7.minapmobile.R;
import com.ucl.appteam7.minapmobile.activities.InitialReperfusionActivity;
import com.ucl.appteam7.minapmobile.activities.MedicalHistoryActivity;
import com.ucl.appteam7.minapmobile.model.Patient;
import com.ucl.appteam7.minapmobile.views.ExaminationsView;

public class ExaminationsFragment extends Fragment {
	private static final String CHECKPOINT_EXAMINATIONS = "Examinations";
	
	// get the patient singleton
	Patient patient = Patient.get();
	
	private static final String DIALOG_ABOUT = "about";
	
	private Spinner mKillipClassSpinner;
	
	private ExaminationsView view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		// TestFlight checkpoint
		TestFlight.passCheckpoint(CHECKPOINT_EXAMINATIONS);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		view = (ExaminationsView)View.inflate(getActivity(), R.layout.fragment_examinations, null);
		view.setViewListener(viewListener);
		
		// Populate the Killip Class spinner
		mKillipClassSpinner = (Spinner)view.findViewById(R.id.killip_class_spinner);
		ArrayAdapter<CharSequence> killipAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.killip_class_array, R.layout.multiline_spinner_item);
		killipAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mKillipClassSpinner.setAdapter(killipAdapter);
		
		// setup action bar 
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return view;
	}
	
	private ExaminationsView.ViewListener viewListener = new ExaminationsView.ViewListener() {
		
		@Override
		public void previousPage() {
			// simply go to the previous page
			Intent intent = new Intent(getActivity(), InitialReperfusionActivity.class);
			startActivity(intent);
			
		}
		
		@Override
		public void nextPage() {
			// simply go to the next page
			Intent intent = new Intent(getActivity(), MedicalHistoryActivity.class);
			startActivity(intent);
			
		}

		@Override
		public void showAboutSystolicBp() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.Systolic.getNotesTitle() + " " + patient.Systolic.getId(), patient.Systolic.getNotes());
			dialog.show(fm, DIALOG_ABOUT);	
			
		}

		@Override
		public void showAboutHeartRateOnAdmission() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.HeartRate.getNotesTitle() + " " + patient.HeartRate.getId(), patient.HeartRate.getNotes());
			dialog.show(fm, DIALOG_ABOUT);	
			
		}

		@Override
		public void showAboutKillipClass() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.Killip.getNotesTitle() + " " + patient.Killip.getId(), patient.Killip.getNotes());
			dialog.show(fm, DIALOG_ABOUT);	
			
		}

		@Override
		public void showAboutWeight() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.Weight.getNotesTitle() + " " + patient.Weight.getId(), patient.Weight.getNotes());
			dialog.show(fm, DIALOG_ABOUT);	
			
		}

		@Override
		public void showAboutHeight() {
			FragmentManager fm = getActivity()
					.getSupportFragmentManager();
			AboutDialogFragment dialog = AboutDialogFragment
					.newInstance(patient.Height.getNotesTitle() + " " + patient.Height.getId(), patient.Height.getNotes());
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
